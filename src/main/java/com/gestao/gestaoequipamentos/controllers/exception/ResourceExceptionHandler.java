package com.gestao.gestaoequipamentos.controllers.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.gestao.gestaoequipamentos.service.exceptions.ControllerNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
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

}
