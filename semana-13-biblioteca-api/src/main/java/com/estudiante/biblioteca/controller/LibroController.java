
package com.estudiante.biblioteca.controller;

import com.estudiante.biblioteca.entity.Libro;
import com.estudiante.biblioteca.repository.LibroRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroRepository repo;

    public LibroController(LibroRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Libro> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscar(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Libro> guardar(@RequestBody Libro libro) {
        libro.setId(null);
        return ResponseEntity.status(201).body(repo.save(libro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(
            @PathVariable Long id, @RequestBody Libro libro) {

        if (!repo.existsById(id))
            return ResponseEntity.notFound().build();

        libro.setId(id);
        return ResponseEntity.ok(repo.save(libro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repo.existsById(id))
            return ResponseEntity.notFound().build();

        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria/{categoria}")
    public List<Libro> categoria(@PathVariable String categoria) {
        return repo.findByCategoria(categoria);
    }

    @GetMapping("/disponibles")
    public List<Libro> disponibles() {
        return repo.findByDisponibleTrue();
    }
}
