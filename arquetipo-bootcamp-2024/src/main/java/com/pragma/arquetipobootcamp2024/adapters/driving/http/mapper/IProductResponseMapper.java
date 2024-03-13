package com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper;

import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.ProductResponse;
import com.pragma.arquetipobootcamp2024.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductResponseMapper {
    @Mapping(source = "supplier.id", target = "supplierId")
    @Mapping(source = "supplier.name", target = "supplier")
    ProductResponse toProductResponse(Product product);
    List<ProductResponse> toProductResponseList(List<Product> products);
}
