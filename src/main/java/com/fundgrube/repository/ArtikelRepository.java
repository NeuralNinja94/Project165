package com.fundgrube.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fundgrube.model.Artikel;

@Repository
public interface ArtikelRepository extends MongoRepository<Artikel, String> {

    public List<Artikel> findByStandort(String zimmer_303);
}
