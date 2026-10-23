package com.estudiante.controlgastospersonales.exception;

import com.estudiante.controlgastospersonales.dto.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<ErrorResponse> manejarNoEncontrado(
            RecursoNoEncontradoException exception) {

        return crearRespuesta(
                HttpStatus.NOT_FOUND,
                exception.getMessage()
        );
    }

    @ExceptionHandler(ReglaNegocioException.class)
    public ResponseEntity<ErrorResponse> manejarReglaNegocio(
            ReglaNegocioException exception) {

        return crearRespuesta(
                HttpStatus.CONFLICT,
                exception.getMessage()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> manejarValidacion(
            MethodArgumentNotValidException exception) {

        String mensaje = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error ->
                        error.getField() + ": " + error.getDefaultMessage()
                )
                .collect(Collectors.joining("; "));

        return crearRespuesta(
                HttpStatus.BAD_REQUEST,
                mensaje
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> manejarJsonInvalido(
            HttpMessageNotReadableException exception) {

        return crearRespuesta(
                HttpStatus.BAD_REQUEST,
                "El cuerpo de la solicitud está vacío o contiene datos "
                        + "con formato incorrecto. Revise las fechas y los números."
        );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> manejarParametroInvalido(
            MethodArgumentTypeMismatchException exception) {

        return crearRespuesta(
                HttpStatus.BAD_REQUEST,
                "El parámetro '" + exception.getName()
                        + "' tiene un formato incorrecto."
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> manejarArgumentoInvalido(
            IllegalArgumentException exception) {

        return crearRespuesta(
                HttpStatus.BAD_REQUEST,
                exception.getMessage()
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> manejarIntegridad(
            DataIntegrityViolationException exception) {

        return crearRespuesta(
                HttpStatus.CONFLICT,
                "La operación incumple una restricción de la base de datos."
        );
    }

    private ResponseEntity<ErrorResponse> crearRespuesta(
            HttpStatus estado,
            String mensaje) {

        ErrorResponse respuesta = new ErrorResponse(
                estado.value(),
                mensaje
        );

        return ResponseEntity.status(estado).body(respuesta);
    }
}