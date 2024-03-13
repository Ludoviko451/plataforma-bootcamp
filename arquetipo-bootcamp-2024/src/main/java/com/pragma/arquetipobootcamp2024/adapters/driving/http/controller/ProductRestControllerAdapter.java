package com.pragma.arquetipobootcamp2024.adapters.driving.http.controller;

import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddProductRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.UpdateProductRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.ProductResponse;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.IProductRequestMapper;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.IProductResponseMapper;
import com.pragma.arquetipobootcamp2024.domain.api.IProductServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductRestControllerAdapter {
    private final IProductServicePort productServicePort;
    private final IProductRequestMapper productRequestMapper;
    private final IProductResponseMapper productResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addProduct(@RequestBody AddProductRequest request) {
        productServicePort.saveProduct(productRequestMapper.addRequestToProduct(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/search/{productName}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable String productName) {
        return ResponseEntity.ok(productResponseMapper.toProductResponse(productServicePort.getProduct(productName)));
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> getAllProducts(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(productResponseMapper.
                toProductResponseList(productServicePort.getAllProducts(page, size)));
    }

    @GetMapping("/supplier/{supplierName}")
    public ResponseEntity<List<ProductResponse>> getAllProductsBySupplier(@RequestParam Integer page,
                                                                          @RequestParam Integer size,
                                                                          @PathVariable String supplierName) {
        return ResponseEntity.ok(productResponseMapper.
                toProductResponseList(productServicePort.getAllProductsBySupplier(supplierName, page, size)));
    }

    @GetMapping("/soldout")
    public ResponseEntity<List<ProductResponse>> getAllSoldOut(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(productResponseMapper.
                toProductResponseList(productServicePort.getAllSoldOutProducts(page, size)));
    }

    @PutMapping("/")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody UpdateProductRequest request) {
        return ResponseEntity.ok(productResponseMapper.toProductResponse(
                productServicePort.updateProduct(productRequestMapper.updateRequestToProduct(request))
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productServicePort.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
