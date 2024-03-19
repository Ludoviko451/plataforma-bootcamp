package com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper;


import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddCapacityRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTechnologyToCapacityRequest;
import com.pragma.arquetipobootcamp2024.domain.model.Capacity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICapacityRequestMapper {

    @Mapping(target = "id", ignore = true)
    Capacity addRequestToCapacity(AddCapacityRequest addCapacityRequest);
    @Mapping(target = "id", ignore = true)
    Capacity addTechnologyRequestToCapacity(AddTechnologyToCapacityRequest addTechnologyToCapacityRequest);
}