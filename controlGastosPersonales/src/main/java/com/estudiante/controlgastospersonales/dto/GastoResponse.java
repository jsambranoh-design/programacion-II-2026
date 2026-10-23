package com.estudiante.controlgastospersonales.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GastoResponse {

    private Long id;
    private String descripcion;
    private BigDecimal monto;
    private LocalDate fecha;
    private String estado;
    private Long categoriaId;
    private String categoriaNombre;

    public GastoResponse() {
    }

    public GastoResponse(
            Long id,
            String descripcion,
            BigDecimal monto,
            LocalDate fecha,
            String estado,
            Long categoriaId,
            String categoriaNombre) {

        this.id = id;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha = fecha;
        this.estado = estado;
        this.categoriaId = categoriaId;
        this.categoriaNombre = categoriaNombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }
}