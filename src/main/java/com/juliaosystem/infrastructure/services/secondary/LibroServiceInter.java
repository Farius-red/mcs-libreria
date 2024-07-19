package com.juliaosystem.infrastructure.services.secondary;


import com.common.lib.infraestructure.services.secundary.CrudSecundaryService;
import com.juliaosystem.api.dtos.LibroDTO;

import java.util.UUID;


public interface LibroServiceInter extends CrudSecundaryService<LibroDTO,LibroDTO, UUID> {

}
