package com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper;


import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTecnologiaRequest;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//Interfaz que define métodos para mapear objetos de solicitud HTTP a objetos de dominio de Tecnologia.
//Utiliza MapStruct para realizar el mapeo.
@Mapper(componentModel = "spring")
public interface ITecnologiaRequestMapper {

//
//     Método que mapea un objeto de solicitud de adición de tecnología a un objeto de dominio de Tecnologia.
//     Ignora el campo 'id' durante el mapeo, ya que probablemente se generará automáticamente.
//     @param addTecnologiaRequest El objeto de solicitud de adición de tecnología.
//     @return El objeto de dominio de Tecnologia mapeado.
//
    @Mapping(target = "id", ignore = true)
    Tecnologia addRequestToTecnologia(AddTecnologiaRequest addTecnologiaRequest);
}
