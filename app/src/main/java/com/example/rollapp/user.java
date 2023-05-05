package com.example.rollapp;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "uzytkownik")
public class user {
    public user(){
    }

    @DatabaseField(generatedId = true,columnName = "Id_uzytkownika")
    private int id;

    @DatabaseField(columnName = "Imie")
    private String imie;

    @DatabaseField(columnName = "Nazwisko")
    private String nazwisko;

    @DatabaseField(columnName = "Nick")
    private String nick;

    @DatabaseField(columnName = "Haslo", dataType = DataType.LONG_STRING)
    private String haslo;

    @DatabaseField(columnName = "E_mail")
    private String email;

    @DatabaseField(foreign = true, columnName = "Id_mg")
    private mg id_mg;

    public void setImie(String imie){
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko){
        this.nazwisko = nazwisko;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
