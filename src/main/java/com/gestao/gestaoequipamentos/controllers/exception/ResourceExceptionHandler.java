package com.gestao.gestaoequipamentos.controllers.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.gestao.gestaoequipamentos.service.exceptions.ControllerNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Collectors;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<StandarError> controlerNotFound(ControllerNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError error = new StandarError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Resource not found");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(error);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandarError> handleHttpMessageNotReadable(HttpMessageNotReadableException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = "Erro de leitura da requisição. Verifique os campos enviados.";

        if (e.getCause() instanceof InvalidFormatException) {
            InvalidFormatException cause = (InvalidFormatException) e.getCause();
            if (cause.getTargetType().isEnum()) {
                String campo = cause.getPath().get(0).getFieldName();
                String valorInvalido = cause.getValue().toString();
                String valoresEsperados = Arrays.stream(((Class<? extends Enum<?>>) cause.getTargetType()).getEnumConstants())
                        .map(Enum::name)
                        .collect(Collectors.joining(", "));
                message = String.format("Valor inválido para o campo '%s': '%s'. Valores esperados: %s",
                        campo, valorInvalido, valoresEsperados);
            }
        }

        StandarError error = new StandarError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Bad Request");
        error.setMessage(message);
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandarError>handleDataIntegrityViolation(DataIntegrityViolationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        String message = "Verifique se os campos únicos já não estão sendo utilizados.";

        if (e.getMessage() != null && e.getMessage().contains("SERVICE_TAG")) {
            message = "Já existe um equipamento cadastrado com essa Service Tag.";
        }

        StandarError error = new StandarError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Data Integrity Violation");
        error.setMessage(message);
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandarError> handleConstraintViolation(ConstraintViolationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        String message = e.getConstraintViolations().stream().map(violation -> violation.getMessage()).collect(Collectors.joining("; "));

        StandarError error = new StandarError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Validation Error");
        error.setMessage(message);
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }
}
