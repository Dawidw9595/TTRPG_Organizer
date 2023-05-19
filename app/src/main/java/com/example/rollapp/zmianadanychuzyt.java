package com.example.rollapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class zmianadanychuzyt extends AppCompatActivity {

    private TextView imie;
    private TextView nazwisko;
    private TextView nick;
    private TextView email;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ativity_zmianabaza);

        imie = findViewById(R.id.i1);
        nazwisko = findViewById(R.id.n2);
        nick = findViewById(R.id.n3);
        email = findViewById(R.id.e4);

        imie.setText(getIntent().getExtras().getString("imie"));
        nazwisko.setText(getIntent().getExtras().getString("nazwisko"));
        nick.setText(getIntent().getExtras().getString("nick"));
        email.setText(getIntent().getExtras().getString("email"));
    }
}
