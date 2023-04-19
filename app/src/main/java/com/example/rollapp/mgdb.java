package com.example.rollapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
public class mgdb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 3;

    private static final String TABLE_NAME = "mg";
    private static final String COLUMN_ID = "id";

    private static final String COLUMN_NAME = "imie";

    private static final String COLUMN_SURNAME = "nazwisko";
    private static final String COLUMN_USER = "nazwauzytkownika";
    private static final String COLUMN_PASSWORD = "haslo";
    private static final String COLUMN_E_MAIL = "email";
    private static final String COLUMN_ADMINISTRATOR = "id_administrator";


    public mgdb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    public mgdb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_SURNAME + " TEXT, " +
                COLUMN_USER + " TEXT, " +
                COLUMN_E_MAIL + " TEXT, " +
                COLUMN_PASSWORD + " TEXT,  " +
                COLUMN_ADMINISTRATOR + " INTEGER, FOREIGN KEY('"+ COLUMN_ADMINISTRATOR +"') REFERENCES " + "administrator('_id')"  +
                ");";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addMG(String IMIE, String NAZWISKO, String  EMAIL, String  USERN, String  HASLO, Integer IDADMIN )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues co = new ContentValues();


        co.put(COLUMN_NAME, IMIE);
        co.put(COLUMN_SURNAME, NAZWISKO);
        co.put(COLUMN_USER, EMAIL);
        co.put(COLUMN_PASSWORD, USERN);
        co.put(COLUMN_E_MAIL, HASLO);
        co.put(COLUMN_ADMINISTRATOR, IDADMIN);

        db.insert(TABLE_NAME,null, co);
        Toast.makeText(context,"Dodano MG",Toast.LENGTH_SHORT).show();
    }
}
