package com.fundgrube.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fundgrube.model.Abholung;

/**
 * Repository-Interface für den Zugriff auf Abholungen in der MongoDB.
 * Erweitert MongoRepository und bietet CRUD-Operationen für Abholung-Objekte.
 */
public interface AbholungRepository extends MongoRepository<Abholung, String> {
}
