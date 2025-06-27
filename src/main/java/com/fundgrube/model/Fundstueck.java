package com.fundgrube.model;

public class Fundstueck {
    private String id;
    private String name;
    private String beschreibung;
    private String fundort;
    private String datum;
    private String status; //offen oder abgeholt


    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBeschreibung() { return beschreibung; }
    public void setBeschreibung(String beschreibung) { this.beschreibung = beschreibung; }

    public String getFundort() { return fundort; }
    public void setFundort(String fundort) { this.fundort = fundort; }

    public String getDatum() { return datum; }
    public void setDatum(String datum) { this.datum = datum; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}


