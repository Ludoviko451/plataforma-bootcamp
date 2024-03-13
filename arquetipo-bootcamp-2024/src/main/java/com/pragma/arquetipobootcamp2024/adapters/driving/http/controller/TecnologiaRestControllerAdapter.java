package com.pragma.arquetipobootcamp2024.adapters.driving.http.controller;


import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTecnologiaRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.ProductResponse;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.TecnologiaResponse;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITecnologiaRequestMapper;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITecnologiaResponseMapper;
import com.pragma.arquetipobootcamp2024.domain.api.ITecnologiaServicePort;
import com.pragma.arquetipobootcamp2024.domain.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<String> addTecnologia(@RequestBody AddTecnologiaRequest request) {
        try {

            tecnologiaServicePort.findByName(request.getNombre());
            tecnologiaServicePort.saveTecnologia(tecnologiaRequestMapper.addRequestToTecnologia(request));
            return ResponseEntity.status(HttpStatus.CREATED).body("Ha sido creada una tecnologia exitosamente");

            //Verificar si el nombre de la tecnologia esta presenta
        } catch (NombreTecnologiaRequeridoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre de la tecnología es requerido");

            //Verificar si la descripcion de la tecnologia esta presente
        } catch (DescripcionTecnologiaRequeridoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La descripcion de la tecnologia es requerida");

            //Verificar que el nombre lo exceda la longitud maxima
        } catch (NombreExcedeLongitudMaximaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre excede la longitud maxima (50 Caracteres)");

            //Verificar que la descripcion no exceda la longitud maxima
        } catch (DescripcionExcedeLongitudMaximaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La descripcion excede la longitud maxima (90 Caracteres)");
        }
        catch (TecnologiaPresenteException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La tecnologia con ese nombre ya se encuentra en la BD");
        }
        catch ( Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Interno");
        }

    }

    @GetMapping("/")
    public ResponseEntity<List<TecnologiaResponse>> getAllTecnologias(
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam String sortBy) {
        return ResponseEntity.ok(tecnologiaResponseMapper.toTecnologiaResponseList(tecnologiaServicePort.getAllTecnologias(page, size, sortBy)));
    }

}
