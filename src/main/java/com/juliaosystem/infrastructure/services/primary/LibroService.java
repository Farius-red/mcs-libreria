package com.juliaosystem.infrastructure.services.primary;

import com.common.lib.api.response.PlantillaResponse;
import com.common.lib.infraestructure.services.primary.CrudPrimaryService;
import com.juliaosystem.api.dtos.LibroDTO;
import com.juliaosystem.infrastructure.adapters.primary.LibroImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class LibroService implements CrudPrimaryService<LibroDTO, LibroDTO,UUID> {


    private final LibroImpl libroImpl;

    @Override
    public PlantillaResponse<LibroDTO> add(LibroDTO libroDTO, UUID id) {
        return libroImpl.add(libroDTO,id);
    }

    @Override
    public PlantillaResponse<LibroDTO> all(UUID id, Long idBussines) {
        return libroImpl.all(id,idBussines);
    }

    @Override
    public PlantillaResponse<LibroDTO> update(LibroDTO libroDTO) {
        return libroImpl.update(libroDTO);
    }

    @Override
    public PlantillaResponse<LibroDTO> delete(UUID id) {
        return libroImpl.delete(id);
    }
}
