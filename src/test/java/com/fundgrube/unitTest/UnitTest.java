package com.fundgrube.unitTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fundgrube.controller.ArtikelController;
import com.fundgrube.model.Artikel;
import com.fundgrube.service.ArtikelService;

public class UnitTest {

    @Test
    void testGetArtikelByStandort_found() {
        // Beispielartikel
        Artikel artikel = new Artikel("Maus", "Zimmer 202", LocalDate.parse("2024-12-31"));
        artikel.setId("123");

        // Mock-Service vorbereiten
        ArtikelService mockService = mock(ArtikelService.class);
        when(mockService.findByStandort("Zimmer 202")).thenReturn(List.of(artikel));

        // Controller mit Mock-Service
        ArtikelController controller = new ArtikelController(mockService);

        // Controller-Methode direkt aufrufen
        List<Artikel> result = controller.getByStandort("Zimmer 202");

        // Überprüfung
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Maus", result.get(0).getBezeichnung());
    }

    @Test
    void testGetArtikelByDatum_found() {
        // Artikel vorbereiten
        Artikel artikel = new Artikel("Laptop-Tasche", "Zimmer 401", LocalDate.of(2024, 12, 31));
        artikel.setId("456");

        ArtikelService mockService = mock(ArtikelService.class);
        when(mockService.findByDatum(LocalDate.of(2024, 12, 31))).thenReturn(List.of(artikel));

        ArtikelController controller = new ArtikelController(mockService);

        List<Artikel> result = controller.getByDatum("2024-12-31");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Laptop-Tasche", result.get(0).getBezeichnung());
        assertEquals("Zimmer 401", result.get(0).getStandort());
    }

    @Test
    void testGetAllArtikel_returnsList() {
        Artikel a1 = new Artikel("Laptop", "Zimmer 408", LocalDate.of(2024, 12, 31));
        Artikel a2 = new Artikel("Handy", "Zimmer 206", LocalDate.of(2024, 12, 31));

        ArtikelService mockService = mock(ArtikelService.class);
        when(mockService.getAlleArtikel()).thenReturn(List.of(a1, a2));

        ArtikelController controller = new ArtikelController(mockService);

        List<Artikel> result = controller.getAlleArtikel();

        assertEquals(2, result.size());
        assertEquals("Laptop", result.get(0).getBezeichnung());
        assertEquals("Handy", result.get(1).getBezeichnung());
    }
}
