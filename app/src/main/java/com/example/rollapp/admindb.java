package com.example.rollapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
public class admindb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 2;

    private static final String TABLE_NAME = "administrator";

    private static final String COLUMN_ID = "_id";

    private static final String COLUMN_E_MAIL = "email";

    private static final String COLUMN_PASSWORD = "haslo";

    public admindb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_E_MAIL + " TEXT, " +
                COLUMN_PASSWORD + " TEXT );";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addADM(String EMAIL, String  HASLO)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues co = new ContentValues();

        co.put(COLUMN_E_MAIL, EMAIL);
        co.put(COLUMN_PASSWORD, HASLO);

        db.insert(TABLE_NAME,null, co);
        Toast.makeText(context,"Dodano",Toast.LENGTH_SHORT).show();
    }
}
