package com.example.rollapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class userdb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "uzytkownik";
    private static final String COLUMN_ID = "id";

    private static final String COLUMN_NAME = "imie";

    private static final String COLUMN_SURNAME = "nazwisko";
    private static final String COLUMN_USER = "nazwa_uzytkownika";
    private static final String COLUMN_PASSWORD = "haslo";
    private static final String COLUMN_E_MAIL = "email";








    public userdb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_SURNAME + " TEXT, " +
                COLUMN_USER + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_E_MAIL + " TEXT );";
        db.execSQL(query);
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }



    void addUser(String IMIE , String NAZWISKO , String NICK , String HASLO , String EMAIL)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues co = new ContentValues();

        co.put(COLUMN_NAME, IMIE);
        co.put(COLUMN_SURNAME, NAZWISKO);
        co.put(COLUMN_USER, NICK);
        co.put(COLUMN_PASSWORD, HASLO);
        co.put(COLUMN_E_MAIL, EMAIL);
        long wynik=db.insert(TABLE_NAME,null,co);
        if(wynik == -1)
        {
            Toast.makeText(context,"Wystąpił błąd",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context,"Urzytkownik został dodany poprawanie",Toast.LENGTH_SHORT).show();
        }

        db.close();
    }
    int login(String nick)
    {
        String query = "SELECT " + COLUMN_USER + " FROM " + TABLE_NAME +  " WHERE " + COLUMN_USER + "='" + nick + "'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c=null;

        if(db != null)
        {
            c=db.rawQuery(query,null);
            if(c.moveToFirst())
            {
                db.close();
                return 1;
            }
            else
            {
                db.close();
                return 0;
            }
        }
        else
        {
            db.close();
            return 0;
        }
    }

    int mail(String mail)
    {
        String query = "SELECT " + COLUMN_E_MAIL + " FROM " + TABLE_NAME +  " WHERE " + COLUMN_E_MAIL + "='" + mail + "'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c=null;
        if(db != null)
        {
            c=db.rawQuery(query,null);
            if(c.moveToFirst())
            {
                db.close();
                return 1;
            }
            else
            {
                db.close();
                return 0;
            }
        }
        else
        {
            db.close();
            return 0;
        }
    }

    String haslo(String nick) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_USER + "='" + nick + "'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mycursor=null;
        if(db != null)
        {
            mycursor = db.rawQuery(query,null);
            mycursor.moveToFirst();
        }
        db.close();
        return String.valueOf(mycursor.getString(4));
    }
}
