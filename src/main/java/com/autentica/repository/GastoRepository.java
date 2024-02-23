package com.autentica.repository;

import com.autentica.domain.Gasto;
import com.autentica.dto.InfoGastoDTO;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface GastoRepository extends CrudRepository<Gasto, Long> {

    List<Gasto> findByPersonaIdOrderByFechaPagoAsc(Long personaId);

    @Query(value = "select g.* from gastos g join personas p on (g.persona_id=p.persona_id) where p.grupo_id = :grupoId", nativeQuery = true)
    List<Gasto> getGastosPorGrupo(Long grupoId);


}
