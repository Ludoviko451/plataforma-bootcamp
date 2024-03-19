package com.pragma.arquetipobootcamp2024.domain.api;

import com.pragma.arquetipobootcamp2024.domain.model.Capacity;

import java.util.List;

public interface ICapacityServicePort {

    List<Capacity> getAllCapacity(Integer page, Integer size, String orderBy, int technologies);
    void saveCapacity(Capacity capacity);

    void addTechnologyToCapacity(Long capacityId, List<Long> technolyIds);
}
