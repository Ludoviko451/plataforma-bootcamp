package com.pragma.arquetipobootcamp2024.domain.api.usecase;

import com.pragma.arquetipobootcamp2024.domain.api.IProductServicePort;
import com.pragma.arquetipobootcamp2024.domain.model.Product;
import com.pragma.arquetipobootcamp2024.domain.spi.IProductPersistencePort;

import java.util.List;

public class ProductUseCase implements IProductServicePort {
    private IProductPersistencePort productPersistencePort;

    public ProductUseCase(IProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public void saveProduct(Product product) {
        productPersistencePort.saveProduct(product);
    }

    @Override
    public Product getProduct(String name) {
        return productPersistencePort.getProduct(name);
    }

    @Override
    public List<Product> getAllProducts(Integer page, Integer size) {
        return productPersistencePort.getAllProducts(page, size);
    }

    @Override
    public List<Product> getAllProductsBySupplier(String supplier, Integer page, Integer size) {
        return productPersistencePort.getAllProductsBySupplier(supplier, page, size);
    }

    @Override
    public List<Product> getAllSoldOutProducts(Integer page, Integer size) {
        return productPersistencePort.getAllSoldOutProducts(page, size);
    }

    @Override
    public Product updateProduct(Product product) {
        return productPersistencePort.updateProduct(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productPersistencePort.deleteProduct(id);
    }
}
