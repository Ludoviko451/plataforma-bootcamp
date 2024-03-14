package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository;


import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.ProductEntity;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TecnologiaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//este repositorio define métodos para realizar operaciones de consulta
//en la tabla de tecnologías de una base de datos MySQL utilizando Spring Data JPA.
//Proporciona métodos convenientes para buscar tecnologías por nombre y para obtener todas las tecnologías de forma paginada.
public interface ITecnologiaRepository extends JpaRepository<TecnologiaEntity, Long> {

    TecnologiaEntity findByNombre(String nombre);

    Page<TecnologiaEntity> findAll(Pageable pageable);
}
