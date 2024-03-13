package com.pragma.arquetipobootcamp2024.configuration;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter.ProductAdapter;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter.SupplierAdapter;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter.TecnologiaAdapter;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.IProductEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ISupplierEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ITecnologiaEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.IProductRepository;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ISupplierRepository;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ITecnologiaRepository;
import com.pragma.arquetipobootcamp2024.domain.api.IProductServicePort;
import com.pragma.arquetipobootcamp2024.domain.api.ISupplierServicePort;
import com.pragma.arquetipobootcamp2024.domain.api.ITecnologiaServicePort;
import com.pragma.arquetipobootcamp2024.domain.api.usecase.ProductUseCase;
import com.pragma.arquetipobootcamp2024.domain.api.usecase.SupplierUseCase;
import com.pragma.arquetipobootcamp2024.domain.api.usecase.TecnologiaUseCase;
import com.pragma.arquetipobootcamp2024.domain.spi.IProductPersistencePort;
import com.pragma.arquetipobootcamp2024.domain.spi.ISupplierPersistencePort;
import com.pragma.arquetipobootcamp2024.domain.spi.ITecnologiaPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IProductRepository productRepository;
    private final IProductEntityMapper productEntityMapper;
    private final ITecnologiaEntityMapper tecnologiaEntityMapper;
    private final ITecnologiaRepository tecnologiaRepository;
    private final ISupplierRepository supplierRepository;
    private final ISupplierEntityMapper supplierEntityMapper;


    @Bean
    public IProductPersistencePort productPersistencePort() {
        return new ProductAdapter(productRepository, productEntityMapper, supplierRepository, supplierEntityMapper);
    }
    @Bean
    public IProductServicePort productServicePort() {
        return new ProductUseCase(productPersistencePort());
    }
    @Bean
    public ISupplierPersistencePort supplierPersistencePort() {
        return new SupplierAdapter(supplierRepository, supplierEntityMapper);
    }
    @Bean
    public ISupplierServicePort supplierServicePort() {
        return new SupplierUseCase(supplierPersistencePort());
    }

    @Bean
    public ITecnologiaPersistencePort tecnologiaPersistencePort() {
        return new TecnologiaAdapter(tecnologiaRepository, tecnologiaEntityMapper);
    }

    @Bean
    public ITecnologiaServicePort tecnologiaServicePort() {
        return new TecnologiaUseCase(tecnologiaPersistencePort());
    }
}
