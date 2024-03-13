package com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper;

import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.SupplierResponse;
import com.pragma.arquetipobootcamp2024.domain.model.Supplier;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ISupplierResponseMapper {
    SupplierResponse toSupplierResponse(Supplier supplier);
    List<SupplierResponse> toSupplierResponseList(List<Supplier> suppliers);
}
