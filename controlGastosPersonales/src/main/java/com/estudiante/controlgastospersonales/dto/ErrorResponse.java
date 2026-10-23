package com.estudiante.controlgastospersonales.dto;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime fecha;
    private int estado;
    private String mensaje;

    public ErrorResponse() {
    }

    public ErrorResponse(int estado, String mensaje) {
        this.fecha = LocalDateTime.now();
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}