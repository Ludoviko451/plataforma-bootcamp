package com.pragma.arquetipobootcamp2024.domain.exception;

public class NegativeNotAllowedException extends RuntimeException {
    public NegativeNotAllowedException(String message) {
        super(message);
    }
}
