package com.pragma.arquetipobootcamp2024.domain.exception;

public class NombreExcedeLongitudMaximaException extends RuntimeException {

    public NombreExcedeLongitudMaximaException() {
        super("El nombre excede la longitud máxima permitida de 50 caracteres");
    }
}

