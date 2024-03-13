package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter;


import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TecnologiaEntity;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.NoDataFoundException;
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



//    @Override
//    public List<Tecnologia> getAllTecnologias() {
//        return tecnologiaRepository.findAll()
//                .stream()
//                .map(tecnologiaEntityMapper::toModel)
//                .collect(Collectors.toList());
//    }
}
