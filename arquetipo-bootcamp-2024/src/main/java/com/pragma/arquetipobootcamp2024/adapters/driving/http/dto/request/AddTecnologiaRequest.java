package com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


///
// Esta clase define un DTO (Data Transfer Object) llamado AddTecnologiaRequest, el cual representa los datos
// de una solicitud HTTP para agregar una nueva tecnología.
//
// Los campos nombre y descripcion son obligatorios y se validan con la anotación @NotBlank para asegurar que no estén en blanco.
//
// El constructor permite inicializar los campos nombre y descripcion al crear una instancia de AddTecnologiaRequest.
//
// Los métodos getNombre y getDescripcion proporcionan acceso a los valores de los campos nombre y descripcion, respectivamente.
//

@AllArgsConstructor
@Getter
public class AddTecnologiaRequest {

    @Size(max = 50, message = "El nombre de la tecnologia debe tener una longitud menor a 50 caracteres")
    @NotBlank(message = "La Tecnologia debe tener un nombre")
    private final String nombre;

    @Size(max = 90, message = "La descripcion de la tecnologia debe tener una longitud menor a 90 caracteres")
    @NotBlank(message = "La Tecnologia debe tener una descripcion")
    private final String descripcion;


}
