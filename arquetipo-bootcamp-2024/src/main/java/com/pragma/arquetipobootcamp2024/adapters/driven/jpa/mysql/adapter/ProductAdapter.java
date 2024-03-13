package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.ProductEntity;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.SupplierEntity;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.ProductAlreadyExistsException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.SupplierNotFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.IProductEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ISupplierEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.IProductRepository;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ISupplierRepository;
import com.pragma.arquetipobootcamp2024.configuration.Constants;
import com.pragma.arquetipobootcamp2024.domain.model.Product;
import com.pragma.arquetipobootcamp2024.domain.spi.IProductPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class ProductAdapter implements IProductPersistencePort {
    private final IProductRepository productRepository;
    private final IProductEntityMapper productEntityMapper;
    private final ISupplierRepository supplierRepository;
    private final ISupplierEntityMapper supplierEntityMapper;

    @Override
    public void saveProduct(Product product) {
        if (productRepository.findByName(product.getName()).isPresent()) {
            throw new ProductAlreadyExistsException();
        }
        SupplierEntity supplier = supplierRepository.findById(product.getSupplier().getId())
                .orElseThrow(SupplierNotFoundException::new);
        product.setSupplier(supplierEntityMapper.toModel(supplier));
        productRepository.save(productEntityMapper.toEntity(product));
    }

    @Override
    public Product getProduct(String name) {
        ProductEntity product = productRepository.findByNameContaining(name).orElseThrow(ElementNotFoundException::new);
        return productEntityMapper.toModel(product);
    }

    @Override
    public List<Product> getAllProducts(Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        List<ProductEntity> products = productRepository.findAll(pagination).getContent();
        if (products.isEmpty()) {
            throw new NoDataFoundException();
        }
        return productEntityMapper.toModelList(products);
    }

    @Override
    public List<Product> getAllProductsBySupplier(String supplier, Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        List<ProductEntity> products = productRepository.findAllBySupplierNameContaining(supplier, pagination).getContent();
        if (products.isEmpty()) {
            throw new NoDataFoundException();
        }
        return productEntityMapper.toModelList(products);
    }

    @Override
    public List<Product> getAllSoldOutProducts(Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        List<ProductEntity> products = productRepository.findAllByQuantityLessThanEqual(
                Constants.SOLD_OUT_VALUE, pagination).getContent();
        if (products.isEmpty()) {
            throw new NoDataFoundException();
        }
        return productEntityMapper.toModelList(products);
    }

    @Override
    public Product updateProduct(Product product) {
        if (productRepository.findById(product.getId()).isEmpty()) {
            throw new ElementNotFoundException();
        }
        SupplierEntity supplier = supplierRepository.findById(product.getSupplier().getId())
                .orElseThrow(SupplierNotFoundException::new);
        product.setSupplier(supplierEntityMapper.toModel(supplier));
        return productEntityMapper.toModel(productRepository.save(productEntityMapper.toEntity(product)));
    }

    @Override
    public void deleteProduct(Long id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new ElementNotFoundException();
        }
        productRepository.deleteById(id);
    }
}
