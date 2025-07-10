package com.fundgrube.integration;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fundgrube.model.Artikel;
import com.fundgrube.repository.ArtikelRepository;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArtikelFindByBezeichnungIT {

    @Autowired
    private ArtikelRepository artikelRepository;

    private String gespeicherteId;

    @BeforeAll
    public void setUp() {
        artikelRepository.deleteAll();

        Artikel artikel = new Artikel("Regenschirm", "Zürich", LocalDate.now());
        artikel = artikelRepository.save(artikel);
        gespeicherteId = artikel.getId();
    }

    @Test
    public void testFindById() {
        Optional<Artikel> artikel = artikelRepository.findById(gespeicherteId);
        assertTrue(artikel.isPresent(), "Artikel wurde gefunden");
        assertEquals("Regenschirm", artikel.get().getBezeichnung());
    }

    @AfterAll
    void tearDown() {
        artikelRepository.deleteAll();
    }
}
