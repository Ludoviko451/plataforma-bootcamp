package com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class UpdateTecnologiaRequest {
    private final Long id;
    private final String nombre;
    private final String descripcion;
}
