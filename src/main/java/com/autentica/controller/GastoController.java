package com.autentica.controller;

import com.autentica.domain.Gasto;
import com.autentica.dto.BalancePersonaDTO;
import com.autentica.dto.DeudaDTO;
import com.autentica.dto.InfoGastoDTO;
import com.autentica.service.GastoServices;
import io.micronaut.http.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller("/gastos")
public class GastoController {

    private GastoServices gastoServices;

    public GastoController(GastoServices gastoServices) {
        this.gastoServices = gastoServices;
    }

    @Get("/")
    public List<Gasto> getAllGastos(){
        return gastoServices.findAllGastos();
    }


    @Post("/")
    public Gasto crearGasto (@Body Gasto gasto) {
        return gastoServices.crearGasto(gasto);
    }

    @Get("/listado")
    public Optional<List<InfoGastoDTO>> getListadoGastoByUsuario(@QueryValue Long personaId) {
        return gastoServices.getGastoByUsuario(personaId);
    }

    @Get("/balance")
    public List<BalancePersonaDTO>  getBalanceGrupo(@QueryValue Long grupoId) {
        return gastoServices.getBalanceGrupo(grupoId);
    }

    @Get("/deuda")
    public List<DeudaDTO>  getDeudaGrupo(@QueryValue Long grupoId) {
        return gastoServices.getDeudaGrupo(grupoId);
    }

}
