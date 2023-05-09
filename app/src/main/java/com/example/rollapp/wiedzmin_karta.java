package com.example.rollapp;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "wiedzmin_karta")
public class wiedzmin_karta {
    public wiedzmin_karta(){

    }

    @DatabaseField(generatedId = true)
    private int id;

    private String nazwa_postaci;

    private String rasa;

    private String plec;

    private int wiek;

    private String profesja;


    private int id_cechy;


    private int id_zdolnosci;


    private int id_reakcji;


    private int id_gracji;


    private int id_ciala;


    private int id_emocji;


    private int id_fachu;

    private int id_woli;

    private String zdolnosc_charakterystyczna;

    private String zdolnosc_profesji;

    private int pieniadze;

    @DatabaseField(dataType = DataType.LONG_STRING)
    private String ekwipunek;

    private int wigor;

    private String ubranie;

    private String osobowosc;

    private String wlosy;

    private String ozdoby;

    private String nawazniejsza_osoba;

    private String najbardziej_ceni;

    private String o_innych;

    private String pochodzenie;

    @DatabaseField(dataType = DataType.LONG_STRING)
    private String wydarzenia;

}
