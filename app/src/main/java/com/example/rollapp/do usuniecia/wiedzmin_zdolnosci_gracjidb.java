package com.example.rollapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class wiedzmin_zdolnosci_gracjidb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 16;

    private static final String TABLE_NAME = "statystyki_fachu";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ATLETYKA = "atletyka";
    private static final String COLUMN_KUSZNICTWO = "kusznictwo";
    private static final String COLUMN_LUCZNICTWO = "lucznictwo";
    private static final String COLUMN_SKRYTOSC = "skrytosc";
    private static final String COLUMN_ZRECZNE_PALCE = "zreczne_palce";

    public wiedzmin_zdolnosci_gracjidb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    public wiedzmin_zdolnosci_gracjidb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ATLETYKA + " INTEGER, " +
                COLUMN_KUSZNICTWO + " INTEGER, " +
                COLUMN_LUCZNICTWO + " INTEGER, " +
                COLUMN_SKRYTOSC + " INTEGER, " +
                COLUMN_ZRECZNE_PALCE + " INTEGER " + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
