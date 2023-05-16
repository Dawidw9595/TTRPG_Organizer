package com.example.rollapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class wiedzmin_zdolnosc_fachudb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 8;

    private static final String TABLE_NAME = "statystyki_fachu";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ALCHEMIA = "alchemia";
    private static final String COLUMN_CHARAKTERYZACJA = "charakteryzacja";
    private static final String COLUMN_FALSZERSTWO = "falszerstwo";
    private static final String COLUMN_OPATRYWANIE = "opatrywanie";
    private static final String COLUMN_PULAPKI = "pulapki";
    private static final String COLUMN_RZEMIOSLO = "rzemioslo";
    private static final String COLUMN_WLAMANIA = "wlamania";

    public wiedzmin_zdolnosc_fachudb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    public wiedzmin_zdolnosc_fachudb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ALCHEMIA + " INTEGER, " +
                COLUMN_CHARAKTERYZACJA + " INTEGER, " +
                COLUMN_FALSZERSTWO + " INTEGER, " +
                COLUMN_OPATRYWANIE + " INTEGER, " +
                COLUMN_PULAPKI + " INTEGER, " +
                COLUMN_RZEMIOSLO + " INTEGER, " +
                COLUMN_WLAMANIA + " INTEGER " + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
