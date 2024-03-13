package com.pragma.arquetipobootcamp2024.domain.exception;

public class TecnologiaPresenteException extends RuntimeException {

    public TecnologiaPresenteException() {
        super("Esta Tecnologia ya se encuentra en la base de datos");
    }
}
