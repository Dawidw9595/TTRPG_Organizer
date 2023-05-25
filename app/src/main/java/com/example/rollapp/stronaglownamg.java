package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class stronaglownamg extends AppCompatActivity {


        private ImageButton losowanie;

        private ImageButton twojepostacie;

        private TextView nickuzyt;

        private static final String SHERED_PREFS = "daneuzyt";


        private ImageButton stworzPostac;

        private ImageButton twoigracze;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_stronaglownamg);
            losowanie = findViewById(R.id.imageButton6);
            nickuzyt = findViewById(R.id.nickclick);
            twojepostacie = findViewById(R.id.twojepostacie);
            twoigracze = findViewById(R.id.twoigracze);

            SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);


            losowanie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(stronaglownamg.this, Liczba_losowa.class);
                    startActivity(intent);
                }

            });

            stworzPostac = findViewById(R.id.stworzPostac);
            stworzPostac.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(stronaglownamg.this, danePostaci.class);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.remove("modyfikajca");
                    editor.commit();
                    startActivity(intent);
                }

            });

            twojepostacie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(stronaglownamg.this, lista_postaci.class);
                    startActivity(intent);
                }
            });
            twoigracze.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(stronaglownamg.this, lista_graczy.class);
                    startActivity(intent);
                }
            });
        }
    }
