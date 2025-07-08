package com.fundgrube.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "AbgeholteArtikel")
public class Abholung {

    @Id
    private String id;

    @NotBlank(message = "Artikel-ID darf nicht leer sein")
    private String artikelId;

    @NotBlank(message = "Schueler-ID darf nicht leer sein")
    private String schuelerId;

    @NotNull(message = "Abholdatum darf nicht null sein")
    private LocalDateTime abholdatum;

    public Abholung() {}

    public Abholung(String artikelId, String schuelerId, LocalDateTime abholdatum) {
        this.artikelId = artikelId;
        this.schuelerId = schuelerId;
        this.abholdatum = abholdatum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtikelId() {
        return artikelId;
    }

    public void setArtikelId(String artikelId) {
        this.artikelId = artikelId;
    }

    public String getSchuelerId() {
        return schuelerId;
    }

    public void setSchuelerId(String schuelerId) {
        this.schuelerId = schuelerId;
    }

    public LocalDateTime getAbholdatum() {
        return abholdatum;
    }

    public void setAbholdatum(LocalDateTime abholdatum) {
        this.abholdatum = abholdatum;
    }
}
