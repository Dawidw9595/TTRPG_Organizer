package com.example.rollapp.model;
import com.example.rollapp.model.postac;

import java.util.List;

public class postac {

    private int id;

    private String nazwa_postaci;

    private int id_user;

    private int id_gry;

    private int id_karty;

    private String rasa;

    private String plec;

    private int wiek;

    private int koniec;

    public postac() {
    }

    public int getKoniec() {
        return koniec;
    }

    public void setKoniec(int koniec) {
        this.koniec = koniec;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa_postaci() {
        return nazwa_postaci;
    }

    public void setNazwa_postaci(String nazwa_postaci) {
        this.nazwa_postaci = nazwa_postaci;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_gry() {
        return id_gry;
    }

    public void setId_gry(int id_gry) {
        this.id_gry = id_gry;
    }

    public int getId_karty() {
        return id_karty;
    }

    public void setId_karty(int id_karty) {
        this.id_karty = id_karty;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "postac{" +
                "id=" + id +
                ", nazwa_postaci='" + nazwa_postaci + '\'' +
                ", id_user=" + id_user +
                ", id_gry=" + id_gry +
                ", id_karty=" + id_karty +
                ", rasa='" + rasa + '\'' +
                ", plec='" + plec + '\'' +
                ", wiek=" + wiek +
                ", koniec=" + koniec +
                '}';
    }

}
