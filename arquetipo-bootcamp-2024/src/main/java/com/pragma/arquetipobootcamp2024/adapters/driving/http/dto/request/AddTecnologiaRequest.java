package com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request;


import javax.validation.constraints.NotBlank;

public class AddTecnologiaRequest {

    @NotBlank(message = "La Tecnologia debe tener un nombre")
    private final String nombre;

    @NotBlank(message = "La Tecnologia debe tener una descripcion")
    private final String descripcion;

    public AddTecnologiaRequest(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
