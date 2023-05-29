package com.example.rollapp.model;

public class wiedzmin_zdolnosci_woli {

    private int id;

    private int id_karta;

    private int klatwy;

    private int lamanie_magii;

    private int nieugietosc;

    private int odwaga;

    private int rytualy;

    private int zaklecia;

    private int zastraszanie;


    private int koniec;



    public wiedzmin_zdolnosci_woli() {
    }

    public int getKoniec() {
        return koniec;
    }

    public void setKoniec(int koniec) {
        this.koniec = koniec;
    }

    public int getId_karta() {
        return id_karta;
    }

    public void setId_karta(int id_karta) {
        this.id_karta = id_karta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKlatwy() {
        return klatwy;
    }

    public void setKlatwy(int klatwy) {
        this.klatwy = klatwy;
    }

    public int getLamanie_magii() {
        return lamanie_magii;
    }

    public void setLamanie_magii(int lamanie_magii) {
        this.lamanie_magii = lamanie_magii;
    }

    public int getNieugietosc() {
        return nieugietosc;
    }

    public void setNieugietosc(int nieugietosc) {
        this.nieugietosc = nieugietosc;
    }

    public int getOdwaga() {
        return odwaga;
    }

    public void setOdwaga(int odwaga) {
        this.odwaga = odwaga;
    }

    public int getRytualy() {
        return rytualy;
    }

    public void setRytualy(int rytualy) {
        this.rytualy = rytualy;
    }

    public int getZaklecia() {
        return zaklecia;
    }

    public void setZaklecia(int zaklecia) {
        this.zaklecia = zaklecia;
    }

    public int getZastraszanie() {
        return zastraszanie;
    }

    public void setZastraszanie(int zastraszanie) {
        this.zastraszanie = zastraszanie;
    }

    @Override
    public String toString() {
        return "wiedzmin_zdolnosci_woli{" +
                "id=" + id +
                ", id_karta=" + id_karta +
                ", klatwy=" + klatwy +
                ", lamanie_magii=" + lamanie_magii +
                ", nieugietosc=" + nieugietosc +
                ", odwaga=" + odwaga +
                ", rytualy=" + rytualy +
                ", zaklecia=" + zaklecia +
                ", zastraszanie=" + zastraszanie +
                ", koniec=" + koniec +
                '}';
    }
}
