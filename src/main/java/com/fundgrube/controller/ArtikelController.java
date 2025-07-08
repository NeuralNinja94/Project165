package com.fundgrube.controller;

import com.fundgrube.model.Artikel;
import com.fundgrube.service.ArtikelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artikel")
public class ArtikelController {

    private final ArtikelService artikelService;

    @Autowired
    public ArtikelController(ArtikelService artikelService) {
        this.artikelService = artikelService;
    }

    // GET /artikel → Alle Artikel abrufen
    @GetMapping
    public ResponseEntity<List<Artikel>> getAllArtikel() {
        List<Artikel> artikelListe = artikelService.getAlleArtikel();
        return ResponseEntity.ok(artikelListe);
    }

    // GET /artikel/{id} → Einzelnen Artikel abrufen
    @GetMapping("/{id}")
    public ResponseEntity<Artikel> getArtikelById(@PathVariable String id) {
        Optional<Artikel> artikel = artikelService.getArtikelById(id);
        return artikel.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // POST /artikel → Neuen Artikel hinzufügen
    @PostMapping
    public ResponseEntity<Artikel> addArtikel(@RequestBody Artikel artikel) {
        Artikel gespeichert = artikelService.speichereArtikel(artikel);
        return ResponseEntity.ok(gespeichert);
    }

    // PUT /artikel/{id} → Artikel aktualisieren
    @PutMapping("/{id}")
    public ResponseEntity<Artikel> updateArtikel(@PathVariable String id, @RequestBody Artikel artikel) {
        Optional<Artikel> aktualisiert = artikelService.aktualisiereArtikel(id, artikel);
        return aktualisiert.map(ResponseEntity::ok)
                           .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /artikel/{id} → Artikel löschen
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtikel(@PathVariable String id) {
        boolean geloescht = artikelService.loescheArtikel(id);
        return geloescht ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
