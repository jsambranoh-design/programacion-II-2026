package com.estudiante.controlgastospersonales.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EstadoRequest {

    @NotBlank(message = "El estado es obligatorio")
    @Pattern(
            regexp = "PAGADO|PENDIENTE",
            message = "El estado debe ser PAGADO o PENDIENTE"
    )
    private String estado;

    public EstadoRequest() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}