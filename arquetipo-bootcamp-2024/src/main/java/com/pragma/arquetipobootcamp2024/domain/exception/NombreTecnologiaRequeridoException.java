package com.pragma.arquetipobootcamp2024.domain.exception;

public class NombreTecnologiaRequeridoException extends RuntimeException {

    public NombreTecnologiaRequeridoException() {
        super("El nombre de la tecnologia es requerido");
    }
}
