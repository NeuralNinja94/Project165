package com.fundgrube.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

@Document(collection = "Artikel")
public class Artikel {

    @Id
    private String id;

    @NotBlank(message = "Bezeichnung darf nicht leer sein")
    private String bezeichnung;

    @NotBlank(message = "Standort darf nicht leer sein")
    private String standort;

    @NotBlank(message = "Schueler-ID darf nicht leer sein")
    private String schuelerId;

    public Artikel() {}

    public Artikel(String bezeichnung, String standort, String schuelerId) {
        this.bezeichnung = bezeichnung;
        this.standort = standort;
        this.schuelerId = schuelerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getStandort() {
        return standort;
    }

    public void setStandort(String standort) {
        this.standort = standort;
    }

    public String getSchuelerId() {
        return schuelerId;
    }

    public void setSchuelerId(String schuelerId) {
        this.schuelerId = schuelerId;
    }
}
