package com.pragma.arquetipobootcamp2024.domain.spi;

import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;

import java.util.List;
import java.util.Optional;

// Interfaz para operaciones relacionadas con las tecnologías
public interface ITecnologiaPersistencePort {

    void saveTecnologia(Tecnologia tecnologia);

    void deleteTecnologia(Long id);

    Optional<Tecnologia> findByName(String name);
    List<Tecnologia> getAllTecnologias(Integer page, Integer size, String sortBy);

    Tecnologia updateTecnologia(Tecnologia tecnologia);

}
