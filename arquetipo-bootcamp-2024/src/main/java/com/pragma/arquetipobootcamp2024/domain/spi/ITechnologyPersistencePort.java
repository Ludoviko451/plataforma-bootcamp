package com.pragma.arquetipobootcamp2024.domain.spi;

import com.pragma.arquetipobootcamp2024.domain.model.Technology;

import java.util.List;
import java.util.Optional;

// Interfaz para operaciones relacionadas con las tecnologías
public interface ITechnologyPersistencePort {

    void saveTechnology(Technology technology);

    void deleteTechnology(Long id);

    Optional<Technology> findByName(String name);
    List<Technology> getAllTechnology(Integer page, Integer size, String sortBy);

    Technology updateTechnology(Technology technology);

}
