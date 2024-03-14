package com.pragma.arquetipobootcamp2024.domain.api.usecase;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;
import com.pragma.arquetipobootcamp2024.domain.spi.ITecnologiaPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TecnologiaUseCaseTest {

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

}
