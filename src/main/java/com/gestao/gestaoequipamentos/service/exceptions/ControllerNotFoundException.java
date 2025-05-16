package com.gestao.gestaoequipamentos.service.exceptions;

public class ControllerNotFoundException extends RuntimeException{

    public ControllerNotFoundException(String message) {
        super(message);
    }
}
