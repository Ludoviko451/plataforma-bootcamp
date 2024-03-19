package com.pragma.arquetipobootcamp2024.adapters.driving.http.controller;


import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddCapacityRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTechnologyToCapacityRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.CapacityResponse;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ICapacityRequestMapper;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ICapacityResponseMapper;
import com.pragma.arquetipobootcamp2024.domain.api.ICapacityServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/capacity")

public class CapacityRestControllerAdapter {

    public CapacityRestControllerAdapter(ICapacityServicePort capacityServicePort, ICapacityRequestMapper capacityRequestMapper, ICapacityResponseMapper capacityResponseMapper) {
        this.capacityServicePort = capacityServicePort;
        this.capacityRequestMapper = capacityRequestMapper;
        this.capacityResponseMapper = capacityResponseMapper;
    }

    private final ICapacityServicePort capacityServicePort;
    private final ICapacityRequestMapper capacityRequestMapper;
    private final ICapacityResponseMapper capacityResponseMapper;
    @PostMapping("/")
    public ResponseEntity<String> addCapacity(@RequestBody @Valid AddCapacityRequest request) {
        capacityServicePort.saveCapacity(capacityRequestMapper.addRequestToCapacity(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/add")
    public  ResponseEntity<String> addTechnologyToCapacity(@RequestBody AddTechnologyToCapacityRequest request){

        capacityServicePort.addTechnologyToCapacity(request.getCapacityId(), request.getTechnologyIds());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<CapacityResponse>> getAllCapacity(@RequestParam Integer page, @RequestParam Integer size, @RequestParam(required = false) String sortBy, @RequestParam Integer tecnologies){
        return ResponseEntity.ok(capacityResponseMapper.toCapacityResponseList(capacityServicePort.getAllCapacity(page, size, sortBy,tecnologies)));
    }
}
