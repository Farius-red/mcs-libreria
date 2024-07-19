package com.juliaosystem.api.controller;

import com.common.lib.api.response.PlantillaResponse;
import com.juliaosystem.api.dtos.PrestamoDto;
import com.juliaosystem.infrastructure.services.primary.PrestamoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/prestamos")
@RequiredArgsConstructor
public class PrestamosController {


    private final PrestamoService prestamoService;

    @PostMapping("/add")
    @Operation(summary = "add", description = "Permite agregar un prestamo ")
    public ResponseEntity<PlantillaResponse<PrestamoDto>> add(@RequestBody PrestamoDto prestamoDto) {
        var response = prestamoService.add(prestamoDto);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
