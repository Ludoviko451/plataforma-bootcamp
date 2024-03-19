package com.pragma.arquetipobootcamp2024.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Capacity {

    private final Long id;
    private final String name;
    private final String description;
    private final List<Technology> technologyList = new ArrayList<>();




    public Capacity(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void addTechnology(Technology technology) {
        technologyList.add(technology);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public List<Technology> getTechnologyList() {
        return technologyList;
    }


}
