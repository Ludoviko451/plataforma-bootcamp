package com.pragma.arquetipobootcamp2024.domain.api.usecase;


import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.pragma.arquetipobootcamp2024.domain.api.ITecnologiaServicePort;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;
import com.pragma.arquetipobootcamp2024.domain.spi.ITecnologiaPersistencePort;

import java.util.List;

//  Clase que implementa la lógica de negocio relacionada con las operaciones de tecnología.
// Utiliza el puerto de persistencia para interactuar con la capa de almacenamiento de datos.

public class TecnologiaUseCase implements ITecnologiaServicePort {
    private final ITecnologiaPersistencePort tecnologiaPersistencePort;

    public TecnologiaUseCase(ITecnologiaPersistencePort tecnologiaPersistencePort) {
        this.tecnologiaPersistencePort = tecnologiaPersistencePort;
    }


    @Override
    public void deleteTecnologia(Long id) {
        tecnologiaPersistencePort.deleteTecnologia(id);
    }

    @Override
    public void saveTecnologia(Tecnologia tecnologia) {

        // Verificar si la tecnología ya existe en la base de datos
        if (tecnologiaPersistencePort.findByName(tecnologia.getNombre()) != null) {
            // Log de depuración
            throw new TechnologyAlreadyExistsException();
        }

        // Guardar la tecnología si esta correcto
        tecnologiaPersistencePort.saveTecnologia(tecnologia);
    }

    @Override
    public Tecnologia updateTecnologia(Tecnologia tecnologia) {
        return tecnologiaPersistencePort.updateTecnologia(tecnologia);
    }


    @Override
    public List<Tecnologia> getAllTecnologias(Integer page, Integer size, String sortBy) {
        return tecnologiaPersistencePort.getAllTecnologias(page, size, sortBy);
    }
}

