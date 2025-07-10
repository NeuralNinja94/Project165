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

/**
 * Unit-Tests für den ArtikelController.
 *
 * In diesen Tests werden die Controller-Methoden direkt aufgerufen.
 * Der Service wird jeweils gemockt, damit die Tests unabhängig von der Datenbank sind
 * und gezielt verschiedene Rückgabewerte simuliert werden können.
 */
public class UnitTest {

    /**
     * Testet, ob der Controller eine Liste mit Artikeln für einen bestimmten Standort korrekt zurückgibt.
     *
     * Es wird ein Artikel-Objekt erstellt und der Service-Mock so konfiguriert,
     * dass bei der Abfrage mit "Zimmer 202" dieser Artikel zurückgegeben wird.
     * Der Controller wird mit dem Mock-Service erzeugt, damit keine echte Datenbank benötigt wird.
     * Anschließend wird geprüft, ob die Rückgabe des Controllers korrekt ist.
     */
    @Test
    void testGetArtikelByStandort_found() {
        // Beispielartikel
        Artikel artikel = new Artikel("Maus", "Zimmer 202", LocalDate.parse("2024-12-31"));
        artikel.setId("123");

        // Mock-Service vorbereiten: Rückgabe des Artikels bei Standort "Zimmer 202"
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

    /**
     * Testet, ob der Controller eine Liste mit Artikeln für ein bestimmtes Datum korrekt zurückgibt.
     *
     * Die Methode findByDatum im Service ist nur für Testzwecke vorhanden.
     * Der Service-Mock gibt für das Datum "2024-12-31" eine Liste mit einem Artikel zurück.
     * Es wird geprüft, ob der Controller diese Liste korrekt zurückgibt.
     */
    @Test
    void testGetArtikelByDatum_found() {
        // Artikel vorbereiten
        Artikel artikel = new Artikel("Laptop-Tasche", "Zimmer 401", LocalDate.of(2024, 12, 31));
        artikel.setId("456");

        ArtikelService mockService = mock(ArtikelService.class);
        // Die Methode findByDatum ist im Service nur für Tests vorhanden.
        when(mockService.findByDatum(LocalDate.of(2024, 12, 31))).thenReturn(List.of(artikel));

        ArtikelController controller = new ArtikelController(mockService);

        List<Artikel> result = controller.getByDatum("2024-12-31");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Laptop-Tasche", result.get(0).getBezeichnung());
        assertEquals("Zimmer 401", result.get(0).getStandort());
    }

    /**
     * Testet, ob der Controller alle Artikel korrekt zurückgibt.
     *
     * Der Service-Mock gibt eine Liste mit zwei Artikeln zurück.
     * Es wird geprüft, ob der Controller diese Liste korrekt weitergibt.
     */
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
