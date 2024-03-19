package com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response;

import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CapacityResponse {

    private final Long id;

    private final String name;
    private final String description;

    private final List<TechnologyCapacityResponse> technologyList;

}
