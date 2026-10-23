package com.estudiante.controlgastospersonales.controller;

import com.estudiante.controlgastospersonales.dto.CategoriaRequest;
import com.estudiante.controlgastospersonales.dto.CategoriaResponse;
import com.estudiante.controlgastospersonales.service.CategoriaService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<CategoriaResponse> listar() {
        return categoriaService.listar();
    }

    @GetMapping("/{id}")
    public CategoriaResponse buscarPorId(
            @PathVariable("id") Long id) {

        return categoriaService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> crear(
            @Valid @RequestBody CategoriaRequest request) {

        CategoriaResponse respuesta = categoriaService.crear(request);

        URI ubicacion = URI.create(
                "/api/categorias/" + respuesta.getId()
        );

        return ResponseEntity.created(ubicacion).body(respuesta);
    }

    @PutMapping("/{id}")
    public CategoriaResponse actualizar(
            @PathVariable("id") Long id,
            @Valid @RequestBody CategoriaRequest request) {

        return categoriaService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable("id") Long id) {

        categoriaService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}