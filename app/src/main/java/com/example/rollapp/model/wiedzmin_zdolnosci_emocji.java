package com.example.rollapp.model;

public class wiedzmin_zdolnosci_emocji {

    private int id;


    private int id_karta;

    private int amory;

    private int empatia;

    private int hazard;

    private int oszustwo;

    private int perswazja;

    private int przywodztwo;

    private int styl;

    private int sztuka;

    private int urok;

    private int wystepy;

    public wiedzmin_zdolnosci_emocji() {
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

    public int getAmory() {
        return amory;
    }

    public void setAmory(int amory) {
        this.amory = amory;
    }

    public int getEmpatia() {
        return empatia;
    }

    public void setEmpatia(int empatia) {
        this.empatia = empatia;
    }

    public int getHazard() {
        return hazard;
    }

    public void setHazard(int hazard) {
        this.hazard = hazard;
    }

    public int getOszustwo() {
        return oszustwo;
    }

    public void setOszustwo(int oszustwo) {
        this.oszustwo = oszustwo;
    }

    public int getPerswazja() {
        return perswazja;
    }

    public void setPerswazja(int perswazja) {
        this.perswazja = perswazja;
    }

    public int getPrzywodztwo() {
        return przywodztwo;
    }

    public void setPrzywodztwo(int przywodztwo) {
        this.przywodztwo = przywodztwo;
    }

    public int getStyl() {
        return styl;
    }

    public void setStyl(int styl) {
        this.styl = styl;
    }

    public int getSztuka() {
        return sztuka;
    }

    public void setSztuka(int sztuka) {
        this.sztuka = sztuka;
    }

    public int getUrok() {
        return urok;
    }

    public void setUrok(int urok) {
        this.urok = urok;
    }

    public int getWystepy() {
        return wystepy;
    }

    public void setWystepy(int wystepy) {
        this.wystepy = wystepy;
    }

    @Override
    public String toString() {
        return "wiedzmin_zdolnosci_emocji{" +
                "id=" + id +
                ", id_karta=" + id_karta +
                ", amory=" + amory +
                ", empatia=" + empatia +
                ", hazard=" + hazard +
                ", oszustwo=" + oszustwo +
                ", perswazja=" + perswazja +
                ", przywodztwo=" + przywodztwo +
                ", styl=" + styl +
                ", sztuka=" + sztuka +
                ", urok=" + urok +
                ", wystepy=" + wystepy +
                '}';
    }
}
