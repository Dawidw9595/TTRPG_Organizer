package com.example.rollapp.model;

public class charakter {

    private int id;
    private int koniec;
    private int id_karty;
    private String osobowosc;
    private String najwazniejsza_osoba;
    private String najbardziej_ceni;
    private String o_innych;
    private String pochodzenie;

    public String getOsobowosc() {
        return osobowosc;
    }

    public void setOsobowosc(String osobowosc) {
        this.osobowosc = osobowosc;
    }
    public String getNajwazniejsza_osoba() {
        return najwazniejsza_osoba;
    }

    public void setNajwazniejsza_osoba(String najwazniejsza_osoba) {
        this.najwazniejsza_osoba = najwazniejsza_osoba;
    }
    public String getNajbardziej_ceni() {
        return najbardziej_ceni;
    }

    public void setNajbardziej_ceni(String najbardziej_ceni) {
        this.najbardziej_ceni = najbardziej_ceni;
    }
    public String getO_innych() {
        return o_innych;
    }

    public void setO_innych(String o_innych) {
        this.o_innych = o_innych;
    }
    public String getPochodzenie() {
        return pochodzenie;
    }

    public int getId_karty() {return id_karty;}

    public void setId_karty(int id_karty) {
        this.id_karty = id_karty;
    }
    public void setPochodzenie(String pochodzenie) {
        this.pochodzenie = pochodzenie;
    }
    public int getKoniec() {
        return koniec;
    }

    public void setKoniec(int koniec) {
        this.koniec = koniec;
    }

    @Override
    public String toString(){
        return "charakter{" +
                "id=" + id +
                ", id_karty=" + id_karty +
                ", osobowosc=" + osobowosc + '\'' +
                ", najwazniesza_osoba=" + najwazniejsza_osoba + '\'' +
                ", najbardziej_ceni=" + najbardziej_ceni + '\'' +
                ", o_innych=" + o_innych + '\'' +
                ", pochodzenie=" + pochodzenie + '\'' +
                ", koniec=" + koniec +
                '}';
    }
}
