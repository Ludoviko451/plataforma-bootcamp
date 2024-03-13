package com.pragma.arquetipobootcamp2024.domain.spi;

import com.pragma.arquetipobootcamp2024.domain.model.Product;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;

import java.util.List;

public interface ITecnologiaPersistencePort {

    void saveTecnologia(Tecnologia tecnologia);

    Tecnologia findByName(String name);

    List<Tecnologia> getAllTecnologias(Integer page, Integer size, String sortBy);

//    List<Tecnologia> getAllTecnologias();
}
