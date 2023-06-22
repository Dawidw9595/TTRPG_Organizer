package com.example.rollapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class informacjegracza extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ttrpg.db";
    private static final String TABLE_NAME = "users";
    private static final String COL_IMIE = "imie";
    private static final String COL_NICK = "nick";
    private static final String COL_NAZWA_POSTACI = "nazwa_postaci";

    private Context context;

    public informacjegracza(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tworzenie tabeli users (jeśli jeszcze nie istnieje)
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COL_IMIE + " TEXT, " +
                COL_NICK + " TEXT, " +
                COL_NAZWA_POSTACI + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public List<String> getInformacjeGracza() {
        List<String> informacjeGracza = new ArrayList<>();

        // Pobranie nazwy zalogowanego użytkownika
        SharedPreferences sharedPreferences = context.getSharedPreferences("daneuzyt", Context.MODE_PRIVATE);
        String nick = sharedPreferences.getString("nick", "");

        SQLiteDatabase db = this.getReadableDatabase();

        // Zapytanie do pobrania informacji o użytkowniku z tabeli "users" dla zalogowanego nicku
        String query = "SELECT " + COL_IMIE + ", " + COL_NICK +
                " FROM " + TABLE_NAME +
                " WHERE " + COL_NICK + " = '" + nick + "'";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            @SuppressLint("Range") String imie = cursor.getString(cursor.getColumnIndex(COL_IMIE));

            informacjeGracza.add("Imię: " + imie);
            informacjeGracza.add("Nick: " + nick);
        }

        cursor.close();
        db.close();

        return informacjeGracza;
    }

    public List<String> getPostacieGracza() {
        List<String> postacieGracza = new ArrayList<>();

        // Pobranie nazwy zalogowanego użytkownika
        SharedPreferences sharedPreferences = context.getSharedPreferences("daneuzyt", Context.MODE_PRIVATE);
        String nick = sharedPreferences.getString("nick", "");

        SQLiteDatabase db = this.getReadableDatabase();

        // Zapytanie do pobrania postaci użytkownika z tabeli "users" dla zalogowanego nicku
        String query = "SELECT " + COL_NAZWA_POSTACI +
                " FROM " + TABLE_NAME +
                " WHERE " + COL_NICK + " = '" + nick + "'";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String nazwaPostaci = cursor.getString(cursor.getColumnIndex(COL_NAZWA_POSTACI));
                postacieGracza.add(nazwaPostaci);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return postacieGracza;
    }
}
