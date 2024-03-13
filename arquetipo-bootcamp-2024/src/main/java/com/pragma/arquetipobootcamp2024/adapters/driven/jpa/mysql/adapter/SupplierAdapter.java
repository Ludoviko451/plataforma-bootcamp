package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.SupplierEntity;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.SupplierAlreadyExistsException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ISupplierEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ISupplierRepository;
import com.pragma.arquetipobootcamp2024.domain.model.Supplier;
import com.pragma.arquetipobootcamp2024.domain.spi.ISupplierPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SupplierAdapter implements ISupplierPersistencePort {
    private final ISupplierRepository supplierRepository;
    private final ISupplierEntityMapper supplierEntityMapper;

    @Override
    public void addSupplier(Supplier supplier) {
        if (supplierRepository.findByName(supplier.getName()).isPresent()) {
            throw new SupplierAlreadyExistsException();
        }
        supplierRepository.save(supplierEntityMapper.toEntity(supplier));
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        List<SupplierEntity> suppliers = supplierRepository.findAll();
        if (suppliers.isEmpty()) {
            throw new NoDataFoundException();
        }
        return supplierEntityMapper.toModelList(suppliers);
    }
}
