package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper;


import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TecnologiaEntity;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

//Interfaz que define métodos para mapear entre entidades JPA y modelos de dominio para la tecnología.

//actúa como un "traductor" entre las entidades JPA (que representan los datos en la capa de persistencia)
// y los modelos de dominio (que representan los datos en la lógica de negocio de la aplicación).

@Mapper(componentModel = "spring")
public interface ITecnologiaEntityMapper {


//  Convierte una entidad JPA de tecnología a un modelo de dominio de tecnología.
//  @param tecnologiaEntity La entidad JPA de tecnología.
//  @return El modelo de dominio de tecnología.

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    Tecnologia toModel(TecnologiaEntity tecnologiaEntity);

//  Convierte un modelo de dominio de tecnología a una entidad JPA de tecnología.
//  @param tecnologia El modelo de dominio de tecnología.
//  @return La entidad JPA de tecnología.
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    TecnologiaEntity toEntity(Tecnologia tecnologia);

//  Convierte una lista de entidades JPA de tecnología a una lista de modelos de dominio de tecnología.
//  @param tecnologiaEntities La lista de entidades JPA de tecnología.
//  @return La lista de modelos de dominio de tecnología.
    List<Tecnologia> toModelList(List<TecnologiaEntity> tecnologiaEntities);
}
