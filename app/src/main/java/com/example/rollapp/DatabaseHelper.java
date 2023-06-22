package com.example.rollapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ttrpg.db";
    private static final String TABLE_NAME = "wyniki";
    private static final String COL_ID = "id";
    private static final String COL_OSOBA = "osoba";
    private static final String COL_NUMER = "numer";
    private static final String COL_DATE = "date";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_OSOBA + " TEXT, " +
                COL_NUMER + " INTEGER, " +
                COL_DATE + " TEXT)";
        db.execSQL(createTable);
    }

    public List<RollData> getAllRollData() {
        List<RollData> rollDataList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        // Zapytanie do pobrania wszystkich rekordów z tabeli "wyniki"
        String query = "SELECT * FROM wyniki";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                // Pobieranie danych z kursora
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String person = cursor.getString(cursor.getColumnIndex("osoba"));
                @SuppressLint("Range") int number = cursor.getInt(cursor.getColumnIndex("numer"));
                @SuppressLint("Range") String dateTime = cursor.getString(cursor.getColumnIndex("date"));

                // Tworzenie obiektu RollData i dodawanie go do listy
                RollData rollData = new RollData(id, person, number, dateTime);
                rollDataList.add(rollData);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return rollDataList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean saveRollData(String person, int number, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_OSOBA, person);
        contentValues.put(COL_NUMER, number);
        contentValues.put(COL_DATE, date);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }
}

