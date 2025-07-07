package com.fundgrube.controller;

import com.fundgrube.model.Artikel;
import com.fundgrube.service.ArtikelService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artikel")
public class ArtikelController {

    @Autowired
    private ArtikelService service;

    @GetMapping
    public List<Artikel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artikel> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Artikel create(@Valid @RequestBody Artikel artikel) {
        return service.create(artikel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artikel> update(@PathVariable String id, @Valid @RequestBody Artikel updated) {
        return service.update(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
