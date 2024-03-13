package com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SupplierResponse {
    private final Long id;
    private final String  name;
    private final String contactNumber;
}
