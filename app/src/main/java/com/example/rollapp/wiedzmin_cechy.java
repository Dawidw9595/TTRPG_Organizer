package com.example.rollapp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "wiedzmin_cechy")
public class wiedzmin_cechy {
    public wiedzmin_cechy(){

    }

    @DatabaseField(generatedId = true)
    private int id;

    private int cialo;

    private int fach;

    private int gracja;

    private int reakcja;

    private int rozum;

    private int tempo;

    private int wola;

    private int fart;
}
