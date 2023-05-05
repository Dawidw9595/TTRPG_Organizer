package com.example.rollapp;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "mg")
public class mg {
    public mg(){
    }

    @DatabaseField(generatedId = true,columnName = "Id_mg")
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

    @ForeignCollectionField
    private ForeignCollection<user> uzytkownicy;

}
