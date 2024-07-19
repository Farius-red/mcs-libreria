package com.juliaosystem.api.mappers;

import com.juliaosystem.api.dtos.PrestamoDto;
import com.juliaosystem.infrastructure.entitis.Prestamo;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel ="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PrestamoMapper {


    Prestamo getEntity(PrestamoDto prestamoRequest);

    PrestamoDto getDto(Prestamo save);
}
