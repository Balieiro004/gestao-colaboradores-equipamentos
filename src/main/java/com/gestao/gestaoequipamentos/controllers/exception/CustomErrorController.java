package com.gestao.gestaoequipamentos.controllers.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<StandarError> handleError(HttpServletRequest request) {
        StandarError error = new StandarError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Recurso não encontrado");
        error.setMessage("A URL solicitada não existe.");
        error.setPath(request.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    public String getErrorPath() {
        return "/error";
    }
}
