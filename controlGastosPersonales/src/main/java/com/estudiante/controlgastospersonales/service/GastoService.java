package com.estudiante.controlgastospersonales.service;

import com.estudiante.controlgastospersonales.dto.EstadoRequest;
import com.estudiante.controlgastospersonales.dto.GastoRequest;
import com.estudiante.controlgastospersonales.dto.GastoResponse;
import com.estudiante.controlgastospersonales.dto.TotalCategoriaResponse;
import com.estudiante.controlgastospersonales.entity.Categoria;
import com.estudiante.controlgastospersonales.entity.EstadoGasto;
import com.estudiante.controlgastospersonales.entity.Gasto;
import com.estudiante.controlgastospersonales.exception.RecursoNoEncontradoException;
import com.estudiante.controlgastospersonales.repository.CategoriaRepository;
import com.estudiante.controlgastospersonales.repository.GastoRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class GastoService {

    private final GastoRepository gastoRepository;
    private final CategoriaRepository categoriaRepository;

    public GastoService(
            GastoRepository gastoRepository,
            CategoriaRepository categoriaRepository) {

        this.gastoRepository = gastoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<GastoResponse> listar() {
        return gastoRepository.findAll()
                .stream()
                .map(this::convertirRespuesta)
                .toList();
    }

    public GastoResponse buscarPorId(Long id) {
        Gasto gasto = obtenerGasto(id);
        return convertirRespuesta(gasto);
    }

    @Transactional
    public GastoResponse crear(GastoRequest request) {
        Categoria categoria = obtenerCategoria(
                request.getCategoriaId()
        );

        Gasto gasto = new Gasto();
        asignarDatos(gasto, request, categoria);

        Gasto guardado = gastoRepository.save(gasto);

        return convertirRespuesta(guardado);
    }

    @Transactional
    public GastoResponse actualizar(Long id, GastoRequest request) {
        Gasto gasto = obtenerGasto(id);

        Categoria categoria = obtenerCategoria(
                request.getCategoriaId()
        );

        asignarDatos(gasto, request, categoria);

        Gasto actualizado = gastoRepository.save(gasto);

        return convertirRespuesta(actualizado);
    }

    @Transactional
    public void eliminar(Long id) {
        Gasto gasto = obtenerGasto(id);
        gastoRepository.delete(gasto);
    }

    @Transactional
    public GastoResponse cambiarEstado(Long id, EstadoRequest request) {
        Gasto gasto = obtenerGasto(id);

        validarEstado(request.getEstado());
        gasto.setEstado(request.getEstado());

        Gasto actualizado = gastoRepository.save(gasto);

        return convertirRespuesta(actualizado);
    }

    public List<GastoResponse> buscarPorCategoria(Long categoriaId) {
        obtenerCategoria(categoriaId);

        return gastoRepository.findByCategoria_Id(categoriaId)
                .stream()
                .map(this::convertirRespuesta)
                .toList();
    }

    public List<GastoResponse> buscarPorRango(
            LocalDate inicio,
            LocalDate fin) {

        if (inicio == null || fin == null) {
            throw new IllegalArgumentException(
                    "La fecha inicial y la fecha final son obligatorias"
            );
        }

        if (inicio.isAfter(fin)) {
            throw new IllegalArgumentException(
                    "La fecha inicial no puede ser posterior a la fecha final"
            );
        }

        return gastoRepository.findByFechaBetween(inicio, fin)
                .stream()
                .map(this::convertirRespuesta)
                .toList();
    }

    public List<GastoResponse> listarPendientes() {
        return gastoRepository.findByEstado(EstadoGasto.PENDIENTE)
                .stream()
                .map(this::convertirRespuesta)
                .toList();
    }

    public List<TotalCategoriaResponse> obtenerResumenMensual(
            int anio,
            int mes) {

        if (anio < 1 || anio > 9999) {
            throw new IllegalArgumentException(
                    "El año debe estar entre 1 y 9999"
            );
        }

        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException(
                    "El mes debe estar entre 1 y 12"
            );
        }

        YearMonth periodo = YearMonth.of(anio, mes);

        LocalDate inicio = periodo.atDay(1);
        LocalDate fin = periodo.plusMonths(1).atDay(1);

        return gastoRepository.obtenerResumenMensual(inicio, fin);
    }

    private Gasto obtenerGasto(Long id) {
        return gastoRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "No existe un gasto con ID " + id
                        )
                );
    }

    private Categoria obtenerCategoria(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "No existe una categoría con ID " + id
                        )
                );
    }

    private void asignarDatos(
            Gasto gasto,
            GastoRequest request,
            Categoria categoria) {

        validarEstado(request.getEstado());

        gasto.setDescripcion(request.getDescripcion().trim());
        gasto.setMonto(request.getMonto());
        gasto.setFecha(request.getFecha());
        gasto.setEstado(request.getEstado());
        gasto.setCategoria(categoria);
    }

    private void validarEstado(String estado) {
        if (!EstadoGasto.PAGADO.equals(estado)
                && !EstadoGasto.PENDIENTE.equals(estado)) {

            throw new IllegalArgumentException(
                    "El estado debe ser PAGADO o PENDIENTE"
            );
        }
    }

    private GastoResponse convertirRespuesta(Gasto gasto) {
        return new GastoResponse(
                gasto.getId(),
                gasto.getDescripcion(),
                gasto.getMonto(),
                gasto.getFecha(),
                gasto.getEstado(),
                gasto.getCategoria().getId(),
                gasto.getCategoria().getNombre()
        );
    }
}