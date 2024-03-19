package com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository;


import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


//este repositorio define métodos para realizar operaciones de consulta
//en la tabla de tecnologías de una base de datos MySQL utilizando Spring Data JPA.
//Proporciona métodos convenientes para buscar tecnologías por nombre y para obtener todas las tecnologías de forma paginada.
public interface ITechnologyRepository extends JpaRepository<TechnologyEntity, Long> {

    TechnologyEntity findByName(String name);



    Page<TechnologyEntity> findAll(Pageable pageable);
}
