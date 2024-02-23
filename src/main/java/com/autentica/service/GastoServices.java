package com.autentica.service;

import com.autentica.domain.Gasto;
import com.autentica.domain.Personas;
import com.autentica.dto.BalancePersonaDTO;
import com.autentica.dto.DeudaDTO;
import com.autentica.dto.InfoGastoDTO;
import com.autentica.repository.GastoRepository;
import com.autentica.repository.PersonasRepository;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class GastoServices {
    private GastoRepository gastoRepository;
    private PersonasRepository personasRepository;

    public GastoServices(GastoRepository gastoRepository, PersonasRepository personasRepository) {
        this.gastoRepository = gastoRepository;
        this.personasRepository = personasRepository;
    }

    public List<Gasto> findAllGastos(){
        return gastoRepository.findAll();
    }

    public @NonNull Optional<List<InfoGastoDTO>> getGastoByUsuario(Long personaId) {

        if (personasRepository.existsById(personaId)){
            Optional<Personas> personas = personasRepository.findById(personaId);
            List<Gasto> gastos = gastoRepository.findByPersonaIdOrderByFechaPagoAsc(personaId);

            if (!gastos.isEmpty()){
                List<InfoGastoDTO> data = gastos.stream()
                        .map( gasto -> new InfoGastoDTO(
                                personas.get().getNombre(),
                                gasto.getImporte(),
                                gasto.getDescripcion(),
                                gasto.getFechaPago()))
                        .collect(Collectors.toList());

                return Optional.of(data);
            }
        }else {
            return Optional.empty();
        }
        return Optional.empty();
    }

    public @NonNull Gasto crearGasto(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    public List<BalancePersonaDTO>  getBalanceGrupo(Long grupoId) {

        List<Gasto> gastosGrupo = gastoRepository.getGastosPorGrupo(grupoId);
        List<Personas> personasGrupo = personasRepository.findByGrupoId(grupoId);

        BigDecimal total = gastosGrupo.stream().map(Gasto::getImporte).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalPersona = total.divide(BigDecimal.valueOf(personasGrupo.size()),2);

        Map<Long, BigDecimal> totalGastoPersona = gastosGrupo.stream()
                .collect(Collectors.groupingBy(
                        Gasto::getPersonaId,
                        Collectors.reducing(BigDecimal.ZERO, Gasto::getImporte, BigDecimal::add)
                        ));

        List<BalancePersonaDTO> balances = personasGrupo.stream().map(
                personas -> new BalancePersonaDTO(
                        personas.getGrupoId(),
                        personas.getId(),
                        personas.getNombre(),
                        total,
                        total.divide(BigDecimal.valueOf(personasGrupo.size()),2),
                        totalGastoPersona.getOrDefault(personas.getId(),BigDecimal.ZERO),
                        totalPersona.subtract(totalGastoPersona.getOrDefault(personas.getId(),BigDecimal.ZERO))
                )).collect(Collectors.toList());


        return balances;
    }

    public List<DeudaDTO> getDeudaGrupo(Long grupoId) {

        List<BalancePersonaDTO>  balancesGrupo = getBalanceGrupo(grupoId);

        List<DeudaDTO> deudas = new ArrayList<>();

        for (BalancePersonaDTO bPositivo : balancesGrupo ) {
            for (BalancePersonaDTO bNegativo : balancesGrupo ) {
                if (bPositivo.getBalance().compareTo(BigDecimal.ZERO) > 0
                        && bNegativo.getBalance().compareTo(BigDecimal.ZERO) < 0) {

                    BigDecimal importeDeuda = bPositivo.getBalance().min(bNegativo.getBalance().abs());

                    DeudaDTO deuda = new DeudaDTO(
                            bPositivo.getPersonaId(),bPositivo.getNombre(),importeDeuda,bNegativo.getPersonaId(), bNegativo.getNombre()
                    );
                    deudas.add(deuda);
                }
            }
        }
        return deudas;
    }
}
