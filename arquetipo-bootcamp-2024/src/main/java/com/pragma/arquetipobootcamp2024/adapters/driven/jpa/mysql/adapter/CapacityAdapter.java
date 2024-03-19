package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.CapacityEntity;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ICapacityEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.pragma.arquetipobootcamp2024.domain.model.Capacity;
import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import com.pragma.arquetipobootcamp2024.domain.spi.ICapacityPersistencePort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class CapacityAdapter implements ICapacityPersistencePort {

    private final ICapacityRepository capacityRepository;
    private final ICapacityEntityMapper capacityEntityMapper;

    private final ITechnologyRepository technologyRepository;

    private final ITechnologyEntityMapper technologyEntityMapper;

    public CapacityAdapter(ICapacityRepository capacityRepository, ICapacityEntityMapper capacityEntityMapper, ITechnologyRepository technologyRepository, ITechnologyEntityMapper technologyEntityMapper) {
        this.capacityRepository = capacityRepository;
        this.capacityEntityMapper = capacityEntityMapper;
        this.technologyRepository = technologyRepository;
        this.technologyEntityMapper = technologyEntityMapper;
    }


    @Override
    public List<Capacity> getAllCapacity(Integer page, Integer size, String orderBy, int technologies) {
        Pageable pagination;
        if (orderBy != null) {
            Sort.Direction direction = Sort.Direction.ASC;
            String sortField = "name"; // Campo predeterminado

            if ("desc".equalsIgnoreCase(orderBy)) {
                direction = Sort.Direction.DESC;
            } else if (!"asc".equalsIgnoreCase(orderBy)) {
                sortField = orderBy;
            }

            pagination = PageRequest.of(page, size, Sort.by(direction, sortField));
        } else {
            pagination = PageRequest.of(page, size);
        }
        List<CapacityEntity> capacityEntityList = capacityRepository.findAll(pagination).getContent();

        return capacityEntityMapper.toModelList(capacityEntityList);
    }

    @Override
    @Transactional
    public void saveCapacity(Capacity capacity) {


        capacityRepository.save(capacityEntityMapper.toEntity(capacity));
    }

    @Override
    public void addTechnologyToCapacity(Long capacityId, List<Long> technologyIds) {
        // Obtener las entidades de tecnología correspondientes a los IDs proporcionados
        List<TechnologyEntity> technologyEntities = technologyRepository.findAllById(technologyIds);

        // Mapear las entidades de tecnología a modelos de tecnología
        List<Technology> technologies = technologyEntityMapper.toModelList(technologyEntities);

        // Buscar la entidad de capacidad por ID
        Optional<CapacityEntity> optionalCapacityEntity = capacityRepository.findById(capacityId);
        if (optionalCapacityEntity.isPresent()) {
            CapacityEntity capacityEntity = optionalCapacityEntity.get();

            // Mapear la entidad de capacidad a un modelo de capacidad
            Capacity capacity = capacityEntityMapper.toModel(capacityEntity);

            // Agregar las tecnologías al modelo de capacidad
            for (Technology technology : technologies) {
                capacity.addTechnology(technology);
            }

            // Guardar la capacidad actualizada en la base de datos
            capacityRepository.save(capacityEntityMapper.toEntity(capacity));
        } else {
            // Manejar el caso en que no se encuentre la capacidad
            throw new NoDataFoundException();
        }
    }

}
