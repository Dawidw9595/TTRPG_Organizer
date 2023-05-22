package com.example.rollapp.model;

public class wiedzmin_pancerz {

    private int id;
    private int id_karta;
    private int id_pancerza;
    private int id_uszkodzeniapancerza;

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

    public int getId_pancerza() {
        return id_pancerza;
    }

    public void setId_pancerza(int id_pancerza) {
        this.id_pancerza = id_pancerza;
    }

    public int getId_uszkodzeniapancerza() {
        return id_uszkodzeniapancerza;
    }

    public void setId_uszkodzeniapancerza(int id_uszkodzeniapancerza) {
        this.id_uszkodzeniapancerza = id_uszkodzeniapancerza;
    }

    @Override
    public String toString() {
        return "wiedzmin_pancerz{" +
                "id=" + id +
                ", id_karta=" + id_karta +
                ", id_pancerza=" + id_pancerza +
                ", id_uszkodzeniapancerza=" + id_uszkodzeniapancerza +
                '}';
    }
}
