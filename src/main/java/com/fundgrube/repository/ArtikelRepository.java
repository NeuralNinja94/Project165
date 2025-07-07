package com.fundgrube.repository;

import com.fundgrube.model.Artikel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtikelRepository extends MongoRepository<Artikel, String> {
}
