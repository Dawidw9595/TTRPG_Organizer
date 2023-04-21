package com.example.rollapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class wiedzmin_cehcydb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 19;

    private static final String TABLE_NAME = "cechy";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CIALO = "cialo";
    private static final String COLUMN_FACH = "fach";
    private static final String COLUMN_GRACJA = "gracja";
    private static final String COLUMN_REAKCJA = "reakcja";
    private static final String COLUMN_ROZUM = "rozum";
    private static final String COLUMN_TEMPO = "tempo";
    private static final String COLUMN_WOLA = "wola";
    private static final String COLUMN_FART = "fart";

    public wiedzmin_cehcydb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    public wiedzmin_cehcydb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CIALO + " INTEGER, " +
                COLUMN_FACH + " INTEGER, " +
                COLUMN_GRACJA + " INTEGER, " +
                COLUMN_REAKCJA + " INTEGER, " +
                COLUMN_ROZUM + " INTEGER, " +
                COLUMN_TEMPO + " INTEGER, " +
                COLUMN_WOLA + " INTEGER, " +
                COLUMN_FART + " INTEGER " + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
