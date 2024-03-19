package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "capacity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CapacityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "capacity_technology",
            joinColumns = @JoinColumn(name = "capacity_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private List<TechnologyEntity> technologyList;

    // Constructor, getters y setters
    // Recuerda que necesitarás tener los constructores, getters y setters aquí
    // Opcionalmente, también podrías considerar métodos adicionales según tus necesidades específicas
    // Por ejemplo, un método para agregar tecnología a la lista, etc.
}
