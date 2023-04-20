package com.example.rollapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
public class postacdb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 5;

    private static final String TABLE_NAME = "postac";
    private static final String COLUMN_ID = "id";


    private static final String COLUMN_CH_NAME = "nazwapostaci";
    private static final String COLUMN_PLAYER_ID = "id_gracz";
    private static final String COLUMN_GAME_ID = "id_gra";




    public postacdb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    public postacdb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL UNIQUE, " +
                COLUMN_CH_NAME + " TEXT  NOT NULL, " + " FK_" +
                COLUMN_PLAYER_ID + "INTEGER, FOREIGN KEY('"+ COLUMN_PLAYER_ID +"') REFERENCES " + " uzytkownik('id'), " + " FK_" +
                COLUMN_GAME_ID + " INTEGER, FOREIGN KEY('"+ COLUMN_GAME_ID +"') REFERENCES " + " gra('id') " +

                ");";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addp(String NAZWA, Integer POSTAC, Integer GRA )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues co = new ContentValues();


        co.put(COLUMN_CH_NAME, NAZWA);
        co.put(COLUMN_PLAYER_ID, POSTAC);
        co.put(COLUMN_GAME_ID, GRA);

        db.insert(TABLE_NAME,null, co);
        Toast.makeText(context,"Dodano POSTAC",Toast.LENGTH_SHORT).show();
    }
}
