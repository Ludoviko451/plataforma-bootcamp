package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter;


import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TecnologiaEntity;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ITecnologiaEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ITecnologiaRepository;
import com.pragma.arquetipobootcamp2024.domain.model.Product;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;
import com.pragma.arquetipobootcamp2024.domain.spi.ITecnologiaPersistencePort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;



// Adaptador que implementa el puerto de persistencia de tecnologías.
// Utiliza Spring Data JPA para interactuar con la base de datos MySQL.

//La anotación Spring Component se utiliza para indicar una clase como componente. Significa que Spring detectará automáticamente
//estas clases para la inyección de dependencia cuando se utilice la configuración basada en anotaciones y el escaneo de classpath.
@Component
public class TecnologiaAdapter implements ITecnologiaPersistencePort {

    private final ITecnologiaRepository tecnologiaRepository;
    private final ITecnologiaEntityMapper tecnologiaEntityMapper;

    public TecnologiaAdapter(ITecnologiaRepository tecnologiaRepository, ITecnologiaEntityMapper tecnologiaEntityMapper) {
        this.tecnologiaRepository = tecnologiaRepository;
        this.tecnologiaEntityMapper = tecnologiaEntityMapper;
    }

    @Override
    public void saveTecnologia(Tecnologia tecnologia) {


        tecnologiaRepository.save(tecnologiaEntityMapper.toEntity(tecnologia));
    }

    @Override
    public Tecnologia findByName(String name) {
        TecnologiaEntity tecnologiaEntity = tecnologiaRepository.findByNombre(name);
        return tecnologiaEntity != null ? tecnologiaEntityMapper.toModel(tecnologiaEntity) : null;
    }

    @Override
    public List<Tecnologia> getAllTecnologias(Integer page, Integer size, String sortBy) {
        Sort.Direction direction = Sort.Direction.ASC;
        String sortField = "nombre"; // Campo predeterminado

        if ("desc".equalsIgnoreCase(sortBy)) {
            direction = Sort.Direction.DESC;
        } else if (!"asc".equalsIgnoreCase(sortBy)) {
            sortField = sortBy;
        }

        Pageable pagination = PageRequest.of(page, size, Sort.by(direction, sortField));
        List<TecnologiaEntity> tecnologiaEntities = tecnologiaRepository.findAll(pagination).getContent();
        return tecnologiaEntityMapper.toModelList(tecnologiaEntities);
    }




}
