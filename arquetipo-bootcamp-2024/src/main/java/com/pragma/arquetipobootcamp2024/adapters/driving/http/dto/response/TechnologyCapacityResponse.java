package com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response;

// Solo muestra descripcion
public class TechnologyCapacityResponse {
    private final Long id;
    private final String name;



    public TechnologyCapacityResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
