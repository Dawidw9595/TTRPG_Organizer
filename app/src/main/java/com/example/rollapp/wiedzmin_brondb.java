package com.example.rollapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class wiedzmin_brondb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 10;

    private static final String TABLE_NAME = "wiedzmin_bron";
    private static final String COLUMN_ID = "id";

    private static final String COLUMN_CART_ID = "id_karta";

    private static final String COLUMN_WEAPON_ID = "id_bron";



    public wiedzmin_brondb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CART_ID + " INTEGER, " +
                COLUMN_WEAPON_ID + " INTEGER, " +

                " FOREIGN KEY('"+ COLUMN_CART_ID +"') REFERENCES " + "karta('_id'), "  +
                " FOREIGN KEY('"+ COLUMN_WEAPON_ID +"') REFERENCES " + "wiedzmin_statystyka_bron('_id')"  +

                ");";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
