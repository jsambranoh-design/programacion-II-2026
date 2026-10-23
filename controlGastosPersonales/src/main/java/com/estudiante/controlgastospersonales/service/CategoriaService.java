package com.estudiante.controlgastospersonales.service;

import com.estudiante.controlgastospersonales.dto.CategoriaRequest;
import com.estudiante.controlgastospersonales.dto.CategoriaResponse;
import com.estudiante.controlgastospersonales.entity.Categoria;
import com.estudiante.controlgastospersonales.exception.RecursoNoEncontradoException;
import com.estudiante.controlgastospersonales.exception.ReglaNegocioException;
import com.estudiante.controlgastospersonales.repository.CategoriaRepository;
import com.estudiante.controlgastospersonales.repository.GastoRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final GastoRepository gastoRepository;

    public CategoriaService(
            CategoriaRepository categoriaRepository,
            GastoRepository gastoRepository) {

        this.categoriaRepository = categoriaRepository;
        this.gastoRepository = gastoRepository;
    }

    public List<CategoriaResponse> listar() {
        return categoriaRepository.findAll()
                .stream()
                .map(this::convertirRespuesta)
                .toList();
    }

    public CategoriaResponse buscarPorId(Long id) {
        Categoria categoria = obtenerCategoria(id);
        return convertirRespuesta(categoria);
    }

    @Transactional
    public CategoriaResponse crear(CategoriaRequest request) {
        String nombre = request.getNombre().trim();

        if (categoriaRepository.existsByNombreIgnoreCase(nombre)) {
            throw new ReglaNegocioException(
                    "Ya existe una categoría con ese nombre"
            );
        }

        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        categoria.setDescripcion(request.getDescripcion());

        Categoria guardada = categoriaRepository.save(categoria);

        return convertirRespuesta(guardada);
    }

    @Transactional
    public CategoriaResponse actualizar(
            Long id,
            CategoriaRequest request) {

        Categoria categoria = obtenerCategoria(id);

        String nombre = request.getNombre().trim();

        if (categoriaRepository.existsByNombreIgnoreCaseAndIdNot(
                nombre, id)) {

            throw new ReglaNegocioException(
                    "Ya existe otra categoría con ese nombre"
            );
        }

        categoria.setNombre(nombre);
        categoria.setDescripcion(request.getDescripcion());

        Categoria actualizada = categoriaRepository.save(categoria);

        return convertirRespuesta(actualizada);
    }

    @Transactional
    public void eliminar(Long id) {
        Categoria categoria = obtenerCategoria(id);

        if (gastoRepository.existsByCategoria_Id(id)) {
            throw new ReglaNegocioException(
                    "No se puede eliminar la categoría porque tiene gastos asociados"
            );
        }

        categoriaRepository.delete(categoria);
    }

    private Categoria obtenerCategoria(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "No existe una categoría con ID " + id
                        )
                );
    }

    private CategoriaResponse convertirRespuesta(Categoria categoria) {
        return new CategoriaResponse(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getDescripcion()
        );
    }
}