package com.pragma.arquetipobootcamp2024.domain.api.usecase;


import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.pragma.arquetipobootcamp2024.domain.api.ITecnologiaServicePort;
import com.pragma.arquetipobootcamp2024.domain.exception.*;
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


    public void saveTecnologia(Tecnologia tecnologia) {
        // Verificar si el nombre y la descripción son válidos
//        if (tecnologia.getNombre() == null || tecnologia.getNombre().isEmpty()) {
//            throw new NombreTecnologiaRequeridoException();
//        }
//        if (tecnologia.getDescripcion() == null || tecnologia.getDescripcion().isEmpty()) {
//            throw new DescripcionTecnologiaRequeridoException();
//        }
//        if (tecnologia.getNombre().length() > 50) {
//            throw new NombreExcedeLongitudMaximaException();
//        }
//        if (tecnologia.getDescripcion().length() > 90) {
//            throw new DescripcionExcedeLongitudMaximaException();
//        }

        // Verificar si la tecnología ya existe en la base de datos
        if (tecnologiaPersistencePort.findByName(tecnologia.getNombre()) != null) {
            // Log de depuración
            throw new TechnologyAlreadyExistsException();
        }

        // Guardar la tecnología si todo está correcto
        tecnologiaPersistencePort.saveTecnologia(tecnologia);
    }



    @Override
    public List<Tecnologia> getAllTecnologias(Integer page, Integer size, String sortBy) {
        return tecnologiaPersistencePort.getAllTecnologias(page, size, sortBy);
    }
}

