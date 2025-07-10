package com.fundgrube.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fundgrube.model.Artikel;

/**
 * Repository-Interface für den Zugriff auf Artikel in der MongoDB.
 * Erweitert MongoRepository und bietet CRUD-Operationen sowie eigene Suchmethoden für Artikel.
 */
@Repository
public interface ArtikelRepository extends MongoRepository<Artikel, String> {

    /**
     * Sucht alle Artikel an einem bestimmten Standort.
     * @param zimmer_303 Der Standort (z.B. Zimmernummer)
     * @return Liste der gefundenen Artikel
     */
    public List<Artikel> findByStandort(String zimmer_303);
}
