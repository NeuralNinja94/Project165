package com.fundgrube.unitTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.http.ResponseEntity;

import com.fundgrube.controller.ArtikelController;
import com.fundgrube.model.Artikel;
import com.fundgrube.service.ArtikelService;

public class ArtikelControllerTest {

    @Test
    void testGetArtikelById_found() {
        // Beispielartikel vorbereiten
        Artikel artikel = new Artikel("Turnbeutel", "Sporthalle", LocalDate.of(2024, 6, 30));
        artikel.setId("123");

        // Service mocken
        ArtikelService mockService = mock(ArtikelService.class);
        when(mockService.findById("123")).thenReturn(Optional.of(artikel));

        // Controller mit dem Mock-Service erzeugen
        ArtikelController controller = new ArtikelController(mockService);

        // Anfrage simulieren
        ResponseEntity<Artikel> response = controller.getArtikelById("123");

        // Überprüfung
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Turnbeutel", response.getBody().getBezeichnung());
        assertEquals("Sporthalle", response.getBody().getStandort());
        assertEquals("232", response.getBody().getSchuelerId());
    }

    @Test
    void testGetArtikelById_notFound() {
        // Service mockt Rückgabe von leerem Optional
        ArtikelService mockService = mock(ArtikelService.class);
        when(mockService.findById("999")).thenReturn(Optional.empty());

        ArtikelController controller = new ArtikelController(mockService);

        // Anfrage simulieren
        ResponseEntity<Artikel> response = controller.getArtikelById("999");

        // Überprüfung
        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
    }
}
