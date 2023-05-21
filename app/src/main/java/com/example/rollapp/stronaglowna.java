package com.example.rollapp;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class stronaglowna extends AppCompatActivity {

    private ImageButton losowanie;

    private TextView nickuzyt;

    private Integer id;
    private String imie;
    private String nazwisko;
    private String nick;
    private String haslo;
    private String email;

    private static final String SHERED_PREFS = "daneuzyt";


    ImageButton stworzPostac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stronaglowna);
        losowanie = findViewById(R.id.imageButton6);
        nickuzyt = findViewById(R.id.nickclick);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        nickuzyt.setText(sessionstorage.getString("nick","Błąd"));

        nickuzyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(stronaglowna.this, zmianadanychuzyt.class);
                startActivity(intent);
            }
        });

        losowanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(stronaglowna.this, Liczba_losowa.class);
                startActivity(intent);
            }

        });

        stworzPostac = findViewById(R.id.stworzPostac);
        stworzPostac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(stronaglowna.this, danePostaci.class);

                startActivity(intent);
            }

        });

        stworzPostac = findViewById(R.id.stworzPostac);
        stworzPostac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(stronaglowna.this, danePostaci.class);

                startActivity(intent);
            }

        });
    }
}