package com.fundgrube.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundgrube.model.Schueler;
import com.fundgrube.repository.SchuelerRepository;

@Service
public class SchuelerService {

    @Autowired
    private SchuelerRepository repository;

    public List<Schueler> getAlleSchueler() {
        return repository.findAll();
    }

    public Optional<Schueler> getSchuelerById(String id) {
        return repository.findById(id);
    }

    public Schueler createSchueler(Schueler schueler) {
        return repository.save(schueler);
    }

    public Optional<Schueler> updateSchueler(String id, Schueler updated) {
        return repository.findById(id).map(existing -> {
            updated.setId(id);
            return repository.save(updated);
        });
    }

    public boolean deleteSchueler(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
