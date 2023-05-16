package com.example.rollapp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "gra")
public class gra {
    public gra(){

    }

    @DatabaseField(generatedId = true, columnName = "id_gry")
    private int id;

    private String nazwa;
}
