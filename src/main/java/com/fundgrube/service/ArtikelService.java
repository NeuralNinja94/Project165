package com.fundgrube.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundgrube.model.Artikel;
import com.fundgrube.repository.ArtikelRepository;

@Service
public class ArtikelService {

    @Autowired
    private ArtikelRepository repository;

    public List<Artikel> getAlleArtikel() {
        return repository.findAll();
    }

    public Optional<Artikel> getArtikelById(String id) {
        return repository.findById(id);
    }

    public Artikel createArtikel(Artikel artikel) {
        return repository.save(artikel);
    }

    public Optional<Artikel> updateArtikel(String id, Artikel updatedArtikel) {
        return repository.findById(id).map(existing -> {
            updatedArtikel.setId(id);
            return repository.save(updatedArtikel);
        });
    }

    public boolean deleteArtikel(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Object findById(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public Object findById(LocalDate of) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public Object findByDatum(LocalDate of) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDatum'");
    }

    public Object findByStandort(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByStandort'");
    }
}
