package com.fundgrube.mockTest;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fundgrube.controller.ArtikelController;
import com.fundgrube.model.Artikel;
import com.fundgrube.service.ArtikelService;

/**
 * Testklasse für den ArtikelController mit MockMvc.
 *
 * Hier wird gezielt getestet, wie der Controller auf HTTP-Anfragen reagiert,
 * ohne dass eine echte Datenbank oder ein echter Service benötigt wird.
 * Stattdessen wird der Service gemockt, um gezielt Rückgabewerte zu simulieren.
 */
@WebMvcTest(ArtikelController.class)
@Import(ArtikelMockMvcTest.TestConfig.class)
public class ArtikelMockMvcTest {

    /**
     * Das MockMvc-Objekt simuliert HTTP-Anfragen an den Controller.
     * Es wird von Spring automatisch bereitgestellt.
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Der gemockte Service, der im Controller verwendet wird.
     * Durch das Mocking können gezielt Rückgabewerte für Tests vorgegeben werden.
     */
    @Autowired
    private ArtikelService artikelService;

    /**
     * Test-Konfiguration, um den gemockten Service in den Spring-Kontext einzubinden.
     * Dadurch wird sichergestellt, dass der Controller im Test nicht mit einer echten Datenbank arbeitet,
     * sondern mit dem hier bereitgestellten Mock-Objekt.
     */
    @org.springframework.context.annotation.Configuration
    static class TestConfig {
        @org.springframework.context.annotation.Bean
        public ArtikelService artikelService() {
            // Rückgabe eines gemockten Service-Objekts
            return org.mockito.Mockito.mock(ArtikelService.class);
        }
    }

    /**
     * Testet den erfolgreichen Abruf eines Artikels per ID.
     *
     * Es wird ein Artikel-Objekt vorbereitet und das Verhalten des gemockten Service so eingestellt,
     * dass bei der Abfrage mit der ID "123" dieser Artikel zurückgegeben wird.
     * Anschließend wird eine HTTP-GET-Anfrage simuliert und geprüft, ob die Rückgabe korrekt ist.
     */
    @Test
    void getArtikelById_shouldReturnArtikel() throws Exception {
        // Testdaten vorbereiten
        Artikel artikel = new Artikel("Schlüssel", "Zimmer 208", LocalDate.of(2025, 1, 22));
        artikel.setId("123");

        // Service-Mock konfigurieren: Bei Aufruf mit "123" soll der Artikel zurückgegeben werden
        when(artikelService.getArtikelById("123")).thenReturn(Optional.of(artikel));

        // HTTP-GET-Anfrage simulieren und Rückgabe prüfen
        mockMvc.perform(get("/artikel/123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bezeichnung").value("Schlüssel"))
                .andExpect(jsonPath("$.standort").value("Zimmer 208"))
                .andExpect(jsonPath("$.datum").value("2025-01-22"));
    }

    /**
     * Testet den Fall, dass ein Artikel mit der gegebenen ID nicht gefunden wird.
     *
     * Der Service-Mock gibt für die ID "999" ein leeres Optional zurück.
     * Es wird geprüft, ob der Controller daraufhin den HTTP-Status 404 zurückgibt.
     */
    @Test
    void getArtikelById_shouldReturn404() throws Exception {
        // Service-Mock konfigurieren: Bei Aufruf mit "999" soll Optional.empty() zurückgegeben werden
        when(artikelService.getArtikelById("999")).thenReturn(Optional.empty());

        // HTTP-GET-Anfrage simulieren und prüfen, ob 404 zurückgegeben wird
        mockMvc.perform(get("/artikel/999"))
                .andExpect(status().isNotFound());
    }
}
