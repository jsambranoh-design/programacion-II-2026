package com.estudiante.controlgastospersonales.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GastoRequest {

    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 160, message = "La descripción no debe superar 160 caracteres")
    private String descripcion;

    @NotNull(message = "El monto es obligatorio")
    @DecimalMin(value = "0", inclusive = false,
            message = "El monto debe ser mayor que cero")
    @Digits(integer = 10, fraction = 2,
            message = "El monto permite hasta 10 enteros y 2 decimales")
    private BigDecimal monto;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @NotBlank(message = "El estado es obligatorio")
    @Pattern(regexp = "PAGADO|PENDIENTE",
            message = "El estado debe ser PAGADO o PENDIENTE")
    private String estado;

    @NotNull(message = "La categoría es obligatoria")
    @Positive(message = "El ID de la categoría debe ser positivo")
    private Long categoriaId;

    public GastoRequest() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}