package com.fundgrube.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundgrube.model.Artikel;
import com.fundgrube.repository.ArtikelRepository;

/**
 * Service-Klasse für die Verwaltung von Artikeln.
 * Bietet Methoden für CRUD-Operationen und spezielle Abfragen auf Artikel-Objekten.
 */
@Service
public class ArtikelService {

    /**
     * Repository für den Datenbankzugriff auf Artikel.
     */
    @Autowired
    private ArtikelRepository repository;

    /**
     * Gibt alle Artikel aus der Datenbank zurück.
     * @return Liste aller Artikel
     */
    public List<Artikel> getAlleArtikel() {
        return repository.findAll();
    }

    /**
     * Sucht einen Artikel anhand seiner ID.
     * @param id Die ID des Artikels
     * @return Optional mit Artikel, falls gefunden, sonst leer
     */
    public Optional<Artikel> getArtikelById(String id) {
        return repository.findById(id);
    }

    /**
     * Erstellt einen neuen Artikel in der Datenbank.
     * @param artikel Der zu speichernde Artikel
     * @return Der gespeicherte Artikel
     */
    public Artikel createArtikel(Artikel artikel) {
        return repository.save(artikel);
    }

    /**
     * Aktualisiert einen bestehenden Artikel anhand der ID.
     * @param id Die ID des zu aktualisierenden Artikels
     * @param updatedArtikel Das aktualisierte Artikel-Objekt
     * @return Optional mit aktualisiertem Artikel, falls gefunden, sonst leer
     */
    public Optional<Artikel> updateArtikel(String id, Artikel updatedArtikel) {
        return repository.findById(id).map(existing -> {
            updatedArtikel.setId(id);
            return repository.save(updatedArtikel);
        });
    }

    /**
     * Löscht einen Artikel anhand seiner ID.
     * @param id Die ID des zu löschenden Artikels
     * @return true, wenn der Artikel gelöscht wurde, sonst false
     */
    public boolean deleteArtikel(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Platzhalter-Methode, wird nur für bestimmte Testfälle oder Framework-Kompatibilität benötigt.
     * Nicht implementiert.
     * @deprecated Diese Methode ist nicht implementiert und sollte nicht produktiv verwendet werden.
     * @param string Die ID als String
     * @return Nicht implementiert
     * @throws UnsupportedOperationException immer
     */
    @Deprecated
    public Object findById(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    /**
     * Platzhalter-Methode, wird nur für bestimmte Testfälle oder Framework-Kompatibilität benötigt.
     * Nicht implementiert.
     * @deprecated Diese Methode ist nicht implementiert und sollte nicht produktiv verwendet werden.
     * @param of Das LocalDate
     * @return Nicht implementiert
     * @throws UnsupportedOperationException immer
     */
    @Deprecated
    public Object findById(LocalDate of) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    /**
     * Nicht implementiert. Soll Artikel anhand eines Datums finden.
     * @param of Das LocalDate
     * @return Nicht implementiert
     * @throws UnsupportedOperationException immer
     */
    public Object findByDatum(LocalDate of) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDatum'");
    }

    /**
     * Sucht alle Artikel an einem bestimmten Standort.
     * @param zimmer_303 Der Standort (z.B. Zimmernummer)
     * @return Liste der gefundenen Artikel
     */
        public List<Artikel> findByStandort(String zimmer_303) {
            return repository.findByStandort(zimmer_303);
        }
    
    }

