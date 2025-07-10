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

/**
 * Unit-Test für den ArtikelController.
 *
 * Hier wird getestet, wie der Controller auf Service-Rückgaben reagiert.
 * Der Service wird gemockt, damit der Test unabhängig von der Datenbank ist
 * und gezielt verschiedene Rückgabewerte simuliert werden können.
 */
public class ArtikelControllerTest {

    /**
     * Testet den Fall, dass ein Artikel mit der gegebenen ID gefunden wird.
     *
     * Es wird ein Artikel-Objekt erstellt und der Service-Mock so konfiguriert,
     * dass bei der Abfrage mit der ID "123" dieser Artikel zurückgegeben wird.
     * Der Controller wird mit dem Mock-Service erzeugt, damit keine echte Datenbank benötigt wird.
     * Anschließend wird geprüft, ob die Rückgabe des Controllers korrekt ist.
     */
    @Test
    void testGetArtikelById_found() {
        // Beispielartikel vorbereiten
        Artikel artikel = new Artikel("Turnbeutel", "Sporthalle", LocalDate.of(2024, 6, 30));
        artikel.setId("123");

        // Service mocken: Rückgabe des Artikels bei ID "123"
        ArtikelService mockService = mock(ArtikelService.class);
        when(mockService.getArtikelById("123")).thenReturn(Optional.of(artikel));

        // Controller mit dem Mock-Service erzeugen
        ArtikelController controller = new ArtikelController(mockService);

        // Anfrage simulieren
        ResponseEntity<Artikel> response = controller.getArtikelById("123");

        // Überprüfung des Statuscodes und des Rückgabeobjekts
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        // response.getBody() kann laut statischer Analyse null sein, daher explizite Prüfung
        Artikel responseBody = response.getBody();
        if (responseBody != null) {
            // Überprüfe, ob die Werte wie erwartet gesetzt sind
            assertEquals("Turnbeutel", responseBody.getBezeichnung());
            assertEquals("Sporthalle", responseBody.getStandort());
            // Die Schüler-ID ist im Artikel-Objekt ggf. nicht gesetzt, daher kann dieser Test fehlschlagen,
            // wenn das Feld nicht im Konstruktor oder per Setter gesetzt wurde.
            assertEquals("232", responseBody.getSchuelerId());
        }
    }

    /**
     * Testet den Fall, dass ein Artikel mit der gegebenen ID nicht gefunden wird.
     *
     * Der Service-Mock gibt für die ID "999" ein leeres Optional zurück.
     * Es wird geprüft, ob der Controller daraufhin den HTTP-Status 404 und null als Body zurückgibt.
     */
    @Test
    void testGetArtikelById_notFound() {
        // Service mockt Rückgabe von leerem Optional
        ArtikelService mockService = mock(ArtikelService.class);
        when(mockService.getArtikelById("999")).thenReturn(Optional.empty());

        ArtikelController controller = new ArtikelController(mockService);

        // Anfrage simulieren
        ResponseEntity<Artikel> response = controller.getArtikelById("999");

        // Überprüfung: Status 404 und kein Body
        assertEquals(404, response.getStatusCode().value());
        assertNull(response.getBody());
    }
}
