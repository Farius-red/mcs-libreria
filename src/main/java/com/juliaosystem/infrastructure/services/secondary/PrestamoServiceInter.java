package com.juliaosystem.infrastructure.services.secondary;

import com.common.lib.api.response.PlantillaResponse;
import com.juliaosystem.api.dtos.PrestamoDto;
import com.juliaosystem.infrastructure.entitis.User;

public interface PrestamoServiceInter {

    PlantillaResponse<PrestamoDto> add(PrestamoDto prestamoRequest) ;

    User getUserById(Long id);

    PlantillaResponse<PrestamoDto> validarTipoPersona(User user);
}
