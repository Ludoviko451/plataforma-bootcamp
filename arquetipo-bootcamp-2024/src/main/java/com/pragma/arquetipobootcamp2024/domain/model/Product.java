package com.pragma.arquetipobootcamp2024.domain.model;

import com.pragma.arquetipobootcamp2024.domain.exception.EmptyFieldException;
import com.pragma.arquetipobootcamp2024.domain.exception.NegativeNotAllowedException;
import com.pragma.arquetipobootcamp2024.domain.util.DomainConstants;

import java.math.BigDecimal;

import static java.util.Objects.requireNonNull;

public class Product {
    private final Long id;
    private final String name;
    private final BigDecimal price;
    private final Long quantity;
    private Supplier supplier;

    public Product(long id, String name, BigDecimal price, Long quantity, Supplier supplier) {
        if (name.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeNotAllowedException(DomainConstants.Field.PRICE.toString());
        }
        if (quantity < 0) {
            throw new NegativeNotAllowedException(DomainConstants.Field.QUANTITY.toString());
        }
        this.id = id;
        this.name = requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.price = requireNonNull(price, DomainConstants.FIELD_PRICE_NULL_MESSAGE);
        this.quantity = requireNonNull(quantity, DomainConstants.FIELD_QUANTITY_NULL_MESSAGE);
        this.supplier = requireNonNull(supplier, DomainConstants.FIELD_SUPPLIER_NULL_MESSAGE);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
