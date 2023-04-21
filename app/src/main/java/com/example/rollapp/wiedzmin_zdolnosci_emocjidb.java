package com.example.rollapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class wiedzmin_zdolnosci_emocjidb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 9;

    private static final String TABLE_NAME = "statystyki_emocji";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_AMORY = "amory";
    private static final String COLUMN_EMPATIA = "empatia";
    private static final String COLUMN_HAZARD = "hazard";
    private static final String COLUMN_OSZUSTWO = "oszustwo";
    private static final String COLUMN_PERSWAZJA = "perswazja";
    private static final String COLUMN_PRZYWODZTWO = "przywodztwo";
    private static final String COLUMN_STYL = "styl";
    private static final String COLUMN_SZTUKA = "sztuka";
    private static final String COLUMN_UROK = "urok";
    private static final String COLUMN_WYSTEPY = "wystepy";

    public wiedzmin_zdolnosci_emocjidb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    public wiedzmin_zdolnosci_emocjidb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_AMORY + " INTEGER, " +
                COLUMN_EMPATIA + " INTEGER, " +
                COLUMN_HAZARD + " INTEGER, " +
                COLUMN_OSZUSTWO + " INTEGER, " +
                COLUMN_PERSWAZJA + " INTEGER, " +
                COLUMN_PRZYWODZTWO + " INTEGER, " +
                COLUMN_STYL + " INTEGER, " +
                COLUMN_SZTUKA + " INTEGER, " +
                COLUMN_UROK + " INTEGER, " +
                COLUMN_WYSTEPY + " INTEGER " + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
