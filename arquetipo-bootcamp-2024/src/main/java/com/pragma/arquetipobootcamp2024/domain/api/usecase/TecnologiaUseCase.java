package com.pragma.arquetipobootcamp2024.domain.api.usecase;


import com.pragma.arquetipobootcamp2024.domain.api.ITecnologiaServicePort;
import com.pragma.arquetipobootcamp2024.domain.exception.*;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;
import com.pragma.arquetipobootcamp2024.domain.spi.ITecnologiaPersistencePort;

import java.util.List;

public class TecnologiaUseCase implements ITecnologiaServicePort {
    private final ITecnologiaPersistencePort tecnologiaPersistencePort;

    public TecnologiaUseCase(ITecnologiaPersistencePort tecnologiaPersistencePort) {
        this.tecnologiaPersistencePort = tecnologiaPersistencePort;
    }


    @Override
    public void saveTecnologia(Tecnologia tecnologia) {

        if (tecnologia.getNombre() == null || tecnologia.getNombre().isEmpty()) {

            throw new NombreTecnologiaRequeridoException();
        }
        if (tecnologia.getDescripcion() == null || tecnologia.getDescripcion().isEmpty()) {

            throw new DescripcionTecnologiaRequeridoException();
        }
        if (tecnologia.getNombre().length() > 50) {
            throw new NombreExcedeLongitudMaximaException();
        }
        if (tecnologia.getDescripcion().length() > 90) {
            throw new DescripcionExcedeLongitudMaximaException();
        }
        tecnologiaPersistencePort.saveTecnologia(tecnologia);
    }

    @Override
    public Tecnologia findByName(String nombre) {
        Tecnologia tecnologia = tecnologiaPersistencePort.findByName(nombre);
        if (tecnologia != null) {
            throw new TecnologiaPresenteException();
        }
        return tecnologia;
    }

    @Override
    public List<Tecnologia> getAllTecnologias(Integer page, Integer size, String sortBy) {
        return tecnologiaPersistencePort.getAllTecnologias(page, size, sortBy);
    }
}

