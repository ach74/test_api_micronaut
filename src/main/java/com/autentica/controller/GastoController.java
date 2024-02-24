package com.autentica.controller;

import com.autentica.domain.Gasto;
import com.autentica.dto.BalancePersonaDTO;
import com.autentica.dto.DeudaDTO;
import com.autentica.dto.InfoGastoDTO;
import com.autentica.service.GastoServices;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;


import java.util.List;
import java.util.Optional;


@Controller("api/gastos")
public class GastoController {

    private GastoServices gastoServices;

    public GastoController(GastoServices gastoServices) {
        this.gastoServices = gastoServices;
    }

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Gasto> getAllGastos() {
        List<Gasto> gastos = gastoServices.findAllGastos();
        return gastos;
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
    @Produces(MediaType.APPLICATION_JSON)
    public List<BalancePersonaDTO>  getBalanceGrupo(@QueryValue Long grupoId) {
        return gastoServices.getBalanceGrupo(grupoId);
    }

    @Get("/deuda")
    public List<DeudaDTO>  getDeudaGrupo(@QueryValue Long grupoId) {
        return gastoServices.getDeudaGrupo(grupoId);
    }

}
