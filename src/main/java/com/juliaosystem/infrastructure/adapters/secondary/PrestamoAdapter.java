package com.juliaosystem.infrastructure.adapters.secondary;

import com.common.lib.api.response.PlantillaResponse;
import com.common.lib.utils.UserResponses;
import com.common.lib.utils.enums.MensajesRespuesta;
import com.common.lib.utils.enums.ResponseType;
import com.common.lib.utils.errors.AbtractError;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.juliaosystem.api.dtos.PrestamoDto;
import com.juliaosystem.api.mappers.PrestamoMapper;
import com.juliaosystem.infrastructure.entitis.Invitado;
import com.juliaosystem.infrastructure.entitis.User;
import com.juliaosystem.infrastructure.repository.PrestamoRepository;
import com.juliaosystem.infrastructure.repository.UserRepository;
import com.juliaosystem.infrastructure.services.secondary.PrestamoServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PrestamoAdapter implements PrestamoServiceInter {

    private static final ObjectMapper OBJECT_MAPPER =
            new ObjectMapper().registerModule(new JavaTimeModule());
    private final AbtractError abtractError;

    private final PrestamoRepository prestamoRepository;
    private final UserRepository userRepository;


    private final UserResponses<PrestamoDto> userResponses;
    private final PrestamoMapper mapper;

    @Override
    public PlantillaResponse<PrestamoDto> add(PrestamoDto prestamoRequest) {
        try {
            var  res = mapper.getDto(prestamoRepository.save(mapper.getEntity(prestamoRequest)));
            abtractError.logInfo("PrestamoAdapter.add():" + MensajesRespuesta.CREADO +     OBJECT_MAPPER.writeValueAsString(res));
            return userResponses.buildResponse(ResponseType.CREATED.getCode(), res);

        }catch (Exception e){
            abtractError.logError(e);
            return   userResponses.buildResponse(ResponseType.FALLO.getCode(), PrestamoDto.builder().build());
        }
    }


    @Override
    public User getUserById(Long id) {
        try {
            var  res = userRepository.findById(id);
            if (res.isPresent()) {
                abtractError.logInfo("PrestamoAdapter.getUserById:" + MensajesRespuesta.GET + OBJECT_MAPPER.writeValueAsString(res));
                return res.get();
            }else Invitado.builder().build();
        }catch (Exception e ){
            abtractError.logError(e);
              return Invitado.builder().build();
        }
        return Invitado.builder().build();
    }

    @Override
    public PlantillaResponse<PrestamoDto> validarTipoPersona(User user) {
        PlantillaResponse<PrestamoDto> res = null;

        try {
            if (user instanceof Invitado) {
                long activeLoans = prestamoRepository.countByUsuarioAndFechaDevolucionAfter(user, LocalDate.now());
                if (activeLoans > 0) {
                    res = userResponses.buildResponse(ResponseType.NO_ENCONTRADO.getCode(), PrestamoDto.builder().build());
                    res.setMessage("No puede solicitar más prestamos ya tiene activo uno");
                    return res;
                }
            }else{
                res =  userResponses.buildResponse(ResponseType.GET.getCode(), PrestamoDto.builder().build());
                return res;
            }

        }catch (Exception e){
            abtractError.logError(e);
            return   userResponses.buildResponse(ResponseType.FALLO.getCode(), PrestamoDto.builder().build());
        }
        return res;
    }
}
