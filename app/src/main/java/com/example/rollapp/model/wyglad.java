package com.example.rollapp.model;

public class wyglad {

    private int id;
    private int id_karty;
    private int koniec;
    private String ubranie;
    private String wlosy;
    private String ozdoby;

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

    public String getUbranie() {
        return ubranie;
    }

    public void setUbranie(String ubranie) {
        this.ubranie = ubranie;
    }


    public String getWlosy() {
        return wlosy;
    }

    public void setWlosy(String wlosy) {
        this.wlosy = wlosy;
    }

    public String getOzdoby() {
        return ozdoby;
    }

    public void setOzdoby(String ozdoby) {
        this.ozdoby = ozdoby;
    }

    public int getKoniec() {
        return koniec;
    }

    public void setKoniec(int koniec) {
        this.koniec = koniec;
    }

    @Override
    public String toString() {
        return "wiedzmin_karta{" +
                "id=" + id +
                ", id_postaci=" + id_karty +
                ", ubranie='" + ubranie + '\'' +
                ", wlosy='" + wlosy + '\'' +
                ", ozdoby='" + ozdoby + '\'' +
                ", koniec=" + koniec +
                '}';
    }

}
