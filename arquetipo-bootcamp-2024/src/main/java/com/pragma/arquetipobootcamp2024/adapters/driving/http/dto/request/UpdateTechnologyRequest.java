package com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class UpdateTechnologyRequest {
    private final Long id;
    private final String name;
    private final String description;
}
