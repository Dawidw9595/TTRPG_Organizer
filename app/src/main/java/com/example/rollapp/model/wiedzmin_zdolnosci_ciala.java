package com.example.rollapp.model;

public class wiedzmin_zdolnosci_ciala {

    private int id;


    private int id_karta;


    private int krzepa;

    private int wytrzymalosc;

    public wiedzmin_zdolnosci_ciala() {
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

    public int getKrzepa() {
        return krzepa;
    }

    public void setKrzepa(int krzepa) {
        this.krzepa = krzepa;
    }

    public int getWytrzymalosc() {
        return wytrzymalosc;
    }

    public void setWytrzymalosc(int wytrzymalosc) {
        this.wytrzymalosc = wytrzymalosc;
    }

    @Override
    public String toString() {
        return "wiedzmin_zdolnosci_ciala{" +
                "id=" + id +
                ", id_karta=" + id_karta +
                ", krzepa=" + krzepa +
                ", wytrzymalosc=" + wytrzymalosc +
                '}';
    }
}
