package com.pragma.arquetipobootcamp2024.domain.api.usecase;


import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.pragma.arquetipobootcamp2024.domain.api.ITechnologyServicePort;
import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import com.pragma.arquetipobootcamp2024.domain.spi.ITechnologyPersistencePort;

import java.util.List;
import java.util.Optional;

//  Clase que implementa la lógica de negocio relacionada con las operaciones de tecnología.
// Utiliza el puerto de persistencia para interactuar con la capa de almacenamiento de datos.

public class TechnologyUseCase implements ITechnologyServicePort {
    private final ITechnologyPersistencePort tecnologiaPersistencePort;

    public TechnologyUseCase(ITechnologyPersistencePort tecnologiaPersistencePort) {
        this.tecnologiaPersistencePort = tecnologiaPersistencePort;
    }


    @Override
    public void deleteTechnology(Long id) {
        tecnologiaPersistencePort.deleteTechnology(id);
    }

    @Override
    public void saveTechnology(Technology technology) {
        // Verificar si la tecnología ya existe en la base de datos
        Optional<Technology> existingTecnologia = tecnologiaPersistencePort.findByName(technology.getName());
        if (existingTecnologia.isPresent()) {
            // Log de depuración o lanzar una excepción según sea necesario
            throw new TechnologyAlreadyExistsException();
        }

        // Guardar la tecnología si está correcto
        tecnologiaPersistencePort.saveTechnology(technology);
    }

    @Override
    public Technology updateTechnology(Technology technology) {
        return tecnologiaPersistencePort.updateTechnology(technology);
    }


    @Override
    public List<Technology> getAllTechnology(Integer page, Integer size, String sortBy) {

        List<Technology> technologyList = tecnologiaPersistencePort.getAllTechnology(page, size, sortBy);

        if (technologyList.isEmpty()){
            throw new NoDataFoundException();
        }
        return technologyList;
    }
}

