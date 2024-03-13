package com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper;

import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddSupplierRequest;
import com.pragma.arquetipobootcamp2024.domain.model.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISupplierRequestMapper {
    @Mapping(target = "id", ignore = true)
    Supplier addRequestToSupplier(AddSupplierRequest addSupplierRequest);
}
