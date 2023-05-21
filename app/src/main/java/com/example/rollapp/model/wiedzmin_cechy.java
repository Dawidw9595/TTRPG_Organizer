package com.example.rollapp.model;

public class wiedzmin_cechy {

    private int id;

    private int cialo;

    private int fach;

    private int gracja;

    private int reakcja;

    private int rozum;

    private int tempo;

    private int wola;

    private int fart;

    private int id_karty;

    public wiedzmin_cechy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCialo() {
        return cialo;
    }

    public void setCialo(int cialo) {
        this.cialo = cialo;
    }

    public int getFach() {
        return fach;
    }

    public void setFach(int fach) {
        this.fach = fach;
    }

    public int getGracja() {
        return gracja;
    }

    public void setGracja(int gracja) {
        this.gracja = gracja;
    }

    public int getReakcja() {
        return reakcja;
    }

    public void setReakcja(int reakcja) {
        this.reakcja = reakcja;
    }

    public int getRozum() {
        return rozum;
    }

    public void setRozum(int rozum) {
        this.rozum = rozum;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getWola() {
        return wola;
    }

    public void setWola(int wola) {
        this.wola = wola;
    }

    public int getFart() {
        return fart;
    }

    public void setFart(int fart) {
        this.fart = fart;
    }

    public int getId_karty() {
        return id_karty;
    }

    public void setId_karty(int id_karty) {
        this.id_karty = id_karty;
    }

    @Override
    public String toString() {
        return "wiedzmin_cechy{" +
                "id=" + id +
                ", cialo=" + cialo +
                ", fach=" + fach +
                ", gracja=" + gracja +
                ", reakcja=" + reakcja +
                ", rozum=" + rozum +
                ", tempo=" + tempo +
                ", wola=" + wola +
                ", fart=" + fart +
                ", id_karty=" + id_karty +
                '}';
    }
}
