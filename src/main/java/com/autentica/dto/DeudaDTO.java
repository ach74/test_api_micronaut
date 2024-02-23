package com.autentica.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.math.BigDecimal;

@Introspected
@Serdeable
public class DeudaDTO {

    private Long origenId;

    private String nombreOrigen;

    private BigDecimal totalDeuda;

    private Long destinoId;

    private String nombreDestino;

    public DeudaDTO() {
    }

    public Long getOrigenId() {
        return origenId;
    }

    public DeudaDTO(Long origenId, String nombreOrigen, BigDecimal totalDeuda, Long destinoId, String nombreDestino) {
        this.origenId = origenId;
        this.nombreOrigen = nombreOrigen;
        this.totalDeuda = totalDeuda;
        this.destinoId = destinoId;
        this.nombreDestino = nombreDestino;
    }

    public void setOrigenId(Long origenId) {
        this.origenId = origenId;
    }

    public String getNombreOrigen() {
        return nombreOrigen;
    }

    public void setNombreOrigen(String nombreOrigen) {
        this.nombreOrigen = nombreOrigen;
    }

    public BigDecimal getTotalDeuda() {
        return totalDeuda;
    }

    public void setTotalDeuda(BigDecimal totalDeuda) {
        this.totalDeuda = totalDeuda;
    }

    public Long getDestinoId() {
        return destinoId;
    }

    public void setDestinoId(Long destinoId) {
        this.destinoId = destinoId;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }
}
