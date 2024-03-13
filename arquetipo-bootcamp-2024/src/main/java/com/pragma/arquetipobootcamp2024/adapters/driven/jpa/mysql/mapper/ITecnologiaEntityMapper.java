package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper;


import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TecnologiaEntity;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITecnologiaEntityMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    Tecnologia toModel(TecnologiaEntity tecnologiaEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    TecnologiaEntity toEntity(Tecnologia tecnologia);

    List<Tecnologia> toModelList(List<TecnologiaEntity> tecnologiaEntities);
}
