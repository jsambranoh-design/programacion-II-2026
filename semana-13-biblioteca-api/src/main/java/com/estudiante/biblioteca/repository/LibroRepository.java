
package com.estudiante.biblioteca.repository;

import com.estudiante.biblioteca.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByCategoria(String categoria);

    List<Libro> findByDisponibleTrue();
}
