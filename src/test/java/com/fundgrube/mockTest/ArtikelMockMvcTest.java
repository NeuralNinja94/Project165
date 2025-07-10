package com.fundgrube.mockTest;

import com.fundgrube.controller.ArtikelController;
import com.fundgrube.model.Artikel;
import com.fundgrube.service.ArtikelService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.Optional;
import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArtikelController.class)
public class ArtikelMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArtikelService artikelService;

    @Test
    void getArtikelById_shouldReturnArtikel() throws Exception {
        Artikel artikel = new Artikel("Schlüssel", "Zimmer 208", LocalDate.of(2025, 1, 22));
        artikel.setId("123");

        when(artikelService.findById("123")).thenReturn(Optional.of(artikel));

        mockMvc.perform(get("/artikel/123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bezeichnung").value("Schlüssel"))
                .andExpect(jsonPath("$.standort").value("Zimmer 208"))
                .andExpect(jsonPath("$.datum").value("2025-01-22"));
    }

    @Test
    void getArtikelById_shouldReturn404() throws Exception {
        when(artikelService.findById("999")).thenReturn(Optional.empty());

        mockMvc.perform(get("/artikel/999"))
                .andExpect(status().isNotFound());
    }
}
