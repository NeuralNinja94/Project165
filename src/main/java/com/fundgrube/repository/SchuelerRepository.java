package com.fundgrube.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fundgrube.model.Schueler;

/**
 * Repository-Interface für den Zugriff auf Schüler in der MongoDB.
 * Erweitert MongoRepository und bietet CRUD-Operationen für Schueler-Objekte.
 */
public interface SchuelerRepository extends MongoRepository<Schueler, String> {
}
