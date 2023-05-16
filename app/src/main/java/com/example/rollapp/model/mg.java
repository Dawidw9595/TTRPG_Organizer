package com.example.rollapp.model;

public class mg {

    private int id;

    private String imie;

    private String nazwisko;

    private String nick;

    private String haslo;

    private String email;

    public mg() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String e_mail) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "mg{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nick='" + nick + '\'' +
                ", haslo='" + haslo + '\'' +
                ", e_mail='" + email + '\'' +
                '}';
    }

}
