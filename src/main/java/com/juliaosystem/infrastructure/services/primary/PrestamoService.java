package com.juliaosystem.infrastructure.services.primary;

import com.common.lib.api.response.PlantillaResponse;
import com.juliaosystem.api.dtos.PrestamoDto;
import com.juliaosystem.infrastructure.adapters.primary.PrestamoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PrestamoService {

    private final PrestamoImpl prestamoImpl;

    public PlantillaResponse<PrestamoDto> add(PrestamoDto prestamoRequest){
        return prestamoImpl.add(prestamoRequest);
    }
}
