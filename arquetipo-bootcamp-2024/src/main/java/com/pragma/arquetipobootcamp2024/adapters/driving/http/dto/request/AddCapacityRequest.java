package com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@Getter
public class AddCapacityRequest {

    @NotBlank(message = "La capacidad debe tener un nombre")
    private final String name;

    @NotBlank(message = "La capacidad debe tener una descripcion")
    private final String description;

}
