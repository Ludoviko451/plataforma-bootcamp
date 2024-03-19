package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter;


import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TechnologyEntity;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import com.pragma.arquetipobootcamp2024.domain.spi.ITechnologyPersistencePort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


// Adaptador que implementa el puerto de persistencia de tecnologías.
// Utiliza Spring Data JPA para interactuar con la base de datos MySQL.

//La anotación Spring Component se utiliza para indicar una clase como componente. Significa que Spring detectará automáticamente
//estas clases para la inyección de dependencia cuando se utilice la configuración basada en anotaciones y el escaneo de classpath.
@Component
public class TechnologyAdapter implements ITechnologyPersistencePort {

    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    public TechnologyAdapter(ITechnologyRepository technologyRepository, ITechnologyEntityMapper technologyEntityMapper) {
        this.technologyRepository = technologyRepository;
        this.technologyEntityMapper = technologyEntityMapper;
    }

    @Override

    public void saveTechnology(Technology technology) {


        technologyRepository.save(technologyEntityMapper.toEntity(technology));
    }

    @Override
    public void deleteTechnology(Long id) {

        if (technologyRepository.findById(id).isEmpty()) {
            throw new ElementNotFoundException();
        }
        technologyRepository.deleteById(id);
    }

    @Override
    public Optional<Technology> findByName(String name) {
        TechnologyEntity technologyEntity = technologyRepository.findByName(name);
        return technologyEntity != null ? Optional.of(technologyEntityMapper.toModel(technologyEntity)) : Optional.empty();
    }


    @Override
    public List<Technology> getAllTechnology(Integer page, Integer size, String sortBy) {

        Pageable pagination;
        if (sortBy != null) {
            Sort.Direction direction = Sort.Direction.ASC;
            String sortField = "name"; // Campo predeterminado

            if ("desc".equalsIgnoreCase(sortBy)) {
                direction = Sort.Direction.DESC;
            } else if (!"asc".equalsIgnoreCase(sortBy)) {
                sortField = sortBy;
            }

            pagination = PageRequest.of(page, size, Sort.by(direction, sortField));
        } else {
            pagination = PageRequest.of(page, size);
        }

        List<TechnologyEntity> technologyEntities = technologyRepository.findAll(pagination).getContent();

        return technologyEntityMapper.toModelList(technologyEntities);
    }

    @Override
    public Technology updateTechnology(Technology technology) {
        if (technologyRepository.findById(technology.getId()).isEmpty()) {
            throw new ElementNotFoundException();
        }
        return technologyEntityMapper.toModel(technologyRepository.save(technologyEntityMapper.toEntity(technology)));
    }


}
