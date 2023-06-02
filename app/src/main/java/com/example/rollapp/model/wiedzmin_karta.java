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


    private int id_wydarzenia;


    private int id_charakter;


    private int id_wyglad;


    private int id_broni;


    private int id_pancerza;

    private String zdolnosc_charakterystyczna;

    private String zdolnosc_profesji;

    private int pieniadze;

    private String ekwipunek;

    private int wigor;

    private int koniec;

    public wiedzmin_karta() {
    }

    public int getKoniec() {
        return koniec;
    }

    public void setKoniec(int koniec) {
        this.koniec = koniec;
    }

    public int getId_broni() {
        return id_broni;
    }

    public void setId_broni(int id_broni) {
        this.id_broni = id_broni;
    }

    public int getId_pancerza() {
        return id_pancerza;
    }

    public void setId_pancerza(int id_pancerza) {
        this.id_pancerza = id_pancerza;
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

    public int getId_wydarzenia(){return id_wydarzenia;}
    public void setId_wydarzenia(int id_wydarzenia){this.id_wydarzenia = id_wydarzenia;}
    public int getId_charakter(){return id_charakter;}
    public void setId_charakter(int id_charakter){this.id_charakter = id_charakter;}

    public int getId_wyglad(){return id_wyglad;}
    public void setId_wyglad(int id_wyglad){this.id_wyglad = id_wyglad;}

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
                ", id_broni=" + id_broni +
                ", id_pancerza=" + id_pancerza +
                ", id_wydarzenia=" + id_wydarzenia +
                ", id_charakter=" + id_charakter +
                ", id_wyglad=" + id_wyglad +
                ", zdolnosc_charakterystyczna='" + zdolnosc_charakterystyczna + '\'' +
                ", zdolnosc_profesji='" + zdolnosc_profesji + '\'' +
                ", pieniadze=" + pieniadze +
                ", ekwipunek='" + ekwipunek + '\'' +
                ", wigor=" + wigor +
                ", koniec=" + koniec +
                '}';
    }
}
