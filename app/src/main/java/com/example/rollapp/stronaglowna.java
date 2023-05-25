package com.example.rollapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class stronaglowna extends AppCompatActivity {

    private ImageButton losowanie;

    private ImageButton twojepostacie;

    private TextView nickuzyt;

    private static final String SHERED_PREFS = "daneuzyt";


    private ImageButton stworzPostac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stronaglowna);
        losowanie = findViewById(R.id.imageButton6);
        nickuzyt = findViewById(R.id.nickclick);
        twojepostacie = findViewById(R.id.twojepostacie);

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
                SharedPreferences.Editor editor = sessionstorage.edit();
                editor.remove("modyfikajca");
                editor.commit();
                startActivity(intent);
            }

        });

        twojepostacie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(stronaglowna.this, lista_postaci.class);
                startActivity(intent);
            }
        });
    }
}