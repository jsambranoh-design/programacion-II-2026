package com.estudiante.controlgastospersonales.controller;

import com.estudiante.controlgastospersonales.dto.EstadoRequest;
import com.estudiante.controlgastospersonales.dto.GastoRequest;
import com.estudiante.controlgastospersonales.dto.GastoResponse;
import com.estudiante.controlgastospersonales.service.GastoService;

import jakarta.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import com.estudiante.controlgastospersonales.dto.TotalCategoriaResponse;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {

    private final GastoService gastoService;

    public GastoController(GastoService gastoService) {
        this.gastoService = gastoService;
    }

    @GetMapping
    public List<GastoResponse> listar() {
        return gastoService.listar();
    }

    @GetMapping("/{id}")
    public GastoResponse buscarPorId(
            @PathVariable("id") Long id) {

        return gastoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<GastoResponse> crear(
            @Valid @RequestBody GastoRequest request) {

        GastoResponse respuesta = gastoService.crear(request);

        URI ubicacion = URI.create(
                "/api/gastos/" + respuesta.getId()
        );

        return ResponseEntity.created(ubicacion).body(respuesta);
    }

    @PutMapping("/{id}")
    public GastoResponse actualizar(
            @PathVariable("id") Long id,
            @Valid @RequestBody GastoRequest request) {

        return gastoService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable("id") Long id) {

        gastoService.eliminar(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/estado")
    public GastoResponse cambiarEstado(
            @PathVariable("id") Long id,
            @Valid @RequestBody EstadoRequest request) {

        return gastoService.cambiarEstado(id, request);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<GastoResponse> buscarPorCategoria(
            @PathVariable("categoriaId") Long categoriaId) {

        return gastoService.buscarPorCategoria(categoriaId);
    }

    @GetMapping("/rango")
    public List<GastoResponse> buscarPorRango(
            @RequestParam("inicio")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate inicio,

            @RequestParam("fin")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fin) {

        return gastoService.buscarPorRango(inicio, fin);
    }

    @GetMapping("/pendientes")
    public List<GastoResponse> listarPendientes() {
        return gastoService.listarPendientes();
    }
    @GetMapping("/resumen-mensual")
    public List<TotalCategoriaResponse> obtenerResumenMensual(
            @RequestParam("anio") int anio,
            @RequestParam("mes") int mes) {

        return gastoService.obtenerResumenMensual(anio, mes);
    }
}