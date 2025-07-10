package com.fundgrube.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Repräsentiert eine Abholung eines Fundstücks durch einen Schüler.
 */
@Document(collection = "AbgeholteArtikel")
public class Abholung {

    /**
     * Die eindeutige ID der Abholung.
     */
    @Id
    private String id;

    /**
     * Die Bezeichnung des abgeholten Artikels. Darf nicht leer sein.
     */
    @NotBlank(message = "Bezeichnung darf nicht leer sein")
    private String bezeichnung;

    /**
     * Die ID des Schülers, der den Artikel abgeholt hat. Darf nicht leer sein.
     */
    @NotBlank(message = "Schueler-ID darf nicht leer sein")
    private String schuelerId;

    /**
     * Das Datum und die Uhrzeit der Abholung. Darf nicht null sein.
     */
    @NotNull(message = "Abholdatum darf nicht null sein")
    private LocalDateTime abgeholtAt;

    /**
     * Standardkonstruktor.
     */
    public Abholung() {}

    /**
     * Konstruktor zum Erstellen einer Abholung.
     * @param bezeichnung Die Bezeichnung des Artikels
     * @param schuelerId Die ID des Schülers
     * @param abgeholtAt Das Abholdatum und die Uhrzeit
     */
    public Abholung(String bezeichnung, String schuelerId, LocalDateTime abgeholtAt) {
        this.bezeichnung = bezeichnung;
        this.schuelerId = schuelerId;
        this.abgeholtAt = abgeholtAt;
    }

    /**
     * Gibt die ID der Abholung zurück.
     * @return Die Abholungs-ID
     */
    public String getId() { return id; }
    /**
     * Setzt die ID der Abholung.
     * @param id Die neue Abholungs-ID
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
     * Gibt die Schüler-ID zurück.
     * @return Die Schüler-ID
     */
    public String getSchuelerId() { return schuelerId; }
    /**
     * Setzt die Schüler-ID.
     * @param schuelerId Die neue Schüler-ID
     */
    public void setSchuelerId(String schuelerId) { this.schuelerId = schuelerId; }

    /**
     * Gibt das Abholdatum und die Uhrzeit zurück.
     * @return Das Abholdatum und die Uhrzeit
     */
    public LocalDateTime getAbgeholtAt() { return abgeholtAt; }
    /**
     * Setzt das Abholdatum und die Uhrzeit.
     * @param abgeholtAt Das neue Abholdatum und die Uhrzeit
     */
    public void setAbgeholtAt(LocalDateTime abgeholtAt) { this.abgeholtAt = abgeholtAt; }
}
