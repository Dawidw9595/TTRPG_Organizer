package com.example.rollapp.model;

public class wiedzmin_zdolnosci_gracji {

    private int id;

    private int id_karta;

    private int atletyka;

    private int kusznictwo;

    private int lucznictwo;

    private int skrytosc;

    private int zreczne_palce;

    public wiedzmin_zdolnosci_gracji() {
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

    public int getAtletyka() {
        return atletyka;
    }

    public void setAtletyka(int atletyka) {
        this.atletyka = atletyka;
    }

    public int getKusznictwo() {
        return kusznictwo;
    }

    public void setKusznictwo(int kusznictwo) {
        this.kusznictwo = kusznictwo;
    }

    public int getLucznictwo() {
        return lucznictwo;
    }

    public void setLucznictwo(int lucznictwo) {
        this.lucznictwo = lucznictwo;
    }

    public int getSkrytosc() {
        return skrytosc;
    }

    public void setSkrytosc(int skrytosc) {
        this.skrytosc = skrytosc;
    }

    public int getZreczne_palce() {
        return zreczne_palce;
    }

    public void setZreczne_palce(int zreczne_palce) {
        this.zreczne_palce = zreczne_palce;
    }

    @Override
    public String toString() {
        return "wiedzmin_zdolnosci_gracji{" +
                "id=" + id +
                ", id_karta=" + id_karta +
                ", atletyka=" + atletyka +
                ", kusznictwo=" + kusznictwo +
                ", lucznictwo=" + lucznictwo +
                ", skrytosc=" + skrytosc +
                ", zreczne_palce=" + zreczne_palce +
                '}';
    }
}
