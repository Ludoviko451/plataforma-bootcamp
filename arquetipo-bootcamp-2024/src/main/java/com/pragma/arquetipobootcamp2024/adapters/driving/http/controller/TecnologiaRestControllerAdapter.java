package com.pragma.arquetipobootcamp2024.adapters.driving.http.controller;



import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTecnologiaRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.UpdateTecnologiaRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.TecnologiaResponse;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITecnologiaRequestMapper;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITecnologiaResponseMapper;
import com.pragma.arquetipobootcamp2024.domain.api.ITecnologiaServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tecnologia")

public class TecnologiaRestControllerAdapter {

    private final ITecnologiaServicePort tecnologiaServicePort;
    private final ITecnologiaRequestMapper tecnologiaRequestMapper;
    private final ITecnologiaResponseMapper tecnologiaResponseMapper;

    public TecnologiaRestControllerAdapter(ITecnologiaServicePort tecnologiaServicePort, ITecnologiaRequestMapper tecnologiaRequestMapper, ITecnologiaResponseMapper tecnologiaResponseMapper) {
        this.tecnologiaServicePort = tecnologiaServicePort;
        this.tecnologiaRequestMapper = tecnologiaRequestMapper;
        this.tecnologiaResponseMapper = tecnologiaResponseMapper;
    }

    @PostMapping("/")
    public ResponseEntity<String> addTecnologia(@RequestBody @Valid AddTecnologiaRequest request) {
        tecnologiaServicePort.saveTecnologia(tecnologiaRequestMapper.addRequestToTecnologia(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<TecnologiaResponse>> getAllTecnologias(
            @RequestParam Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(required = false) String sortBy) {
        return ResponseEntity.ok(tecnologiaResponseMapper.toTecnologiaResponseList(tecnologiaServicePort.getAllTecnologias(page, size, sortBy)));
    }

    @PutMapping("/")
    public ResponseEntity<TecnologiaResponse> updateProduct(@RequestBody UpdateTecnologiaRequest request) {
        return ResponseEntity.ok(tecnologiaResponseMapper.toTecnologiaResponse(
                tecnologiaServicePort.updateTecnologia(tecnologiaRequestMapper.updateRequestToTecnologia(request))
        ));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        tecnologiaServicePort.deleteTecnologia(id);
        return ResponseEntity.noContent().build();
    }
}
