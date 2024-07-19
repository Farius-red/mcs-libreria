package com.juliaosystem.infrastructure.repository;

import com.juliaosystem.infrastructure.entitis.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LibroRepository extends JpaRepository<Book, UUID> {
}
