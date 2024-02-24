package com.autentica.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "gastos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Gasto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gasto_id")
    @JsonProperty("gastoId")
    private Long gastoId;

    @Column(name = "persona_id", nullable = false)
    @JsonProperty("personaId")
    private Long personaId;

    @Column(name = "importe", nullable = false)
    @JsonProperty("importe")
    private BigDecimal importe;

    @Column(name = "descripcion", nullable = false)
    @JsonProperty("descripcion")
    private String descripcion;

    @Column(name = "fecha_pago", nullable = false)
    @JsonProperty("fechaPago")
    private LocalDate fechaPago;

    public Gasto() {
    }

    public Gasto(Long gastoId, Long personaId, BigDecimal importe, String descripcion, LocalDate fechaPago, Long grupoId) {
        this.gastoId = gastoId;
        this.personaId = personaId;
        this.importe = importe;
        this.descripcion = descripcion;
        this.fechaPago = fechaPago;
    }


    public Long getGastoId() {
        return gastoId;
    }

    public void setGastoId(Long gastoId) {
        this.gastoId = gastoId;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
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
