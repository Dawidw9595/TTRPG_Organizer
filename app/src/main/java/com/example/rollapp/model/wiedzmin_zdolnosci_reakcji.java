package com.example.rollapp.model;

public class wiedzmin_zdolnosci_reakcji {

    private int id;

    private int id_karta;

    private int bojka;

    private int bron_bitewna;

    private int bron_drzewcowa;

    private int bron_krotka;

    private int jezdziectwo;

    private int szermierka;

    private int zwinnosc;

    private int zeglarstwo;

    public wiedzmin_zdolnosci_reakcji() {
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

    public int getBojka() {
        return bojka;
    }

    public void setBojka(int bojka) {
        this.bojka = bojka;
    }

    public int getBron_bitewna() {
        return bron_bitewna;
    }

    public void setBron_bitewna(int bron_bitewna) {
        this.bron_bitewna = bron_bitewna;
    }

    public int getBron_drzewcowa() {
        return bron_drzewcowa;
    }

    public void setBron_drzewcowa(int bron_drzewcowa) {
        this.bron_drzewcowa = bron_drzewcowa;
    }

    public int getBron_krotka() {
        return bron_krotka;
    }

    public void setBron_krotka(int bron_krotka) {
        this.bron_krotka = bron_krotka;
    }

    public int getJezdziectwo() {
        return jezdziectwo;
    }

    public void setJezdziectwo(int jezdziectwo) {
        this.jezdziectwo = jezdziectwo;
    }

    public int getSzermierka() {
        return szermierka;
    }

    public void setSzermierka(int szermierka) {
        this.szermierka = szermierka;
    }

    public int getZwinnosc() {
        return zwinnosc;
    }

    public void setZwinnosc(int zwinnosc) {
        this.zwinnosc = zwinnosc;
    }

    public int getZeglarstwo() {
        return zeglarstwo;
    }

    public void setZeglarstwo(int zeglarstwo) {
        this.zeglarstwo = zeglarstwo;
    }

    @Override
    public String toString() {
        return "wiedzmin_zdolnosci_reakcji{" +
                "id=" + id +
                ", id_karta=" + id_karta +
                ", bojka=" + bojka +
                ", bron_bitewna=" + bron_bitewna +
                ", bron_drzewcowa=" + bron_drzewcowa +
                ", bron_krotka=" + bron_krotka +
                ", jezdziectwo=" + jezdziectwo +
                ", szermierka=" + szermierka +
                ", zwinnosc=" + zwinnosc +
                ", zeglarstwo=" + zeglarstwo +
                '}';
    }
}
