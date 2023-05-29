package com.example.rollapp.model;

public class wiedzmin_uszkodzenia_pancerz {

    private int id;

    private int id_pancerz;

    private int glowa;

    private int korpus;

    private int p_reka;

    private int l_noga;

    private int l_reka;

    private int p_noga;

    private int koniec;


    public wiedzmin_uszkodzenia_pancerz() {
    }

    public int getId_pancerz() {
        return id_pancerz;
    }

    public void setId_pancerz(int id_pancerz) {
        this.id_pancerz = id_pancerz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGlowa() {
        return glowa;
    }

    public void setGlowa(int glowa) {
        this.glowa = glowa;
    }

    public int getKorpus() {
        return korpus;
    }

    public void setKorpus(int korpus) {
        this.korpus = korpus;
    }

    public int getP_reka() {
        return p_reka;
    }

    public void setP_reka(int p_reka) {
        this.p_reka = p_reka;
    }

    public int getL_noga() {
        return l_noga;
    }

    public void setL_noga(int l_noga) {
        this.l_noga = l_noga;
    }

    public int getL_reka() {
        return l_reka;
    }

    public void setL_reka(int l_reka) {
        this.l_reka = l_reka;
    }

    public int getP_noga() {
        return p_noga;
    }

    public void setP_noga(int p_noga) {
        this.p_noga = p_noga;
    }

    @Override
    public String toString() {
        return "wiedzmin_uszkodzenia_pancerz{" +
                "id=" + id +
                ", id_pancerz=" + id_pancerz +
                ", glowa=" + glowa +
                ", korpus=" + korpus +
                ", p_reka=" + p_reka +
                ", l_noga=" + l_noga +
                ", l_reka=" + l_reka +
                ", p_noga=" + p_noga +
                '}';
    }
}
