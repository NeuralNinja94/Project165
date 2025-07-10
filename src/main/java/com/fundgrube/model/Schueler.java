package com.fundgrube.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Repräsentiert einen Schüler in der Fundgrube-Datenbank.
 */
@Document(collection = "Schueler")
public class Schueler {

    /**
     * Die eindeutige ID des Schülers.
     */
    @Id
    private String id;

    /**
     * Der Vorname des Schülers. Darf nicht leer sein.
     */
    @NotBlank
    private String vorname;

    /**
     * Der Nachname des Schülers. Darf nicht leer sein.
     */
    @NotBlank
    private String nachname;

    /**
     * Die E-Mail-Adresse des Schülers. Muss gültig sein.
     */
    @Email
    @JsonProperty("e-mail")
    private String email;

    /**
     * Standardkonstruktor.
     */
    public Schueler() {}

    /**
     * Konstruktor zum Erstellen eines Schülers.
     * @param vorname Der Vorname
     * @param nachname Der Nachname
     * @param email Die E-Mail-Adresse
     */
    public Schueler(String vorname, String nachname, String email) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
    }

    /**
     * Gibt die ID des Schülers zurück.
     * @return Die Schüler-ID
     */
    public String getId() { return id; }
    /**
     * Setzt die ID des Schülers.
     * @param id Die neue Schüler-ID
     */
    public void setId(String id) { this.id = id; }

    /**
     * Gibt den Vornamen zurück.
     * @return Der Vorname
     */
    public String getVorname() { return vorname; }
    /**
     * Setzt den Vornamen.
     * @param vorname Der neue Vorname
     */
    public void setVorname(String vorname) { this.vorname = vorname; }

    /**
     * Gibt den Nachnamen zurück.
     * @return Der Nachname
     */
    public String getNachname() { return nachname; }
    /**
     * Setzt den Nachnamen.
     * @param nachname Der neue Nachname
     */
    public void setNachname(String nachname) { this.nachname = nachname; }

    /**
     * Gibt die E-Mail-Adresse zurück.
     * @return Die E-Mail-Adresse
     */
    public String getEmail() { return email; }
    /**
     * Setzt die E-Mail-Adresse.
     * @param email Die neue E-Mail-Adresse
     */
    public void setEmail(String email) { this.email = email; }
}
