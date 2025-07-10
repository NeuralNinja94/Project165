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

@RestController
@RequestMapping("/artikel")
public class ArtikelController {

    public ArtikelController(ArtikelService mockService) {
    }

    @Autowired
    private ArtikelService service;

    @GetMapping
    public List<Artikel> getAlleArtikel() {
        return service.getAlleArtikel();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artikel> getArtikelById(@PathVariable String id) {
        return service.getArtikelById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Artikel createArtikel(@Valid @RequestBody Artikel artikel) {
        return service.createArtikel(artikel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artikel> updateArtikel(@PathVariable String id, @Valid @RequestBody Artikel updatedArtikel) {
        return service.updateArtikel(id, updatedArtikel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtikel(@PathVariable String id) {
        return service.deleteArtikel(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    public List<Artikel> getByDatum(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Artikel> getByStandort(String zimmer_202) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
