package com.fundgrube.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

/**
 * Repräsentiert einen Artikel (Fundstück) in der Fundgrube-Datenbank.
 */
@Document(collection = "Artikel")
public class Artikel {

    /**
     * Die eindeutige ID des Artikels.
     */
    @Id
    private String id;

    /**
     * Die Bezeichnung des Artikels. Darf nicht leer sein.
     */
    @NotBlank(message = "Bezeichnung darf nicht leer sein")
    private String bezeichnung;

    /**
     * Der Fundort des Artikels. Darf nicht leer sein.
     */
    @NotBlank(message = "Fundort darf nicht leer sein")
    private String gefundenIn;

    /**
     * Das Funddatum des Artikels.
     */
    private LocalDate datum;

    /**
     * Konstruktor zum Erstellen eines Artikels.
     * @param bezeichnung Die Bezeichnung des Artikels
     * @param gefundenIn Der Fundort des Artikels
     * @param datum Das Funddatum
     */
    public Artikel(String bezeichnung, String gefundenIn, LocalDate datum) {
        this.bezeichnung = bezeichnung;
        this.gefundenIn = gefundenIn;
        this.datum = datum;
    }

    /**
     * Gibt die ID des Artikels zurück.
     * @return Die Artikel-ID
     */
    public String getId() { return id; }
    /**
     * Setzt die ID des Artikels.
     * @param id Die neue Artikel-ID
     */
    public void setId(String id) { this.id = id; }

    /**
     * Gibt die Bezeichnung des Artikels zurück.
     * @return Die Bezeichnung
     */
    public String getBezeichnung() { return bezeichnung; }
    /**
     * Setzt die Bezeichnung des Artikels.
     * @param bezeichnung Die neue Bezeichnung
     */
    public void setBezeichnung(String bezeichnung) { this.bezeichnung = bezeichnung; }

    /**
     * Gibt den Fundort des Artikels zurück.
     * @return Der Fundort
     */
    public String getGefundenIn() { return gefundenIn; }
    /**
     * Setzt den Fundort des Artikels.
     * @param gefundenIn Der neue Fundort
     */
    public void setGefundenIn(String gefundenIn) { this.gefundenIn = gefundenIn; }

    /**
     * Gibt das Funddatum des Artikels zurück.
     * @return Das Funddatum
     */
    public LocalDate getDatum() { return datum; }
    /**
     * Setzt das Funddatum des Artikels.
     * @param datum Das neue Funddatum
     */
    public void setDatum(LocalDate datum) { this.datum = datum; }

    /**
     * Noch nicht implementiert. Soll den Standort des Artikels liefern.
     * @return wirft immer UnsupportedOperationException
     */
    public Object getStandort() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Noch nicht implementiert. Soll die Schüler-ID liefern.
     * @return wirft immer UnsupportedOperationException
     */
    public Object getSchuelerId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
