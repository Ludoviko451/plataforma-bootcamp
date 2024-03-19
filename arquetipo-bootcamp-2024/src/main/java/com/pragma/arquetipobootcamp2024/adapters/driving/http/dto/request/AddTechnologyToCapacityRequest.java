package com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@Getter
public class AddTechnologyToCapacityRequest {
    @NotBlank(message = "Debe ingresar la id de una capacidad")
    private final Long capacityId;
    @NotBlank(message = "Debe ingresar las ids de las tecnologias")
    @Size(min = 3, message = "Debe haber al menos 3 IDS de tecnologias")
    private final List<Long> technologyIds;
}
