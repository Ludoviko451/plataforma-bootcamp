package com.pragma.arquetipobootcamp2024.domain.api;


import com.pragma.arquetipobootcamp2024.domain.model.Technology;

import java.util.List;
// Interfaz para servicios relacionados con tecnologías

//El Puerto de Persistencia se centra en cómo interactuar con la base de datos.

//El Puerto de Servicio se centra en las operaciones de alto nivel de la aplicación en sí misma.
public interface ITechnologyServicePort {

    void deleteTechnology(Long id);
    void saveTechnology(Technology technology);

    Technology updateTechnology(Technology technology);

    List<Technology> getAllTechnology(Integer page, Integer size, String sortBy);

}
