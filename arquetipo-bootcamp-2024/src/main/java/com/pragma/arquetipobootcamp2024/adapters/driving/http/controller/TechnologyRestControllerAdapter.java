package com.pragma.arquetipobootcamp2024.adapters.driving.http.controller;



import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.UpdateTechnologyRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.TechnologyResponse;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITechnologyRequestMapper;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITechnologyResponseMapper;
import com.pragma.arquetipobootcamp2024.domain.api.ITechnologyServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/technology")

public class TechnologyRestControllerAdapter {

    private final ITechnologyServicePort tecnologiaServicePort;
    private final ITechnologyRequestMapper tecnologiaRequestMapper;
    private final ITechnologyResponseMapper tecnologiaResponseMapper;

    public TechnologyRestControllerAdapter(ITechnologyServicePort tecnologiaServicePort, ITechnologyRequestMapper tecnologiaRequestMapper, ITechnologyResponseMapper tecnologiaResponseMapper) {
        this.tecnologiaServicePort = tecnologiaServicePort;
        this.tecnologiaRequestMapper = tecnologiaRequestMapper;
        this.tecnologiaResponseMapper = tecnologiaResponseMapper;
    }

    @PostMapping("/")
    public ResponseEntity<String> addTechnology(@RequestBody @Valid AddTechnologyRequest request) {
        tecnologiaServicePort.saveTechnology(tecnologiaRequestMapper.addRequestToTechnology(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<TechnologyResponse>> getAllTechnology(
            @RequestParam Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(required = false) String sortBy) {
        return ResponseEntity.ok(tecnologiaResponseMapper.toTechnologyResponseList(tecnologiaServicePort.getAllTechnology(page, size, sortBy)));
    }

    @PutMapping("/")
    public ResponseEntity<TechnologyResponse> updateTechnology(@RequestBody UpdateTechnologyRequest request) {
        return ResponseEntity.ok(tecnologiaResponseMapper.toTechnologyResponse(
                tecnologiaServicePort.updateTechnology(tecnologiaRequestMapper.updateRequestToTechnology(request))
        ));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable Long id) {
        tecnologiaServicePort.deleteTechnology(id);
        return ResponseEntity.noContent().build();
    }
}
