package com.pragma.arquetipobootcamp2024.domain.spi;

import com.pragma.arquetipobootcamp2024.domain.model.Supplier;

import java.util.List;

public interface ISupplierPersistencePort {
    void addSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
}
