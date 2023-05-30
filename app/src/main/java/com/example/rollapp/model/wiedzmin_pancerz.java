package com.example.rollapp.model;

public class wiedzmin_pancerz {


    private int id;


    private int id_karta;

    private int glowa;


    private int korpus;

    private int p_reka;

    private int l_noga;

    private int l_reka;

    private int r_noga;


    private int id_uszkodzeniapancerza;


    private int koniec;

    public wiedzmin_pancerz() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_karta() {
        return id_karta;
    }

    public void setId_karta(int id_karta) {
        this.id_karta = id_karta;
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

    public int getR_noga() {
        return r_noga;
    }

    public void setR_noga(int r_noga) {
        this.r_noga = r_noga;
    }

    public int getId_uszkodzeniapancerza() {
        return id_uszkodzeniapancerza;
    }

    public void setId_uszkodzeniapancerza(int id_uszkodzeniapancerza) {
        this.id_uszkodzeniapancerza = id_uszkodzeniapancerza;
    }

    public int getKoniec() {
        return koniec;
    }

    public void setKoniec(int koniec) {
        this.koniec = koniec;
    }

    @Override
    public String toString() {
        return "wiedzmin_pancerz{" +
                "id=" + id +
                ", id_karta=" + id_karta +
                ", glowa=" + glowa +
                ", korpus=" + korpus +
                ", p_reka=" + p_reka +
                ", l_noga=" + l_noga +
                ", l_reka=" + l_reka +
                ", r_noga=" + r_noga +
                ", id_uszkodzeniapancerza=" + id_uszkodzeniapancerza +
                ", koniec=" + koniec +
                '}';
    }
}
