package com.juliaosystem.infrastructure.adapters.primary;


import com.common.lib.api.response.PlantillaResponse;
import com.common.lib.infraestructure.services.primary.CrudPrimaryService;
import com.common.lib.utils.enums.MensajesRespuesta;
import com.juliaosystem.api.dtos.LibroDTO;

import com.juliaosystem.infrastructure.services.secondary.LibroServiceInter;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.*;


@Service
@RequiredArgsConstructor
public class LibroImpl implements CrudPrimaryService<LibroDTO,LibroDTO,UUID> {


    private final LibroServiceInter libroServiceInter;



    @Override
    public  PlantillaResponse<LibroDTO> add(LibroDTO libroDTO ,UUID id){
        var res  = libroServiceInter.byId(id);
        if(res.isRta()) return res;
        else return  libroServiceInter.add(libroDTO);
    }

    @Override
    public PlantillaResponse<LibroDTO> delete(UUID id) {
        var res  = libroServiceInter.byId(id);
        if(res.isRta()) return  libroServiceInter.delete(id);
        else return res;
    }

    @Override
    public PlantillaResponse<LibroDTO> all (UUID id, Long idBussines) {

     if(id  == null) {
         if(idBussines == null)
             return libroServiceInter.all();
         else
            return libroServiceInter.byIdBussines(idBussines);
        }else
            return libroServiceInter.byId(id);
    }

    @Override
    public PlantillaResponse<LibroDTO> update(LibroDTO libroDTO) {
        var response = libroServiceInter.byId(libroDTO.getId());
        if (response.isRta()) {
             response = libroServiceInter.add(libroDTO);
             response.setMessage(MensajesRespuesta.ACTUALIZADO.getMensaje());
            return response;
        }
        else {
            return response;
        }
    }
}
