package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//Entidad JPA que representa la tabla 'tecnologia' en la base de datos MySQL.
@Entity
@Table(name = "tecnologia")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TecnologiaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 50)
    private String nombre;
    @Column(unique = true, nullable = false, length = 90)
    private String descripcion;


}
