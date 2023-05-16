package com.example.rollapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class wiedzmin_statystyki_brondb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 12;

    private static final String TABLE_NAME = "wiedzmin_statystyki_broni";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "nazwa";
    private static final String COLUMN_AIM = "celnosc";
    private static final String COLUMN_DAMAGE = "obrazenia";
    private static final String COLUMN_DURABILITY = "trwalosc";
    private static final String COLUMN_HANDED = "recznosc";
    private static final String COLUMN_RANGE = "zasieg";
    private static final String COLUMN_EFFECTS = "efekty";
    private static final String COLUMN_DISCRETION = "dyskrecja";
    private static final String COLUMN_REINFORCEMENTS = "wzmocnienia";




    public wiedzmin_statystyki_brondb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_AIM + " TEXT, " +
                COLUMN_DAMAGE + " Text, " +
                COLUMN_DURABILITY + " INTEGER, " +
                COLUMN_HANDED + " INTEGER, " +
                COLUMN_RANGE + " Text, " +
                COLUMN_EFFECTS + " Text, " +
                COLUMN_DISCRETION + " Text, " +
                COLUMN_REINFORCEMENTS + " INTEGER " +

                ");";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
