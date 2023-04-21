package com.example.rollapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class wiedzmin_zdolnosci_rozumdb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 18;

    private static final String TABLE_NAME = "statystyki_rozum";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CZUJNOSC = "czujnosc";
    private static final String COLUMN_DEDUKCJA = "dedukcja";
    private static final String COLUMN_INTERESY = "interesy";
    private static final String COLUMN_J_KRASNOLUDZKI = "j_krasnoludzki";
    private static final String COLUMN_J_STARSZA_MOWA = "j_starsza_mowa";
    private static final String COLUMN_J_WSPOLNY = "j_wspolny";
    private static final String COLUMN_MIASTOWY = "miastowy";
    private static final String COLUMN_NAUCZANIE = "nauczanie";
    private static final String COLUMN_OBYCIE = "obycie";
    private static final String COLUMN_STRATEGIA = "strategia";
    private static final String COLUMN_SZTUKA_PRZETRWANIA = "sztuka_przetrwania";
    private static final String COLUMN_WIEDZA_O_POTWORACH = "wiedz_o_potworach";
    private static final String COLUMN_WYKSZTALCENIE = "wyksztalcenie";

    public wiedzmin_zdolnosci_rozumdb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    public wiedzmin_zdolnosci_rozumdb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CZUJNOSC + " INTEGER, " +
                COLUMN_DEDUKCJA + " INTEGER, " +
                COLUMN_INTERESY + " INTEGER, " +
                COLUMN_J_KRASNOLUDZKI + " INTEGER, " +
                COLUMN_J_STARSZA_MOWA + " INTEGER, " +
                COLUMN_J_WSPOLNY + " INTEGER, " +
                COLUMN_MIASTOWY + " INTEGER, " +
                COLUMN_NAUCZANIE + " INTEGER, " +
                COLUMN_OBYCIE + " INTEGER, " +
                COLUMN_STRATEGIA + " INTEGER, " +
                COLUMN_SZTUKA_PRZETRWANIA + " INTEGER, " +
                COLUMN_WIEDZA_O_POTWORACH + " INTEGER, " +
                COLUMN_WYKSZTALCENIE + " INTEGER " + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
