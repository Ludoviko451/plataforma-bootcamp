package com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper;


import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTecnologiaRequest;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ITecnologiaRequestMapper {

    @Mapping(target = "id", ignore = true)
    Tecnologia addRequestToTecnologia(AddTecnologiaRequest addTecnologiaRequest);
}
