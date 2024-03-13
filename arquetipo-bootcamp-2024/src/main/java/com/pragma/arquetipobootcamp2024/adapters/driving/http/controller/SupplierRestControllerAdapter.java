package com.pragma.arquetipobootcamp2024.adapters.driving.http.controller;

import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddSupplierRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.SupplierResponse;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ISupplierRequestMapper;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ISupplierResponseMapper;
import com.pragma.arquetipobootcamp2024.domain.api.ISupplierServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierRestControllerAdapter {
    private final ISupplierServicePort supplierServicePort;
    private final ISupplierRequestMapper supplierRequestMapper;
    private final ISupplierResponseMapper supplierResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addSupplier(@RequestBody AddSupplierRequest request) {
        supplierServicePort.addSupplier(supplierRequestMapper.addRequestToSupplier(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<SupplierResponse>> getSuppliers() {
        return ResponseEntity.ok(supplierResponseMapper.toSupplierResponseList(supplierServicePort.getAllSuppliers()));
    }
}
