package com.pragma.arquetipobootcamp2024.domain.api.usecase;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import com.pragma.arquetipobootcamp2024.domain.spi.ITechnologyPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

 class TechnologyUseCaseTest {

    @Mock
    private ITechnologyPersistencePort technologyPersistencePort;

    private TechnologyUseCase technologyUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        technologyUseCase = new TechnologyUseCase(technologyPersistencePort);
    }

    @Test
    void shouldSaveTecnologiaSuccessfully() {
        // Configuración del mock para que no encuentre ninguna tecnología con el mismo nombre
        when(technologyPersistencePort.findByName(anyString())).thenReturn(Optional.empty());

        // Crear una tecnología
        Technology technology = new Technology(1L, "Java", "Descripción de Java");

        // Llamar al método saveTecnologia
        technologyUseCase.saveTechnology(technology);

        // Verificar que el método saveTecnologia del puerto de persistencia fue invocado una vez
        verify(technologyPersistencePort, times(1)).saveTechnology(technology);
    }

     @Test
     void shouldThrowExceptionWhenTecnologiaExists() {
         // Configurar el comportamiento del mock para que devuelva un Optional con la tecnología
         Technology technology = new Technology(1L, "Java", "Lenguaje de programacion");

         // Configurar qué debe devolver el mock al llamar a tecnologiaPersistencePort.findByName()
         when(technologyPersistencePort.findByName(technology.getName())).thenReturn(Optional.of(technology));

         // Verificar que se lance una excepción cuando se intente guardar una tecnología que ya existe
         assertThrows(TechnologyAlreadyExistsException.class, () -> {
             technologyUseCase.saveTechnology(technology);
         });
     }


     @Test
     void testGetAllTecnologias() {
         Technology technology1 = new Technology(1L, "Java", "Lenguaje de programacion");
         Technology technology2 = new Technology(2L, "Python", "Lenguaje de programacion");

         List<Technology> technologyList = Arrays.asList(technology1, technology2);

         // Configuración del mock para devolver la lista de tecnologías
         when(technologyPersistencePort.getAllTechnology(anyInt(), anyInt(), anyString())).thenReturn(technologyList);

         List<Technology> resultado = technologyUseCase.getAllTechnology(0, 2, "");

         // Comparar solo los nombres de las tecnologías
         assertEquals(2, resultado.size());
         assertEquals("Java", resultado.get(0).getName());
         assertEquals("Python", resultado.get(1).getName());
    }

     @Test
     void shouldThrowNoDataFoundExceptionWhenNoTechnologiesExist() {
         int page = 0;
         int size = 10;
         String orderBy = "";
         when(technologyPersistencePort.getAllTechnology(page, size, orderBy)).thenReturn(Collections.emptyList());

         assertThrows(NoDataFoundException.class, () -> technologyUseCase.getAllTechnology(page, size, orderBy));
     }
   }


