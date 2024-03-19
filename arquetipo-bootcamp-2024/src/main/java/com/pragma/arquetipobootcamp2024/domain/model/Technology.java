package com.pragma.arquetipobootcamp2024.domain.model;
//"-Cada tecnologia tiene 3 campos: id,nombre y direccion

//esta clase representa una entidad llamada Tecnologia que tiene tres atributos:
//id, nombre y descripción, y proporciona métodos para acceder a estos atributos.
//Este tipo de clase es comúnmente utilizada para modelar objetos en el dominio de una aplicación.

public class Technology {

    private final Long id;
    private final String name;
    private final String description;

    public Technology(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
