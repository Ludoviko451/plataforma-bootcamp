package com.pragma.arquetipobootcamp2024.domain.api.usecase;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;
import com.pragma.arquetipobootcamp2024.domain.spi.ITecnologiaPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

 class TecnologiaUseCaseTest {

    @Mock
    private ITecnologiaPersistencePort tecnologiaPersistencePort;

    private TecnologiaUseCase tecnologiaUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tecnologiaUseCase = new TecnologiaUseCase(tecnologiaPersistencePort);
    }

    @Test
    void shouldSaveTecnologiaSuccessfully() {
        // Configuración del mock para que no encuentre ninguna tecnología con el mismo nombre
        when(tecnologiaPersistencePort.findByName(anyString())).thenReturn(null);

        // Crear una tecnología
        Tecnologia tecnologia = new Tecnologia(1L, "Java", "Descripción de Java");

        // Llamar al método saveTecnologia
        tecnologiaUseCase.saveTecnologia(tecnologia);

        // Verificar que el método saveTecnologia del puerto de persistencia fue invocado una vez
        verify(tecnologiaPersistencePort, times(1)).saveTecnologia(tecnologia);
    }

     @Test
     void shouldThrowExceptionWhenTecnologiaExists() {
         // Configurar el comportamiento del mock para que devuelva un Optional con la tecnología
         Tecnologia tecnologia = new Tecnologia(1L, "Java", "Lenguaje de programacion");

         // Configurar qué debe devolver el mock al llamar a tecnologiaPersistencePort.findByName()
         when(tecnologiaPersistencePort.findByName(tecnologia.getNombre())).thenReturn(Optional.of(tecnologia));

         // Verificar que se lance una excepción cuando se intente guardar una tecnología que ya existe
         assertThrows(TechnologyAlreadyExistsException.class, () -> {
             tecnologiaUseCase.saveTecnologia(tecnologia);
         });
     }


     @Test
     void testGetAllTecnologias() {
         Tecnologia tecnologia1 = new Tecnologia(1L, "Java", "Lenguaje de programacion");
         Tecnologia tecnologia2 = new Tecnologia(2L, "Python", "Lenguaje de programacion");

         List<Tecnologia> tecnologiaList = Arrays.asList(tecnologia1, tecnologia2);

         // Configuración del mock para devolver la lista de tecnologías
         when(tecnologiaPersistencePort.getAllTecnologias(anyInt(), anyInt(), anyString())).thenReturn(tecnologiaList);

         List<Tecnologia> resultado = tecnologiaUseCase.getAllTecnologias(0, 2, "");

         // Comparar solo los nombres de las tecnologías
         assertEquals(2, resultado.size());
         assertEquals("Java", resultado.get(0).getNombre());
         assertEquals("Python", resultado.get(1).getNombre());
    }
}
