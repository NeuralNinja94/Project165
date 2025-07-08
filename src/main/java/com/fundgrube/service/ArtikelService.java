package com.fundgrube.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundgrube.model.Artikel;
import com.fundgrube.repository.ArtikelRepository;

@Service
public class ArtikelService {

    private final ArtikelRepository artikelRepository;

    @Autowired
    public ArtikelService(ArtikelRepository artikelRepository) {
        this.artikelRepository = artikelRepository;
    }

    public List<Artikel> getAlleArtikel() {
        return artikelRepository.findAll();
    }

    public Optional<Artikel> getArtikelById(String id) {
        return artikelRepository.findById(id);
    }

    public Artikel speichereArtikel(Artikel artikel) {
        return artikelRepository.save(artikel);
    }

    public Optional<Artikel> aktualisiereArtikel(String id, Artikel updatedArtikel) {
        return artikelRepository.findById(id).map(artikel -> {
            updatedArtikel.setId(id);
            return artikelRepository.save(updatedArtikel);
        });
    }

    public boolean loescheArtikel(String id) {
        if (artikelRepository.existsById(id)) {
            artikelRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
