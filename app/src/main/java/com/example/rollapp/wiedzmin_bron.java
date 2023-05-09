package com.example.rollapp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "wiedzmin_bron")
public class wiedzmin_bron {
    public wiedzmin_bron(){

    }

    @DatabaseField(generatedId = true)
    private int id;

    private int id_karty;

    private int id_statystyki_broni;
}
