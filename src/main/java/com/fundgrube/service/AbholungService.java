package com.fundgrube.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundgrube.model.Abholung;
import com.fundgrube.repository.AbholungRepository;

/**
 * Service-Klasse für die Verwaltung von Abholungen.
 * Bietet Methoden für CRUD-Operationen auf Abholung-Objekten.
 */
@Service
public class AbholungService {

    /**
     * Repository für den Datenbankzugriff auf Abholungen.
     */
    @Autowired
    private AbholungRepository repository;

    /**
     * Gibt alle Abholungen aus der Datenbank zurück.
     * @return Liste aller Abholungen
     */
    public List<Abholung> getAlleAbholungen() {
        return repository.findAll();
    }

    /**
     * Sucht eine Abholung anhand ihrer ID.
     * @param id Die ID der Abholung
     * @return Optional mit Abholung, falls gefunden, sonst leer
     */
    public Optional<Abholung> getAbholungById(String id) {
        return repository.findById(id);
    }

    /**
     * Erstellt eine neue Abholung in der Datenbank.
     * @param abholung Die zu speichernde Abholung
     * @return Die gespeicherte Abholung
     */
    public Abholung createAbholung(Abholung abholung) {
        return repository.save(abholung);
    }

    /**
     * Aktualisiert eine bestehende Abholung anhand der ID.
     * @param id Die ID der zu aktualisierenden Abholung
     * @param updated Das aktualisierte Abholung-Objekt
     * @return Optional mit aktualisierter Abholung, falls gefunden, sonst leer
     */
    public Optional<Abholung> updateAbholung(String id, Abholung updated) {
        return repository.findById(id).map(existing -> {
            updated.setId(id);
            return repository.save(updated);
        });
    }

    /**
     * Löscht eine Abholung anhand ihrer ID.
     * @param id Die ID der zu löschenden Abholung
     * @return true, wenn die Abholung gelöscht wurde, sonst false
     */
    public boolean deleteAbholung(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
