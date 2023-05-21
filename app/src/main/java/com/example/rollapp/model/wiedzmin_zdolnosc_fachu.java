package com.example.rollapp.model;

public class wiedzmin_zdolnosc_fachu {
    private int id;

    private int id_karta;

    private int alchemia;

    private int charakteryzacja;

    private int falszerstwo;

    private int opatrywanie;

    private int pulapki;

    private int rzemioslo;

    private int wlamania;

    public wiedzmin_zdolnosc_fachu() {
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

    public int getAlchemia() {
        return alchemia;
    }

    public void setAlchemia(int alchemia) {
        this.alchemia = alchemia;
    }

    public int getCharakteryzacja() {
        return charakteryzacja;
    }

    public void setCharakteryzacja(int charakteryzacja) {
        this.charakteryzacja = charakteryzacja;
    }

    public int getFalszerstwo() {
        return falszerstwo;
    }

    public void setFalszerstwo(int falszerstwo) {
        this.falszerstwo = falszerstwo;
    }

    public int getOpatrywanie() {
        return opatrywanie;
    }

    public void setOpatrywanie(int opatrywanie) {
        this.opatrywanie = opatrywanie;
    }

    public int getPulapki() {
        return pulapki;
    }

    public void setPulapki(int pulapki) {
        this.pulapki = pulapki;
    }

    public int getRzemioslo() {
        return rzemioslo;
    }

    public void setRzemioslo(int rzemioslo) {
        this.rzemioslo = rzemioslo;
    }

    public int getWlamania() {
        return wlamania;
    }

    public void setWlamania(int wlamania) {
        this.wlamania = wlamania;
    }

    @Override
    public String toString() {
        return "wiedzmin_zdolnosc_fachu{" +
                "id=" + id +
                ", id_karta=" + id_karta +
                ", alchemia=" + alchemia +
                ", charakteryzacja=" + charakteryzacja +
                ", falszerstwo=" + falszerstwo +
                ", opatrywanie=" + opatrywanie +
                ", pulapki=" + pulapki +
                ", rzemioslo=" + rzemioslo +
                ", wlamania=" + wlamania +
                '}';
    }
}
