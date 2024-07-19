package com.juliaosystem.infrastructure.entitis;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book libro;

    @ManyToOne
    private User usuario;

    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
}
