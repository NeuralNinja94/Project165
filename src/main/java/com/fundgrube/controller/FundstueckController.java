package com.fundgrube.controller;

import com.fundgrube.model.Fundstueck;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/fundstuecke")
public class FundstueckController {

    private List<Fundstueck> speicher = new ArrayList<>();

    @GetMapping
    public List<Fundstueck> getAlle() {
        return speicher;
    }

    @PostMapping
    public Fundstueck hinzufuegen(@RequestBody Fundstueck fundstueck) {
        fundstueck.setId(UUID.randomUUID().toString());
        speicher.add(fundstueck);
        return fundstueck;
    }
}
