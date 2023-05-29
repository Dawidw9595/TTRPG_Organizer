package com.example.rollapp.model;

public class wiedzmin_bron {

    private int id;

    private int id_karty;

    private int koniec;

    private String nazwa;

    private String celnosc;

    private String obrazenia;

    private int trwalosc;

    private int recznosc;

    private String zasieg;

    private String efekty;

    private String dyskrecja;

    private int wzmocnienia;

    public wiedzmin_bron() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_karty() {
        return id_karty;
    }

    public void setId_karty(int id_karty) {
        this.id_karty = id_karty;
    }

    public int getKoniec() {
        return koniec;
    }

    public void setKoniec(int koniec) {
        this.koniec = koniec;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getCelnosc() {
        return celnosc;
    }

    public void setCelnosc(String celnosc) {
        this.celnosc = celnosc;
    }

    public String getObrazenia() {
        return obrazenia;
    }

    public void setObrazenia(String obrazenia) {
        this.obrazenia = obrazenia;
    }

    public int getTrwalosc() {
        return trwalosc;
    }

    public void setTrwalosc(int trwalosc) {
        this.trwalosc = trwalosc;
    }

    public int getRecznosc() {
        return recznosc;
    }

    public void setRecznosc(int recznosc) {
        this.recznosc = recznosc;
    }

    public String getZasieg() {
        return zasieg;
    }

    public void setZasieg(String zasieg) {
        this.zasieg = zasieg;
    }

    public String getEfekty() {
        return efekty;
    }

    public void setEfekty(String efekty) {
        this.efekty = efekty;
    }

    public String getDyskrecja() {
        return dyskrecja;
    }

    public void setDyskrecja(String dyskrecja) {
        this.dyskrecja = dyskrecja;
    }

    public int getWzmocnienia() {
        return wzmocnienia;
    }

    public void setWzmocnienia(int wzmocnienia) {
        this.wzmocnienia = wzmocnienia;
    }

    @Override
    public String toString() {
        return "wiedzmin_bron{" +
                "id=" + id +
                ", id_karty=" + id_karty +
                ", koniec=" + koniec +
                ", nazwa='" + nazwa + '\'' +
                ", celnosc='" + celnosc + '\'' +
                ", obrazenia='" + obrazenia + '\'' +
                ", trwalosc=" + trwalosc +
                ", recznosc=" + recznosc +
                ", zasieg='" + zasieg + '\'' +
                ", efekty='" + efekty + '\'' +
                ", dyskrecja='" + dyskrecja + '\'' +
                ", wzmocnienia=" + wzmocnienia +
                '}';
    }
}
