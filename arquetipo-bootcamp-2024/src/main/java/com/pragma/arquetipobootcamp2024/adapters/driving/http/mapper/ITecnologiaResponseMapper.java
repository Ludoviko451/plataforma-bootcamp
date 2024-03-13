package com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper;


import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.TecnologiaResponse;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITecnologiaResponseMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre") // Ajustar este mapeo según la estructura de tu DTO de respuesta
    @Mapping(source = "descripcion", target = "descripcion")
    TecnologiaResponse toTecnologiaResponse(Tecnologia tecnologia);

    List<TecnologiaResponse> toTecnologiaResponseList(List<Tecnologia> tecnologias);
}
