package com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper;


import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.UpdateTechnologyRequest;
import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//Interfaz que define métodos para mapear objetos de solicitud HTTP a objetos de dominio de Tecnologia.
//Utiliza MapStruct para realizar el mapeo.
@Mapper(componentModel = "spring")
public interface ITechnologyRequestMapper {

//
//     Método que mapea un objeto de solicitud de adición de tecnología a un objeto de dominio de Tecnologia.
//     Ignora el campo 'id' durante el mapeo, ya que probablemente se generará automáticamente.
//     @param addTecnologiaRequest El objeto de solicitud de adición de tecnología.
//     @return El objeto de dominio de Tecnologia mapeado.
//
    @Mapping(target = "id", ignore = true)
    Technology addRequestToTechnology(AddTechnologyRequest addTechnologyRequest);

    @Mapping(target = "id", source = "id")
    Technology updateRequestToTechnology(UpdateTechnologyRequest updateTechnologyRequest);
}
