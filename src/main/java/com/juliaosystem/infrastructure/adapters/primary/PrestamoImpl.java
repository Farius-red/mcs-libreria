package com.juliaosystem.infrastructure.adapters.primary;

import com.common.lib.api.response.PlantillaResponse;
import com.common.lib.utils.UserResponses;
import com.common.lib.utils.enums.ResponseType;
import com.juliaosystem.api.dtos.PrestamoDto;
import com.juliaosystem.infrastructure.entitis.User;
import com.juliaosystem.infrastructure.services.secondary.LibroServiceInter;
import com.juliaosystem.infrastructure.services.secondary.PrestamoServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PrestamoImpl {

    private final PrestamoServiceInter prestamoServiceInter;
    private  final LibroServiceInter libroServiceInter;
    private final UserResponses<PrestamoDto> userResponses;


    public PlantillaResponse<PrestamoDto> add(PrestamoDto prestamoRequest) {
        PlantillaResponse<PrestamoDto> res = null;
        var user = prestamoServiceInter.getUserById(prestamoRequest.getUsuario().getId());

        if(!libroServiceInter.byId(prestamoRequest.getLibro().getId()).isRta()) {
            res = userResponses.buildResponse(ResponseType.NO_ENCONTRADO.getCode(), prestamoRequest);
            res.setMessage("Libro No Encontrado");
            return res;
        }

         if(user == null) {
             res = userResponses.buildResponse(ResponseType.NO_ENCONTRADO.getCode(), prestamoRequest);
             res.setMessage("Usuario No Encontrado");
             return res;
         }

         res = validarTipoPersona(user);

        return (res.isRta()) ? prestamoServiceInter.add(prestamoRequest) : res;

    }

    private PlantillaResponse<PrestamoDto> validarTipoPersona(User user){
        return prestamoServiceInter.validarTipoPersona(user);
    }
}
