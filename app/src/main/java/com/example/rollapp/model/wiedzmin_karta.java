package com.example.rollapp.model;

public class wiedzmin_karta {

    private int id;


    private int id_postaci;


    private int id_cechy;


    private int id_rozum;

    private int id_reakcji;


    private int id_gracji;


    private int id_ciala;


    private int id_emocji;


    private int id_fachu;

    private int id_woli;

    private String zdolnosc_charakterystyczna;

    private String zdolnosc_profesji;

    private int pieniadze;

    private String ekwipunek;

    private int wigor;

    private String ubranie;

    private String osobowosc;

    private String wlosy;

    private String ozdoby;

    private String nawazniejsza_osoba;

    private String najbardziej_ceni;

    private String o_innych;

    private String pochodzenie;
    private String wydarzenia;

    public wiedzmin_karta() {
    }

    public int getId_postaci() {
        return id_postaci;
    }

    public void setId_postaci(int id_postaci) {
        this.id_postaci = id_postaci;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cechy() {
        return id_cechy;
    }

    public void setId_cechy(int id_cechy) {
        this.id_cechy = id_cechy;
    }

    public int getId_rozum() {
        return id_rozum;
    }

    public void setId_rozum(int id_rozum) {
        this.id_rozum = id_rozum;
    }

    public int getId_reakcji() {
        return id_reakcji;
    }

    public void setId_reakcji(int id_reakcji) {
        this.id_reakcji = id_reakcji;
    }

    public int getId_gracji() {
        return id_gracji;
    }

    public void setId_gracji(int id_gracji) {
        this.id_gracji = id_gracji;
    }

    public int getId_ciala() {
        return id_ciala;
    }

    public void setId_ciala(int id_ciala) {
        this.id_ciala = id_ciala;
    }

    public int getId_emocji() {
        return id_emocji;
    }

    public void setId_emocji(int id_emocji) {
        this.id_emocji = id_emocji;
    }

    public int getId_fachu() {
        return id_fachu;
    }

    public void setId_fachu(int id_fachu) {
        this.id_fachu = id_fachu;
    }

    public int getId_woli() {
        return id_woli;
    }

    public void setId_woli(int id_woli) {
        this.id_woli = id_woli;
    }

    public String getZdolnosc_charakterystyczna() {
        return zdolnosc_charakterystyczna;
    }

    public void setZdolnosc_charakterystyczna(String zdolnosc_charakterystyczna) {
        this.zdolnosc_charakterystyczna = zdolnosc_charakterystyczna;
    }

    public String getZdolnosc_profesji() {
        return zdolnosc_profesji;
    }

    public void setZdolnosc_profesji(String zdolnosc_profesji) {
        this.zdolnosc_profesji = zdolnosc_profesji;
    }

    public int getPieniadze() {
        return pieniadze;
    }

    public void setPieniadze(int pieniadze) {
        this.pieniadze = pieniadze;
    }

    public String getEkwipunek() {
        return ekwipunek;
    }

    public void setEkwipunek(String ekwipunek) {
        this.ekwipunek = ekwipunek;
    }

    public int getWigor() {
        return wigor;
    }

    public void setWigor(int wigor) {
        this.wigor = wigor;
    }

    public String getUbranie() {
        return ubranie;
    }

    public void setUbranie(String ubranie) {
        this.ubranie = ubranie;
    }

    public String getOsobowosc() {
        return osobowosc;
    }

    public void setOsobowosc(String osobowosc) {
        this.osobowosc = osobowosc;
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

    public String getNawazniejsza_osoba() {
        return nawazniejsza_osoba;
    }

    public void setNawazniejsza_osoba(String nawazniejsza_osoba) {
        this.nawazniejsza_osoba = nawazniejsza_osoba;
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

    public void setPochodzenie(String pochodzenie) {
        this.pochodzenie = pochodzenie;
    }

    public String getWydarzenia() {
        return wydarzenia;
    }

    public void setWydarzenia(String wydarzenia) {
        this.wydarzenia = wydarzenia;
    }

    @Override
    public String toString() {
        return "wiedzmin_karta{" +
                "id=" + id +
                ", id_postaci=" + id_postaci +
                ", id_cechy=" + id_cechy +
                ", id_rozum=" + id_rozum +
                ", id_reakcji=" + id_reakcji +
                ", id_gracji=" + id_gracji +
                ", id_ciala=" + id_ciala +
                ", id_emocji=" + id_emocji +
                ", id_fachu=" + id_fachu +
                ", id_woli=" + id_woli +
                ", zdolnosc_charakterystyczna='" + zdolnosc_charakterystyczna + '\'' +
                ", zdolnosc_profesji='" + zdolnosc_profesji + '\'' +
                ", pieniadze=" + pieniadze +
                ", ekwipunek='" + ekwipunek + '\'' +
                ", wigor=" + wigor +
                ", ubranie='" + ubranie + '\'' +
                ", osobowosc='" + osobowosc + '\'' +
                ", wlosy='" + wlosy + '\'' +
                ", ozdoby='" + ozdoby + '\'' +
                ", nawazniejsza_osoba='" + nawazniejsza_osoba + '\'' +
                ", najbardziej_ceni='" + najbardziej_ceni + '\'' +
                ", o_innych='" + o_innych + '\'' +
                ", pochodzenie='" + pochodzenie + '\'' +
                ", wydarzenia='" + wydarzenia + '\'' +
                '}';
    }
}
