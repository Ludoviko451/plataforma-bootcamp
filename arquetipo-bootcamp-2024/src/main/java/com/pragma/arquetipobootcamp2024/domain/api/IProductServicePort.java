package com.pragma.arquetipobootcamp2024.domain.api;

import com.pragma.arquetipobootcamp2024.domain.model.Product;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IProductServicePort {
    void saveProduct(Product product);
    Product getProduct(String name);
    List<Product> getAllProducts(Integer page, Integer size);
    List<Product> getAllProductsBySupplier(String supplier, Integer page, Integer size);
    List<Product> getAllSoldOutProducts(Integer page, Integer size);
    Product updateProduct(Product product);
    void deleteProduct(Long id);
}
