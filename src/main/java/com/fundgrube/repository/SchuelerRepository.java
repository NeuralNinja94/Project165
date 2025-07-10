package com.fundgrube.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fundgrube.model.Schueler;

public interface SchuelerRepository extends MongoRepository<Schueler, String> {
}
