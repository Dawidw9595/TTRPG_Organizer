package com.example.rollapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class wiedzmin_pancerzdb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 11;

    private static final String TABLE_NAME = "wiedzmin_pancerz";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CART_ID = "id_karta";
    private static final String COLUMN_ARMOR_ID = "id_pancerza";
    private static final String COLUMN_ARMORDAMAGE_ID = "id_uszkodzeniapancerza";



    public wiedzmin_pancerzdb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CART_ID + " INTEGER, " +
                COLUMN_ARMOR_ID + " INTEGER, " +
                COLUMN_ARMORDAMAGE_ID + " INTEGER, " +

                " FOREIGN KEY('"+ COLUMN_CART_ID +"') REFERENCES " + "karta('_id'), "  +
                " FOREIGN KEY('"+ COLUMN_ARMOR_ID +"') REFERENCES " + "wiedzmin_statystyka_pancerza('_id'),"  +
                " FOREIGN KEY('"+ COLUMN_ARMORDAMAGE_ID +"') REFERENCES " + "wiedzmin_uszkodzenia_pancerza('_id')"  +

                ");";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
