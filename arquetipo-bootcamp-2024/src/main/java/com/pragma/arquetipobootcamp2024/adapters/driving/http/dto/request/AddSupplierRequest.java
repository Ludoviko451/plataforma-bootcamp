package com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddSupplierRequest {
    private final String  name;
    private final String contactNumber;
}
