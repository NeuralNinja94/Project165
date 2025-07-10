package com.fundgrube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundgrube.model.Artikel;
import com.fundgrube.service.ArtikelService;

import jakarta.validation.Valid;

/**
 * REST-Controller für die Verwaltung von Artikeln.
 * Stellt Endpunkte für CRUD-Operationen auf Artikel-Objekten bereit.
 */
@RestController
@RequestMapping("/artikel")
public class ArtikelController {

    /**
     * Konstruktor für Dependency Injection im Test (z.B. für Mocking).
     * Im Produktivbetrieb wird der Service über @Autowired gesetzt.
     * @param mockService gemockter Service für Unit-Tests
     */
    public ArtikelController(ArtikelService mockService) {
    }

    /**
     * Service für die Geschäftslogik rund um Artikel.
     * Wird von Spring automatisch injiziert.
     */
    @Autowired
    private ArtikelService service;

    /**
     * Gibt eine Liste aller Artikel zurück.
     * GET /artikel
     * @return Liste aller Artikel
     */
    @GetMapping
    public List<Artikel> getAlleArtikel() {
        return service.getAlleArtikel();
    }

    /**
     * Gibt einen einzelnen Artikel anhand der ID zurück.
     * GET /artikel/{id}
     * @param id Die ID des Artikels
     * @return ResponseEntity mit Artikel oder 404, falls nicht gefunden
     */
    @GetMapping("/{id}")
    public ResponseEntity<Artikel> getArtikelById(@PathVariable String id) {
        // Nutzt Optional, um 404 zurückzugeben, falls nicht gefunden
        return service.getArtikelById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Erstellt einen neuen Artikel.
     * POST /artikel
     * @param artikel Der zu speichernde Artikel (wird validiert)
     * @return Der gespeicherte Artikel
     */
    @PostMapping
    public Artikel createArtikel(@Valid @RequestBody Artikel artikel) {
        return service.createArtikel(artikel);
    }

    /**
     * Aktualisiert einen bestehenden Artikel anhand der ID.
     * PUT /artikel/{id}
     * @param id Die ID des zu aktualisierenden Artikels
     * @param updatedArtikel Die neuen Artikeldaten (wird validiert)
     * @return ResponseEntity mit aktualisiertem Artikel oder 404, falls nicht gefunden
     */
    @PutMapping("/{id}")
    public ResponseEntity<Artikel> updateArtikel(@PathVariable String id, @Valid @RequestBody Artikel updatedArtikel) {
        // Nutzt Optional, um 404 zurückzugeben, falls nicht gefunden
        return service.updateArtikel(id, updatedArtikel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Löscht einen Artikel anhand der ID.
     * DELETE /artikel/{id}
     * @param id Die ID des zu löschenden Artikels
     * @return ResponseEntity mit Status 204 (no content) oder 404 (not found)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtikel(@PathVariable String id) {
        // Gibt 204 zurück, wenn gelöscht, sonst 404
        return service.deleteArtikel(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * Noch nicht implementiert. Soll Artikel anhand eines Datums liefern.
     * @param string Das Datum als String
     * @return wirft immer UnsupportedOperationException
     */
    public List<Artikel> getByDatum(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Noch nicht implementiert. Soll Artikel anhand eines Standorts liefern.
     * @param zimmer_202 Der Standort als String
     * @return wirft immer UnsupportedOperationException
     */
    public List<Artikel> getByStandort(String zimmer_202) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
