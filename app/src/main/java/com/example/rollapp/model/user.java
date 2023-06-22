package com.example.rollapp.model;

import java.util.List;

public class user {


    private int id;

    private String imie;

    private String nazwisko;

    private String nick;


    private String haslo;


    private int id_mg;

    private String email;

    public user() {

    }

    private List<postac> listaPostaci;

    public List<postac> getListaPostaci() {
        return listaPostaci;
    }

    public void setListaPostaci(List<postac> listaPostaci) {
        this.listaPostaci = listaPostaci;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public int getId_mg() {
        return id_mg;
    }

    public void setId_mg(int id_mg) {
        this.id_mg = id_mg;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nick='" + nick + '\'' +
                ", haslo='" + haslo + '\'' +
                ", id_mg=" + id_mg +
                '}';
    }

}
