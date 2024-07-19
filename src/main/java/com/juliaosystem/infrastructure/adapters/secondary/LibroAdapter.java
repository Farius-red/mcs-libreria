package com.juliaosystem.infrastructure.adapters.secondary;


import com.common.lib.api.response.PlantillaResponse;
import com.common.lib.utils.UserResponses;
import com.common.lib.utils.enums.MensajesRespuesta;
import com.common.lib.utils.enums.ResponseType;
import com.common.lib.utils.errors.AbtractError;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.juliaosystem.api.dtos.LibroDTO;
import com.juliaosystem.api.mappers.LibreriaMapper;
import com.juliaosystem.infrastructure.repository.LibroRepository;
import com.juliaosystem.infrastructure.services.secondary.LibroServiceInter;

import lombok.RequiredArgsConstructor;



import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class LibroAdapter implements LibroServiceInter {

    private static final ObjectMapper OBJECT_MAPPER =
            new ObjectMapper().registerModule(new JavaTimeModule());
    private final AbtractError abtractError;

    private final LibroRepository libroRepository;
    private final UserResponses<LibroDTO> userResponses;
    private final LibreriaMapper mapper;



    @Override
    public PlantillaResponse<LibroDTO> byId(UUID id) {
        try {
           var listLibros = libroRepository.findById(id);
            if(listLibros.isEmpty()){
                abtractError.logInfo("LibroAdapter.byId():" + MensajesRespuesta.NO_ENCONTRADO +  OBJECT_MAPPER.writeValueAsString(id));
                return userResponses.buildResponse(ResponseType.NO_ENCONTRADO.getCode(), LibroDTO.builder().build());
            }else {
                var listDTO = mapper.getListDTO(listLibros.stream().toList());
                abtractError.logInfo("LibroAdapter.byId()" + MensajesRespuesta.GET +     OBJECT_MAPPER.writeValueAsString(listDTO));
                return userResponses.buildResponse(ResponseType.GET.getCode(), LibroDTO.builder().build(),listDTO);
            }
        }catch (Exception e){
            abtractError.logError(e);
            return   userResponses.buildResponse(ResponseType.FALLO.getCode(), LibroDTO.builder().build());
        }
    }

    @Override
    public PlantillaResponse<LibroDTO> all() {
        try {
            var listUsers = libroRepository.findAll();
            if(listUsers.isEmpty()){
                abtractError.logInfo("libroAdapter.all():" + MensajesRespuesta.NO_ENCONTRADO +"de usuarios" +  OBJECT_MAPPER.writeValueAsString(listUsers));
                return userResponses.buildResponse(ResponseType.NO_ENCONTRADO.getCode(), LibroDTO.builder().build());
            }else {
                var listDTO = mapper.getListDTO(listUsers.stream().toList());
                abtractError.logInfo("libroAdapter.all():" + MensajesRespuesta.GET);
                return userResponses.buildResponse(ResponseType.GET.getCode(), LibroDTO.builder().build(),listDTO);
            }
        }catch (Exception e){
            abtractError.logError(e);
            return   userResponses.buildResponse(ResponseType.FALLO.getCode(), LibroDTO.builder().build());
        }
    }

    @Override
    public PlantillaResponse<LibroDTO> add(LibroDTO libroDTO) {

       try {
           var  res = mapper.getDto(libroRepository.save(mapper.getEntity(libroDTO)));
           abtractError.logInfo("LibroAdapter.add():" + MensajesRespuesta.CREADO +     OBJECT_MAPPER.writeValueAsString(res));
                   return userResponses.buildResponse(ResponseType.CREATED.getCode(), res);

       }catch (Exception e){
           abtractError.logError(e);
           return   userResponses.buildResponse(ResponseType.FALLO.getCode(), LibroDTO.builder().build());
       }
    }

    @Override
    public PlantillaResponse<LibroDTO> delete(UUID id) {
        try {
            libroRepository.deleteById(id);
            abtractError.logInfo("LibroAdapter.delete():" + MensajesRespuesta.DELETED +     OBJECT_MAPPER.writeValueAsString(id));
            return userResponses.buildResponse(ResponseType.DELETED.getCode(), LibroDTO.builder().id(id).build());

        }catch (Exception e){
            abtractError.logError(e);
            return   userResponses.buildResponse(ResponseType.FALLO.getCode(), LibroDTO.builder().build());
        }
    }
}
