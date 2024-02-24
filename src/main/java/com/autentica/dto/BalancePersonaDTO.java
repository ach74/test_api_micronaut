package com.autentica.dto;


import com.autentica.domain.Personas;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.math.BigDecimal;
import java.util.List;

@Introspected
@Serdeable
public class BalancePersonaDTO {

    @JsonProperty("group_Id")
    private Long group_Id;

    @JsonProperty("personaId")
    private Long personaId;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("importeTotalGrupo")
    private BigDecimal importeTotalGrupo;

    @JsonProperty("importeProporcionalPersona")
    private BigDecimal importeProporcionalPersona;
    @JsonProperty("saldoAportado")
    private BigDecimal saldoAportado;

    @JsonProperty("balance")
    private BigDecimal balance;


    public BalancePersonaDTO() {
    }

    public BalancePersonaDTO(Long group_Id, Long personaId, String nombre, BigDecimal importeTotalGrupo, BigDecimal importeProporcionalPersona, BigDecimal saldoAportado, BigDecimal balance) {
        this.group_Id = group_Id;
        this.personaId = personaId;
        this.nombre = nombre;
        this.importeTotalGrupo = importeTotalGrupo;
        this.importeProporcionalPersona = importeProporcionalPersona;
        this.saldoAportado = saldoAportado;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getGroup_Id() {
        return group_Id;
    }

    public void setGroup_Id(Long group_Id) {
        this.group_Id = group_Id;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getImporteTotalGrupo() {
        return importeTotalGrupo;
    }

    public void setImporteTotalGrupo(BigDecimal importeTotalGrupo) {
        this.importeTotalGrupo = importeTotalGrupo;
    }

    public BigDecimal getImporteProporcionalPersona() {
        return importeProporcionalPersona;
    }

    public void setImporteProporcionalPersona(BigDecimal importeProporcionalPersona) {
        this.importeProporcionalPersona = importeProporcionalPersona;
    }

    public BigDecimal getSaldoAportado() {
        return saldoAportado;
    }

    public void setSaldoAportado(BigDecimal saldoAportado) {
        this.saldoAportado = saldoAportado;
    }
}
