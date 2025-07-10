package com.fundgrube.integration;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fundgrube.model.Artikel;
import com.fundgrube.repository.ArtikelRepository;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArtikelFindByStandortIT {

    @Autowired
    private ArtikelRepository artikelRepository;

    @BeforeEach
    public void setUp() {
        artikelRepository.deleteAll();
        artikelRepository.save(new Artikel("Taschenlampe", "Zimmer 303", LocalDate.now()));
        artikelRepository.save(new Artikel("Trinkflasche", "Zimmer 202", LocalDate.now()));
        artikelRepository.save(new Artikel("Powerbank", "Zimmer 101", LocalDate.now()));
    }

    @Test
    public void testFindByStandortZimmer303() {
        List<Artikel> artikel = artikelRepository.findByStandort("Zimmer 303");
        assertEquals(1, artikel.size(), "Es sollte genau ein Artikel im Raum Zimmer 303 sein");
        assertEquals("Taschenlampe", artikel.get(0).getBezeichnung());
    }

    @AfterEach
    public void tearDown() {
        artikelRepository.deleteAll();
    }
}
