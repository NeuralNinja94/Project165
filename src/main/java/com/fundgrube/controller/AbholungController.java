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

import com.fundgrube.model.Abholung;
import com.fundgrube.service.AbholungService;

import jakarta.validation.Valid;

/**
 * REST-Controller für die Verwaltung von Abholungen.
 * Stellt Endpunkte für CRUD-Operationen auf Abholung-Objekten bereit.
 */
@RestController
@RequestMapping("/abholungen")
public class AbholungController {

    /**
     * Service für die Geschäftslogik rund um Abholungen.
     * Wird von Spring automatisch injiziert.
     */
    @Autowired
    private AbholungService service;

    /**
     * Gibt eine Liste aller Abholungen zurück.
     * GET /abholungen
     * @return Liste aller Abholungen
     */
    @GetMapping
    public List<Abholung> getAlleAbholungen() {
        return service.getAlleAbholungen();
    }

    /**
     * Gibt eine einzelne Abholung anhand der ID zurück.
     * GET /abholungen/{id}
     * @param id Die ID der Abholung
     * @return ResponseEntity mit Abholung oder 404, falls nicht gefunden
     */
    @GetMapping("/{id}")
    public ResponseEntity<Abholung> getAbholungById(@PathVariable String id) {
        // Nutzt Optional, um 404 zurückzugeben, falls nicht gefunden
        return service.getAbholungById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Erstellt eine neue Abholung.
     * POST /abholungen
     * @param abholung Die zu speichernde Abholung (wird validiert)
     * @return Die gespeicherte Abholung
     */
    @PostMapping
    public Abholung createAbholung(@Valid @RequestBody Abholung abholung) {
        return service.createAbholung(abholung);
    }

    /**
     * Aktualisiert eine bestehende Abholung anhand der ID.
     * PUT /abholungen/{id}
     * @param id Die ID der zu aktualisierenden Abholung
     * @param updated Die neuen Abholungsdaten (wird validiert)
     * @return ResponseEntity mit aktualisierter Abholung oder 404, falls nicht gefunden
     */
    @PutMapping("/{id}")
    public ResponseEntity<Abholung> updateAbholung(@PathVariable String id, @Valid @RequestBody Abholung updated) {
        // Nutzt Optional, um 404 zurückzugeben, falls nicht gefunden
        return service.updateAbholung(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Löscht eine Abholung anhand der ID.
     * DELETE /abholungen/{id}
     * @param id Die ID der zu löschenden Abholung
     * @return ResponseEntity mit Status 204 (no content) oder 404 (not found)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbholung(@PathVariable String id) {
        // Gibt 204 zurück, wenn gelöscht, sonst 404
        return service.deleteAbholung(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
