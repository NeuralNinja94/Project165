package com.fundgrube.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundgrube.model.Abholung;
import com.fundgrube.repository.AbholungRepository;

@Service
public class AbholungService {

    @Autowired
    private AbholungRepository repository;

    public List<Abholung> getAlleAbholungen() {
        return repository.findAll();
    }

    public Optional<Abholung> getAbholungById(String id) {
        return repository.findById(id);
    }

    public Abholung createAbholung(Abholung abholung) {
        return repository.save(abholung);
    }

    public Optional<Abholung> updateAbholung(String id, Abholung updated) {
        return repository.findById(id).map(existing -> {
            updated.setId(id);
            return repository.save(updated);
        });
    }

    public boolean deleteAbholung(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
