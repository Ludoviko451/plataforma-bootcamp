package com.pragma.arquetipobootcamp2024.domain.spi;

import com.pragma.arquetipobootcamp2024.domain.model.Product;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;

import java.util.List;
// Interfaz para operaciones relacionadas con las tecnologías
public interface ITecnologiaPersistencePort {

    void saveTecnologia(Tecnologia tecnologia);

    Tecnologia findByName(String name);

    List<Tecnologia> getAllTecnologias(Integer page, Integer size, String sortBy);

}
