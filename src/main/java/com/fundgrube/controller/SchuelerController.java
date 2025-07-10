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

import com.fundgrube.model.Schueler;
import com.fundgrube.service.SchuelerService;

import jakarta.validation.Valid;

/**
 * REST-Controller für die Verwaltung von Schülern.
 * Stellt Endpunkte für CRUD-Operationen auf Schueler-Objekten bereit.
 */
@RestController
@RequestMapping("/schueler")
public class SchuelerController {

    /**
     * Service für die Geschäftslogik rund um Schüler.
     * Wird von Spring automatisch injiziert.
     */
    @Autowired
    private SchuelerService service;

    /**
     * Gibt eine Liste aller Schüler zurück.
     * GET /schueler
     * @return Liste aller Schüler
     */
    @GetMapping
    public List<Schueler> getAlleSchueler() {
        return service.getAlleSchueler();
    }

    /**
     * Gibt einen einzelnen Schüler anhand der ID zurück.
     * GET /schueler/{id}
     * @param id Die ID des Schülers
     * @return ResponseEntity mit Schüler oder 404, falls nicht gefunden
     */
    @GetMapping("/{id}")
    public ResponseEntity<Schueler> getSchuelerById(@PathVariable String id) {
        // Nutzt Optional, um 404 zurückzugeben, falls nicht gefunden
        return service.getSchuelerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Erstellt einen neuen Schüler.
     * POST /schueler
     * @param schueler Der zu speichernde Schüler (wird validiert)
     * @return Der gespeicherte Schüler
     */
    @PostMapping
    public Schueler createSchueler(@Valid @RequestBody Schueler schueler) {
        return service.createSchueler(schueler);
    }

    /**
     * Aktualisiert einen bestehenden Schüler anhand der ID.
     * PUT /schueler/{id}
     * @param id Die ID des zu aktualisierenden Schülers
     * @param updated Die neuen Schülerdaten (wird validiert)
     * @return ResponseEntity mit aktualisiertem Schüler oder 404, falls nicht gefunden
     */
    @PutMapping("/{id}")
    public ResponseEntity<Schueler> updateSchueler(@PathVariable String id, @Valid @RequestBody Schueler updated) {
        // Nutzt Optional, um 404 zurückzugeben, falls nicht gefunden
        return service.updateSchueler(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Löscht einen Schüler anhand der ID.
     * DELETE /schueler/{id}
     * @param id Die ID des zu löschenden Schülers
     * @return ResponseEntity mit Status 204 (no content) oder 404 (not found)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchueler(@PathVariable String id) {
        // Gibt 204 zurück, wenn gelöscht, sonst 404
        return service.deleteSchueler(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
