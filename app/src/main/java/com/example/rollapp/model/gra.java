package com.example.rollapp.model;

public class gra {
    private int id;

    private String nazwa ;

    public gra() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "gra{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
