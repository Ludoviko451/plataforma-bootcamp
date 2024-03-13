package com.pragma.arquetipobootcamp2024.domain.api;

import com.pragma.arquetipobootcamp2024.domain.model.Supplier;

import java.util.List;

public interface ISupplierServicePort {
    void addSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
}
