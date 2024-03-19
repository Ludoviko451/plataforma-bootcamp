package com.pragma.arquetipobootcamp2024.adapters.driving.http.controller;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.TechnologyResponse;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITechnologyRequestMapper;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITechnologyResponseMapper;
import com.pragma.arquetipobootcamp2024.domain.api.ITechnologyServicePort;
import com.pragma.arquetipobootcamp2024.domain.model.Technology;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class TechnologyRestControllerAdapterTest {

    @Mock
    private ITechnologyServicePort technologyServicePort;
    @Mock
    private ITechnologyRequestMapper technologyRequestMapper;
    @Mock
    private ITechnologyResponseMapper technologyResponseMapper;
    private TechnologyRestControllerAdapter technologyRestControllerAdapter;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        technologyRestControllerAdapter = new TechnologyRestControllerAdapter(technologyServicePort, technologyRequestMapper, technologyResponseMapper);
    }


    @Test
    void shouldReturnCreatedHttpStatusWhenTecnologiaIsSuccessfullySaved(){

        AddTechnologyRequest addTechnologyRequest = new AddTechnologyRequest("Java", "Lenguaje de programacion");

        Technology technology = new Technology(1L, "Java", "Lenguaje de programacion");
        when(technologyRequestMapper.addRequestToTechnology(addTechnologyRequest)).thenReturn(technology);

        ResponseEntity<?> responseEntity = technologyRestControllerAdapter.addTechnology(addTechnologyRequest);

        verify(technologyServicePort, times(1)).saveTechnology(technology);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }


    @ParameterizedTest
    @CsvSource({"asc", "desc"})
    void testGetAllTecnologias(String sortBy) {
         Technology technology1 = new Technology(1L, "Java", "Lenguaje de programacion");
         Technology technology2 = new Technology(2L, "Python", "Lenguaje de programacion");
         int page = 0;
         int size = 5;


         List<Technology> technologyList = Arrays.asList(technology1, technology2);

         List<TechnologyResponse> technologyResponse = new ArrayList<>();

         technologyResponse.add(new TechnologyResponse(1L, "Java", "Lenguaje de programacion"));
         technologyResponse.add(new TechnologyResponse(2L, "Python", "Lenguaje de programacion"));

         when(technologyServicePort.getAllTechnology(anyInt(), anyInt(), anyString())).thenReturn(technologyList);

         when(technologyResponseMapper.toTechnologyResponseList(technologyList)).thenReturn(technologyResponse);

         ResponseEntity<List<TechnologyResponse>> responseEntity = technologyRestControllerAdapter.getAllTechnology(page,size, sortBy);

         assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
         assertEquals(technologyResponse, responseEntity.getBody());
     }


}




