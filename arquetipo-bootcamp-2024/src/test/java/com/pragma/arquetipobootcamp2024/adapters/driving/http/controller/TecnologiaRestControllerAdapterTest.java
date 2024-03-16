package com.pragma.arquetipobootcamp2024.adapters.driving.http.controller;

import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.TecnologiaResponse;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITecnologiaRequestMapper;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITecnologiaResponseMapper;
import com.pragma.arquetipobootcamp2024.domain.api.ITecnologiaServicePort;
import com.pragma.arquetipobootcamp2024.domain.model.Tecnologia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTecnologiaRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TecnologiaRestControllerAdapterTest {

    @Mock
    private ITecnologiaServicePort tecnologiaServicePort;
    @Mock
    private ITecnologiaRequestMapper tecnologiaRequestMapper;
    @Mock
    private ITecnologiaResponseMapper tecnologiaResponseMapper;
    private TecnologiaRestControllerAdapter tecnologiaRestControllerAdapter;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        tecnologiaRestControllerAdapter = new TecnologiaRestControllerAdapter(tecnologiaServicePort, tecnologiaRequestMapper, tecnologiaResponseMapper);
    }


    @Test
    void shouldReturnCreatedHttpStatusWhenTecnologiaIsSuccessfullySaved(){

        AddTecnologiaRequest addTecnologiaRequest = new AddTecnologiaRequest("Java", "Lenguaje de programacion");

        Tecnologia tecnologia = new Tecnologia(1L, "Java", "Lenguaje de programacion");
        when(tecnologiaRequestMapper.addRequestToTecnologia(addTecnologiaRequest)).thenReturn(tecnologia);

        ResponseEntity<?> responseEntity = tecnologiaRestControllerAdapter.addTecnologia(addTecnologiaRequest);

        verify(tecnologiaServicePort, times(1)).saveTecnologia(tecnologia);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }


    @ParameterizedTest
    @CsvSource({"asc", "desc"})
    void testGetAllTecnologias(String sortBy) {
         Tecnologia tecnologia1 = new Tecnologia(1L, "Java", "Lenguaje de programacion");
         Tecnologia tecnologia2 = new Tecnologia(2L, "Python", "Lenguaje de programacion");
         int page = 0;
         int size = 5;


         List<Tecnologia> tecnologiaList = Arrays.asList(tecnologia1, tecnologia2);

         List<TecnologiaResponse> tecnologiaResponses = new ArrayList<>();

         tecnologiaResponses.add(new TecnologiaResponse(1L, "Java", "Lenguaje de programacion"));
         tecnologiaResponses.add(new TecnologiaResponse(2L, "Python", "Lenguaje de programacion"));

         when(tecnologiaServicePort.getAllTecnologias(anyInt(), anyInt(), anyString())).thenReturn(tecnologiaList);

         when(tecnologiaResponseMapper.toTecnologiaResponseList(tecnologiaList)).thenReturn(tecnologiaResponses);

         ResponseEntity<List<TecnologiaResponse>> responseEntity = tecnologiaRestControllerAdapter.getAllTecnologias(page,size, sortBy);

         assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
         assertEquals(tecnologiaResponses, responseEntity.getBody());
     }

}
