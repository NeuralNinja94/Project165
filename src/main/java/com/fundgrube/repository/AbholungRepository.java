package com.fundgrube.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fundgrube.model.Abholung;

public interface AbholungRepository extends MongoRepository<Abholung, String> {
}
