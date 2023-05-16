package com.example.rollapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class wiedzmin_kartadb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "TTRPG";
    private static final int DATABASE_VERSION = 6;

    private static final String TABLE_NAME = "postac";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "nazwa";
    private static final String COLUMN_RASE = "rasa";
    private static final String COLUMN_SEX = "plec";
    private static final String COLUMN_AGE = "wiek";
    private static final String COLUMN_PROFESSION = "profesja";
    private static final String COLUMN_CHARACTER_ID = "id_postaci";
    private static final String COLUMN_CHARACTERISTICS_ID = "id_cechy";
    private static final String COLUMN_REASONABILITIES_ID = "id_zdolnosci";
    private static final String COLUMN_REACTIONABILITIES_ID = "id_reakcji";
    private static final String COLUMN_GRACEABILITIES_ID = "id_gracji";
    private static final String COLUMN_BODYABILITIES_ID = "id_ciala";
    private static final String COLUMN_EMOTIONSABILITIES_ID = "id_emocji";
    private static final String COLUMN_PROFESSIONALABILITIES_ID = "id_fachu";
    private static final String COLUMN_WILLABILITIES_ID = "id_woli";
    private static final String COLUMN_CHRACTERISTICABILITY = "zdolnosc_charakterystyczna";
    private static final String COLUMN_PROFESSIONABILITIES = "zdolnosc_profesji";
    private static final String COLUMN_MONEY = "pieniadze";
    private static final String COLUMN_CART_ID = "id_karty";
    private static final String COLUMN_EQUIPMENT = "ekwipunek";
    private static final String COLUMN_VIGOR = "wigor";
    private static final String COLUMN_CLOTHES = "ubranie";
    private static final String COLUMN_PERSONALITY = "osobowosc";
    private static final String COLUMN_HAIRS = "wlosy";
    private static final String COLUMN_DECORATIONS = "ozdoby";
    private static final String COLUMN_MOSTIMPORTANTPERSON = "nawazniejsza_osoba";
    private static final String COLUMN_APRICIATESTHEMOST = "najbardziej_ceni";
    private static final String COLUMN_ABOUTOTHERS = "o_innych";
    private static final String COLUMN_ORIGIN = "pochodzenie";
    private static final String COLUMN_EVENTS = "wydarzenia";




    public wiedzmin_kartadb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT  NOT NULL, " +
                COLUMN_RASE + " INTEGER,"+
                COLUMN_SEX + " TEXT,"+
                COLUMN_AGE + " INTEGER,"+
                COLUMN_PROFESSION + " TEXT,"+
                COLUMN_CHARACTER_ID + " INTEGER,"+
                COLUMN_CHARACTERISTICS_ID + " INTEGER,"+
                COLUMN_REASONABILITIES_ID + " INTEGER,"+
                COLUMN_REACTIONABILITIES_ID + " INTEGER,"+
                COLUMN_GRACEABILITIES_ID + " INTEGER,"+
                COLUMN_BODYABILITIES_ID + " INTEGER,"+
                COLUMN_EMOTIONSABILITIES_ID + " INTEGER,"+
                COLUMN_PROFESSIONALABILITIES_ID + " INTEGER,"+
                COLUMN_WILLABILITIES_ID + " INTEGER,"+
                COLUMN_CHRACTERISTICABILITY + " TEXT,"+
                COLUMN_PROFESSIONABILITIES + "TEXT, "+
                COLUMN_PROFESSION + " TEXT,"+
                COLUMN_MONEY + " INTEGER,"+
                COLUMN_CART_ID + " INTEGER,"+
                COLUMN_EQUIPMENT + " TEXT,"+
                COLUMN_VIGOR + " INTEGER,"+
                COLUMN_CLOTHES + " TEXT,"+
                COLUMN_PERSONALITY + " TEXT,"+
                COLUMN_HAIRS + " TEXT,"+
                COLUMN_DECORATIONS + " TEXT,"+
                COLUMN_MOSTIMPORTANTPERSON + " TEXT,"+
                COLUMN_APRICIATESTHEMOST + " TEXT,"+
                COLUMN_ABOUTOTHERS + " TEXT,"+
                COLUMN_ORIGIN + " TEXT,"+
                COLUMN_EVENTS + " TEXT,"+



                " FOREIGN KEY('"+ COLUMN_CHARACTER_ID +"') REFERENCES " + " postac('id'), " +
                "FOREIGN KEY('"+ COLUMN_CHARACTERISTICS_ID +"') REFERENCES " + " cechy('id'), " +
                "FOREIGN KEY('"+ COLUMN_REASONABILITIES_ID +"') REFERENCES " + " wiedzmin_zdolnosci_rozumu('id'), " +
                "FOREIGN KEY('"+ COLUMN_REACTIONABILITIES_ID +"') REFERENCES " + " wiedzmin_zdolnosci_reakcji('id'), " +
                "FOREIGN KEY('"+ COLUMN_GRACEABILITIES_ID +"') REFERENCES " + " wiedzmin_zdolnosci_gracji('id'), " +
                "FOREIGN KEY('"+ COLUMN_BODYABILITIES_ID +"') REFERENCES " + " wiedzmin_zdolnosci_ciala('id'), " +
                "FOREIGN KEY('"+ COLUMN_EMOTIONSABILITIES_ID +"') REFERENCES " + " wiedzmin_zdolnosci_ciala('id'), " +
                "FOREIGN KEY('"+ COLUMN_PROFESSIONALABILITIES_ID +"') REFERENCES " + " wiedzmin_zdolnosci_fachu('id'), " +
                "FOREIGN KEY('"+ COLUMN_WILLABILITIES_ID +"') REFERENCES " + " wiedzmin_zdolnosci_woli('id'), " +
                "FOREIGN KEY('"+ COLUMN_CART_ID +"') REFERENCES " + " karta('id') " +


                ");";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
