package com.juliaosystem.infrastructure.repository;


import com.juliaosystem.infrastructure.entitis.Prestamo;
import com.juliaosystem.infrastructure.entitis.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    long countByUsuarioAndFechaDevolucionAfter(User user, LocalDate date);

}
