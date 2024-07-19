package com.juliaosystem.api.dtos;

import com.juliaosystem.infrastructure.entitis.Book;
import com.juliaosystem.infrastructure.entitis.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoDto {


    private Long id;
    private Book libro;
    private User usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

}
