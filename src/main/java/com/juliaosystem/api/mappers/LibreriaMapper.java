package com.juliaosystem.api.mappers;


import com.juliaosystem.api.dtos.LibroDTO;
import com.juliaosystem.infrastructure.entitis.Book;
import org.mapstruct.Mapper;

import org.mapstruct.NullValueCheckStrategy;

import java.util.List;


@Mapper(componentModel ="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface LibreriaMapper {

    List<LibroDTO> getListDTO(List<Book> source);

    Book getEntity(LibroDTO soruce);

    LibroDTO getDto(Book source);
}
