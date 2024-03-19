package com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response;


// Esta clase define un DTO (Data Transfer Object) llamado TecnologiaResponse, el cual representa la respuesta
// de una solicitud HTTP que obtiene información sobre una tecnología.
public class TechnologyResponse {

    private final Long id;
    private final String name;
    private final String description;

    public TechnologyResponse(Long id, String name, String description) {
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
