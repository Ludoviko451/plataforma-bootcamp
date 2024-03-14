package com.pragma.arquetipobootcamp2024.domain.model;
//"-Cada tecnologia tiene 3 campos: id,nombre y direccion

//esta clase representa una entidad llamada Tecnologia que tiene tres atributos:
//id, nombre y descripción, y proporciona métodos para acceder a estos atributos.
//Este tipo de clase es comúnmente utilizada para modelar objetos en el dominio de una aplicación.

public class Tecnologia {

    private final Long id;
    private final String nombre;
    private final String descripcion;

    public Tecnologia(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
