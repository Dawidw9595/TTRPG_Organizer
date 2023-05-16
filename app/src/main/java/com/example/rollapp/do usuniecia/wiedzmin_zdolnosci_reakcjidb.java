package com.example.rollapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class wiedzmin_zdolnosci_reakcjidb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 17;

    private static final String TABLE_NAME = "statystyki_reakcji";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_BOJKA = "bojka";
    private static final String COLUMN_BRON_BITEWNA = "bron_bitewna";
    private static final String COLUMN_BRON_DRZEWCOWA = "bron_drzewcowa";
    private static final String COLUMN_BRON_KROTKA= "bron_krotka";
    private static final String COLUMN_JEZDZIECTWO = "jezdziectwo";
    private static final String COLUMN_SZERMIERKA = "szermierka";
    private static final String COLUMN_ZWINNOSC = "zwinnosc";
    private static final String COLUMN_ZEGLARSTWO = "zeglarstwo";


    public wiedzmin_zdolnosci_reakcjidb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    public wiedzmin_zdolnosci_reakcjidb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_BOJKA + " INTEGER, " +
                COLUMN_BRON_BITEWNA + " INTEGER, " +
                COLUMN_BRON_DRZEWCOWA + " INTEGER, " +
                COLUMN_BRON_KROTKA + " INTEGER, " +
                COLUMN_JEZDZIECTWO + " INTEGER, " +
                COLUMN_SZERMIERKA + " INTEGER, " +
                COLUMN_ZWINNOSC + " INTEGER, " +
                COLUMN_ZEGLARSTWO + " INTEGER " + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
