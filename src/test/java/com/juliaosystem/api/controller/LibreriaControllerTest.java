package com.juliaosystem.api.controller;

import com.common.lib.api.response.PlantillaResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juliaosystem.api.dtos.LibroDTO;
import com.juliaosystem.infrastructure.services.primary.LibroService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class LibreriaControllerTest {

    @MockBean
    private LibroService libroService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void testAdd() throws Exception {
        LibroDTO libroDTO = new LibroDTO();

        var id = UUID.randomUUID();
        PlantillaResponse<LibroDTO> mockResponse = PlantillaResponse.<LibroDTO>builder()
                .httpStatus(HttpStatus.OK)
                .data(libroDTO)
                .build();

        when(libroService.add(any(LibroDTO.class) ,any())).thenReturn(mockResponse);

        mockMvc.perform(post("/libros/add")
                        .header("id" , id)
                        .header("ip" , "prueba")
                        .header("dominio" , "prueha")
                        .header("usuario" , "prueha")
                        .header("proceso" , "prueha")
                        .header("idBussines" ,12345L)
                        .content(asJsonString(libroDTO))
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();


    }

    @Test
    void testGetAll() throws Exception {
        UUID id = UUID.randomUUID();
        Long businessId = 123L;

        PlantillaResponse<LibroDTO> mockResponse = PlantillaResponse.<LibroDTO>builder()
                .httpStatus(HttpStatus.OK)
                .data(new LibroDTO())
                .build();
        when(libroService.all(any(UUID.class), anyLong())).thenReturn(mockResponse);

        mockMvc.perform(get("/libros/all")
                        .param("id", id.toString())
                        .header("ip" , "prueba")
                        .header("dominio" , "prueha")
                        .header("usuario" , "prueha")
                        .header("proceso" , "prueha")
                        .header("idBussines", businessId.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        verify(libroService).all(any(UUID.class), anyLong());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
