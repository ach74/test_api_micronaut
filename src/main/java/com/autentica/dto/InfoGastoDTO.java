package com.autentica.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.math.BigDecimal;
import java.time.LocalDate;

@Introspected
@Serdeable
public class InfoGastoDTO {

    private String nombrePersona;
    private BigDecimal importe;
    private String descripcion;
    private LocalDate fechaPago;

    public InfoGastoDTO() {
    }

    public InfoGastoDTO(String nombrePersona, BigDecimal importe, String descripcion, LocalDate fechaPago) {
        this.nombrePersona = nombrePersona;
        this.importe = importe;
        this.descripcion = descripcion;
        this.fechaPago = fechaPago;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
}
