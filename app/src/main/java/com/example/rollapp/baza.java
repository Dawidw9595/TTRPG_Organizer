package com.example.rollapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class baza extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "uzytkownik";
    private static final String COLUMN_ID = "_id";

    private static final String COLUMN_NAME = "imie";

    private static final String COLUMN_SURNAME = "nazwisko";
    private static final String COLUMN_USER = "nazwa_uzytkownika";
    private static final String COLUMN_PASSWORD = "haslo";
    private static final String COLUMN_E_MAIL = "email";



    public baza(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query= "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTIGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_SURNAME + " TEXT, " +
                        COLUMN_USER + " TEXT, " +
                        COLUMN_PASSWORD + " TEXT, " +
                        COLUMN_E_MAIL + " TEXT );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
