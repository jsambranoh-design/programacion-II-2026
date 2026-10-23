package com.estudiante.controlgastospersonales.dto;

import java.math.BigDecimal;

public class TotalCategoriaResponse {

    private Long categoriaId;
    private String categoriaNombre;
    private BigDecimal total;
    private Long cantidad;

    public TotalCategoriaResponse() {
    }

    public TotalCategoriaResponse(
            Long categoriaId,
            String categoriaNombre,
            BigDecimal total,
            Long cantidad) {

        this.categoriaId = categoriaId;
        this.categoriaNombre = categoriaNombre;
        this.total = total;
        this.cantidad = cantidad;
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}