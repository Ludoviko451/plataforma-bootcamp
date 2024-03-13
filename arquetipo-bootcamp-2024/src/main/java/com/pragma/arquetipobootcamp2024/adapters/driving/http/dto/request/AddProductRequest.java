package com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class AddProductRequest {
    private final String name;
    private final BigDecimal price;
    private final Long quantity;
    private final Long supplierId;
}
