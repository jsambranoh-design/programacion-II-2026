package com.estudiante.controlgastospersonales.repository;

import com.estudiante.controlgastospersonales.entity.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

import com.estudiante.controlgastospersonales.dto.TotalCategoriaResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GastoRepository
        extends JpaRepository<Gasto, Long> {
    @Query("""
        SELECT new com.estudiante.controlgastospersonales.dto.TotalCategoriaResponse(
            g.categoria.id,
            g.categoria.nombre,
            SUM(g.monto),
            COUNT(g.id)
        )
        FROM Gasto g
        WHERE g.fecha >= :inicio
          AND g.fecha < :fin
        GROUP BY g.categoria.id, g.categoria.nombre
        ORDER BY g.categoria.nombre
        """)
    List<TotalCategoriaResponse> obtenerResumenMensual(
            @Param("inicio") LocalDate inicio,
            @Param("fin") LocalDate fin);

    List<Gasto> findByCategoria_Id(Long categoriaId);

    List<Gasto> findByFechaBetween(LocalDate inicio, LocalDate fin);

    List<Gasto> findByEstado(String estado);

    boolean existsByCategoria_Id(Long categoriaId);
}