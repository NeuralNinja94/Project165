package com.fundgrube.service;

import com.fundgrube.model.Artikel;
import com.fundgrube.repository.ArtikelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtikelService {

    @Autowired
    private ArtikelRepository repository;

    public List<Artikel> getAll() {
        return repository.findAll();
    }

    public Optional<Artikel> getById(String id) {
        return repository.findById(id);
    }

    public Artikel create(Artikel artikel) {
        return repository.save(artikel);
    }

    public Optional<Artikel> update(String id, Artikel updated) {
        return repository.findById(id)
                .map(existing -> {
                    updated.setId(id);
                    return repository.save(updated);
                });
    }

    public boolean delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
