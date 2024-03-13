package com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class UpdateProductRequest {
    private final Long id;
    private final String name;
    private final BigDecimal price;
    private final Long quantity;
    private final Long supplierId;
}
