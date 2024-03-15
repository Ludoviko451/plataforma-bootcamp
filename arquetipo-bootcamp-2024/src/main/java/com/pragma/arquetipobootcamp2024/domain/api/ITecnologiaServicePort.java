package com.pragma.arquetipobootcamp2024.domain.api;


import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;

import java.util.List;
// Interfaz para servicios relacionados con tecnologías

//El Puerto de Persistencia se centra en cómo interactuar con la base de datos.

//El Puerto de Servicio se centra en las operaciones de alto nivel de la aplicación en sí misma.
public interface ITecnologiaServicePort {

    void deleteTecnologia(Long id);
    void saveTecnologia(Tecnologia tecnologia);

    Tecnologia updateTecnologia(Tecnologia tecnologia);

    List<Tecnologia> getAllTecnologias(Integer page, Integer size, String sortBy);

}
