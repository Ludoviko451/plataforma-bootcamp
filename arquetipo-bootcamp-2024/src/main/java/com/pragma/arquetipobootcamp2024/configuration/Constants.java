package com.pragma.arquetipobootcamp2024.configuration;

public class Constants {
    private Constants(){
        throw new IllegalStateException("utility class");
    }

    public static final String NO_DATA_FOUND_EXCEPTION_MESSAGE = "No data was found in the database";
    public static final String ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE = "The element indicated does not exist";

    public static final String EMPTY_FIELD_EXCEPTION_MESSAGE = "Field %s can not be empty";
    public static final String NEGATIVE_NOT_ALLOWED_EXCEPTION_MESSAGE = "Field %s can not receive negative values";

    public static final String TECHNOLOGY_ALREADY_EXISTS_EXCEPTION_MESSAGE = "La tecnologia que tu quieres crear ya existe";

    public static final String TECHNOLOGY_IDS_IS_EMPTY_MESSAGE = "Las ids de las tecnologias no pueden estar vacias";

    public static final String TECHNOLOGY_IDS_PASS_THE_LIMIT_MESSAGE = "Las ids ingresadas deben ser minimo 3 y maximo 20";
    public static final String DUPLICATE_IDS_TECHNOLOGY_IDS_EXCEPTION = "Porfavor no ingrese duplicados en la lista de tecnologias";
}
