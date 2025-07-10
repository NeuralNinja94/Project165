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

    @NotBlank(message = "Bezeichnung darf nicht leer sein")
    private String bezeichnung;

    @NotBlank(message = "Schueler-ID darf nicht leer sein")
    private String schuelerId;

    @NotNull(message = "Abholdatum darf nicht null sein")
    private LocalDateTime abgeholtAt;

    public Abholung() {}

    public Abholung(String bezeichnung, String schuelerId, LocalDateTime abgeholtAt) {
        this.bezeichnung = bezeichnung;
        this.schuelerId = schuelerId;
        this.abgeholtAt = abgeholtAt;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getBezeichnung() { return bezeichnung; }
    public void setBezeichnung(String bezeichnung) { this.bezeichnung = bezeichnung; }

    public String getSchuelerId() { return schuelerId; }
    public void setSchuelerId(String schuelerId) { this.schuelerId = schuelerId; }

    public LocalDateTime getAbgeholtAt() { return abgeholtAt; }
    public void setAbgeholtAt(LocalDateTime abgeholtAt) { this.abgeholtAt = abgeholtAt; }
}
