package com.example.rollapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class wiedzmin_statystyki_pancerzdb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 13;

    private static final String TABLE_NAME = "wiedzmin_statystyki_pancerza";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_HEAD = "glowa";
    private static final String COLUMN_BODY = "korpus";
    private static final String COLUMN_R_ARM = "p_reka";
    private static final String COLUMN_L_LEG = "l_noga";
    private static final String COLUMN_L_ARM = "l_reka";
    private static final String COLUMN_R_LEG = "r_noga";





    public wiedzmin_statystyki_pancerzdb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_HEAD + " INTEGER, " +
                COLUMN_BODY + " INTEGER, " +
                COLUMN_R_ARM + " INTEGER, " +
                COLUMN_L_LEG + " INTEGER, " +
                COLUMN_L_ARM + " INTEGER, " +
                COLUMN_R_LEG + " INTEGER " +


                ");";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
