package com.pragma.arquetipobootcamp2024.domain.exception;

public class DescripcionExcedeLongitudMaximaException extends RuntimeException {

    public DescripcionExcedeLongitudMaximaException() {
        super("La descripcion excede la longitud máxima permitida de 90 caracteres");
    }
}
