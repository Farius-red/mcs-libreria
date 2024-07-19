package com.juliaosystem.infrastructure.entitis;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String title;
    private String author;
    private int publicationYear;
    private String isbn;


}
