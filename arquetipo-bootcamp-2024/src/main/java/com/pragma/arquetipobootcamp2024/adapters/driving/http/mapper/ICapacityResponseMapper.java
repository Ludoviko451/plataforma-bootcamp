package com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper;

import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.CapacityResponse;
import com.pragma.arquetipobootcamp2024.domain.model.Capacity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICapacityResponseMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name") // Ajustar este mapeo según la estructura de tu DTO de respuesta
    CapacityResponse toCapacityResponse(Capacity capacity);

    List<CapacityResponse> toCapacityResponseList(List<Capacity> capacityList);

}
