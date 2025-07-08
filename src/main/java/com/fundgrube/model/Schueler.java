package com.fundgrube.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "Schueler")
public class Schueler {

    @Id
    private String id;

    @NotBlank(message = "Name darf nicht leer sein")
    private String name;

    @NotBlank(message = "Vorname darf nicht leer sein")
    private String vorname;

    @Email(message = "Ungültige E-Mail-Adresse")
    private String email;

    @NotBlank(message = "Klasse darf nicht leer sein")
    private String klasse;

    public Schueler() {}

    public Schueler(String name, String vorname, String email, String klasse) {
        this.name = name;
        this.vorname = vorname;
        this.email = email;
        this.klasse = klasse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String gerVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }
}
