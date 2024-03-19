package com.pragma.arquetipobootcamp2024.domain.spi;

import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.CapacityResponse;
import com.pragma.arquetipobootcamp2024.domain.model.Capacity;

import java.util.List;

public interface ICapacityPersistencePort {
    List<Capacity> getAllCapacity(Integer page, Integer size, String orderBy, int technologies);
    void saveCapacity(Capacity capacity);
    void addTechnologyToCapacity(Long capacityId, List<Long> technologyIds);
}
