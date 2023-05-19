package com.example.rollapp;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class stronaglowna extends AppCompatActivity {

    private ImageButton losowanie;

    private TextView nickuzyt;

    private String imie;
    private String nazwisko;
    private String nick;
    private String haslo;
    private String email;


    ImageButton stworzPostac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stronaglowna);
        losowanie = findViewById(R.id.imageButton6);
        nickuzyt = findViewById(R.id.nickclick);

        Intent pop = getIntent();

        nickuzyt.setText(getIntent().getExtras().getString("nick"));
        imie = pop.getStringExtra("imie");
        nazwisko = pop.getStringExtra("nazwisko");
        nick = pop.getStringExtra("nick");
        haslo = pop.getStringExtra("haslo");
        email = pop.getStringExtra("email");

        nickuzyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(stronaglowna.this, zmianadanychuzyt.class);
                intent.putExtra("imie" , imie);
                intent.putExtra("nazwisko" , nazwisko);
                intent.putExtra("nick" , nick);
                intent.putExtra("haslo" , haslo);
                intent.putExtra("email" , email);
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