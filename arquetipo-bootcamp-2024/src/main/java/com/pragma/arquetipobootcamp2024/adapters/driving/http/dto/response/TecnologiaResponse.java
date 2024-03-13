package com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response;



public class TecnologiaResponse {

    private final Long id;
    private final String nombre;
    private final String descripcion;

    public TecnologiaResponse(Long id, String nombre, String descripcion) {
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
