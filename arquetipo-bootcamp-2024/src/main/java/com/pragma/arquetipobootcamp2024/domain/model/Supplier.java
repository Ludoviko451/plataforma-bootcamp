package com.pragma.arquetipobootcamp2024.domain.model;

import com.pragma.arquetipobootcamp2024.domain.exception.EmptyFieldException;
import com.pragma.arquetipobootcamp2024.domain.util.DomainConstants;

import java.util.Objects;

public class Supplier {
    private final Long id;
    private final String  name;
    private final String contactNumber;

    public Supplier(Long id, String name, String contactNumber) {
        if (name.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        if (contactNumber.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.CONTACTNUMBER.toString());
        }
        this.id = id;
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.contactNumber = Objects.requireNonNull(contactNumber, DomainConstants.FIELD_CONTACT_NUMBER_NULL_MESSAGE);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
