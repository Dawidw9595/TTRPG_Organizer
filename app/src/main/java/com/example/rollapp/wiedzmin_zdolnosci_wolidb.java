package com.example.rollapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class wiedzmin_zdolnosci_wolidb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 7;

    private static final String TABLE_NAME = "statystyki_woli";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_KLATWY = "klatwy";
    private static final String COLUMN_LMAIGI = "lamanie_magii";
    private static final String COLUMN_NIEUGIETOSC = "nieugietosc";
    private static final String COLUMN_ODWAGA = "odwaga";
    private static final String COLUMN_RYTUALY = "rytualy";
    private static final String COLUMN_ZAKLECIA = "zaklecia";
    private static final String COLUMN_ZASTRASZANIE = "zastraszanie";

    public wiedzmin_zdolnosci_wolidb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    public wiedzmin_zdolnosci_wolidb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_KLATWY + " INTEGER, " +
                COLUMN_LMAIGI + " INTEGER, " +
                COLUMN_NIEUGIETOSC + " INTEGER, " +
                COLUMN_ODWAGA + " INTEGER, " +
                COLUMN_RYTUALY + " INTEGER, " +
                COLUMN_ZAKLECIA + " INTEGER, " +
                COLUMN_ZASTRASZANIE + " INTEGER " + ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
