package com.fundgrube.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundgrube.model.Schueler;
import com.fundgrube.repository.SchuelerRepository;

/**
 * Service-Klasse für die Verwaltung von Schülern.
 * Bietet Methoden für CRUD-Operationen auf Schueler-Objekten.
 */
@Service
public class SchuelerService {

    /**
     * Repository für den Datenbankzugriff auf Schüler.
     */
    @Autowired
    private SchuelerRepository repository;

    /**
     * Gibt alle Schüler aus der Datenbank zurück.
     * @return Liste aller Schüler
     */
    public List<Schueler> getAlleSchueler() {
        return repository.findAll();
    }

    /**
     * Sucht einen Schüler anhand seiner ID.
     * @param id Die ID des Schülers
     * @return Optional mit Schüler, falls gefunden, sonst leer
     */
    public Optional<Schueler> getSchuelerById(String id) {
        return repository.findById(id);
    }

    /**
     * Erstellt einen neuen Schüler in der Datenbank.
     * @param schueler Der zu speichernde Schüler
     * @return Der gespeicherte Schüler
     */
    public Schueler createSchueler(Schueler schueler) {
        return repository.save(schueler);
    }

    /**
     * Aktualisiert einen bestehenden Schüler anhand der ID.
     * @param id Die ID des zu aktualisierenden Schülers
     * @param updated Das aktualisierte Schüler-Objekt
     * @return Optional mit aktualisiertem Schüler, falls gefunden, sonst leer
     */
    public Optional<Schueler> updateSchueler(String id, Schueler updated) {
        return repository.findById(id).map(existing -> {
            updated.setId(id);
            return repository.save(updated);
        });
    }

    /**
     * Löscht einen Schüler anhand seiner ID.
     * @param id Die ID des zu löschenden Schülers
     * @return true, wenn der Schüler gelöscht wurde, sonst false
     */
    public boolean deleteSchueler(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
