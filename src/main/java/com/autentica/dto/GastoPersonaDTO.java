package com.autentica.dto;

import java.math.BigDecimal;

public class GastoPersonaDTO {

    private Long personaId;
    private BigDecimal total;

    public GastoPersonaDTO() {
    }

    public GastoPersonaDTO(Long personaId, BigDecimal total) {
        this.personaId = personaId;
        this.total = total;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
