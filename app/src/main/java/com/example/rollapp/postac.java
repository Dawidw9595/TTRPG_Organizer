package com.example.rollapp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "postac")
public class postac {
    public postac(){

    }

    @DatabaseField(generatedId = true,columnName = "id_postaci")
    private int id;

    private String nazwa_postaci;

    private int id_user;

    private int id_gry;

    private int id_karty;
}
