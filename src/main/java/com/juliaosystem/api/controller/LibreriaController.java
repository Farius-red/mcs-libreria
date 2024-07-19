package com.juliaosystem.api.controller;

import com.common.lib.api.controller.CrudController;
import com.common.lib.api.response.PlantillaResponse;
import com.juliaosystem.api.dtos.LibroDTO;
import com.juliaosystem.infrastructure.entitis.Book;
import com.juliaosystem.infrastructure.services.primary.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/libros")
@Tag(name = "libros", description = "Endpoints relacionados con el manejo de prestamos apra libros")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LibreriaController implements CrudController<LibroDTO,LibroDTO, Book,UUID> {

    private final LibroService libroService;


    @NotNull
    @Override
    @Operation(summary = "add", description = "Permite agregar un libro")
    public ResponseEntity<PlantillaResponse<LibroDTO>> add(LibroDTO entidad, @Nullable UUID id, @NotNull String s, @NotNull String s1, @NotNull String s2, long l, @NotNull String s3) {
        var response = libroService.add(entidad, id);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @NotNull
    @Override
    @Operation(summary = "obtener libros", description = "permite obtener lista de libros con filtros por id ")
    public ResponseEntity<PlantillaResponse<LibroDTO>> all(@Nullable UUID id, @NotNull String s, @NotNull String s1, @NotNull String s2, @Nullable Long idBussines, @NotNull String s3) {
        var response = libroService.all(id, idBussines);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @NotNull
    @Override
    @Operation(summary = "Actualizar libros", description = "permite actualizar libros  ")
    public ResponseEntity<PlantillaResponse<LibroDTO>> update(LibroDTO libroDTO, @NotNull String s, @NotNull String s1, @NotNull String s2, long idBussines, @NotNull String s3) {
        var response = libroService.update(libroDTO);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }


    @NotNull
    @Override
    @Operation(summary = "Eliminar libros", description = "permite eliminar   libros c por id ")
    public ResponseEntity<PlantillaResponse<LibroDTO>> delete(UUID id, @NotNull String s, @NotNull String s1, @NotNull String s2, @Nullable Long idBussines, @NotNull String s3) {
        var response = libroService.delete(id);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
