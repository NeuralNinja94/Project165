package com.fundgrube.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

@Document(collection = "Artikel")
public class Artikel {

    @Id
    private String id;

    @NotBlank(message = "Bezeichnung darf nicht leer sein")
    private String bezeichnung;

    @NotBlank(message = "Fundort darf nicht leer sein")
    private String gefundenIn;

    private LocalDate datum;

    public Artikel(String bezeichnung, String gefundenIn, LocalDate datum) {
        this.bezeichnung = bezeichnung;
        this.gefundenIn = gefundenIn;
        this.datum = datum;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getBezeichnung() { return bezeichnung; }
    public void setBezeichnung(String bezeichnung) { this.bezeichnung = bezeichnung; }

    public String getGefundenIn() { return gefundenIn; }
    public void setGefundenIn(String gefundenIn) { this.gefundenIn = gefundenIn; }

    public LocalDate getDatum() { return datum; }
    public void setDatum(LocalDate datum) { this.datum = datum; }

    public Object getStandort() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getSchuelerId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
