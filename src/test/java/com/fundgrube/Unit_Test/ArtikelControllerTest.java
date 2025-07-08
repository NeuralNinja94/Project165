package com.fundgrube.Unit_Test;

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
        // Beispielartikel
        Artikel artikel = new Artikel("Turnbeutel", "Sporthalle", "232");
        artikel.setId("123");

        // Service mocken
        ArtikelService mockService = mock(ArtikelService.class);
        when(mockService.getArtikelById("123")).thenReturn(Optional.of(artikel));

        // Controller mit Mock
        ArtikelController controller = new ArtikelController(mockService);

        // Anfrage simulieren
        ResponseEntity<Artikel> response = controller.getArtikelById("123");

        // Überprüfen
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("Sporthalle", response.getBody().getStandort());
    }

    @Test
    void testGetArtikelById_notFound() {
        ArtikelService mockService = mock(ArtikelService.class);
        when(mockService.getArtikelById("999")).thenReturn(Optional.empty());

        ArtikelController controller = new ArtikelController(mockService);

        ResponseEntity<Artikel> response = controller.getArtikelById("999");

        assertEquals(404, response.getStatusCode().value());
        assertNull(response.getBody());
    }
}
