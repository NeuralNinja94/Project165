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

@RestController
@RequestMapping("/abholungen")
public class AbholungController {

    @Autowired
    private AbholungService service;

    @GetMapping
    public List<Abholung> getAlleAbholungen() {
        return service.getAlleAbholungen();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abholung> getAbholungById(@PathVariable String id) {
        return service.getAbholungById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Abholung createAbholung(@Valid @RequestBody Abholung abholung) {
        return service.createAbholung(abholung);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abholung> updateAbholung(@PathVariable String id, @Valid @RequestBody Abholung updated) {
        return service.updateAbholung(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbholung(@PathVariable String id) {
        return service.deleteAbholung(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
