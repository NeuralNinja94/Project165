package com.fundgrube.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Document(collection = "Artikel")
public class Artikel {

    @Id
    private String id;

    @NotBlank(message = "Bezeichnung darf nicht leer sein")
    private String bezeichnung;

    @NotBlank(message = "Standort darf nicht leer sein")
    private String standort;

    @NotBlank(message = "Schüler darf nicht leer sein")
    private String schueler;

    @Email(message = "Ungültige E-Mail-Adresse")
    private String email;

    public Artikel() {}

    public Artikel(String bezeichnung, String standort, String schueler, String email) {
        this.bezeichnung = bezeichnung;
        this.standort = standort;
        this.schueler = schueler;
        this.email = email;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getBezeichnung() { return bezeichnung; }
    public void setBezeichnung(String bezeichnung) { this.bezeichnung = bezeichnung; }

    public String getStandort() { return standort; }
    public void setStandort(String standort) { this.standort = standort; }

    public String getSchueler() { return schueler; }
    public void setSchueler(String schueler) { this.schueler = schueler; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
