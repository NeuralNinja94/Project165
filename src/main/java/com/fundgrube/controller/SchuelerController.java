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

@RestController
@RequestMapping("/schueler")
public class SchuelerController {

    @Autowired
    private SchuelerService service;

    @GetMapping
    public List<Schueler> getAlleSchueler() {
        return service.getAlleSchueler();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schueler> getSchuelerById(@PathVariable String id) {
        return service.getSchuelerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Schueler createSchueler(@Valid @RequestBody Schueler schueler) {
        return service.createSchueler(schueler);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schueler> updateSchueler(@PathVariable String id, @Valid @RequestBody Schueler updated) {
        return service.updateSchueler(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchueler(@PathVariable String id) {
        return service.deleteSchueler(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
