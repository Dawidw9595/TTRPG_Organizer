package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class danePostaci extends AppCompatActivity {

    private EditText nazwa;

    private EditText plec;

    private EditText rasa;

    private EditText wiek;

    Button zapisz;

    Button doCech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dane_postaci);
        TextView textView = findViewById(R.id.textView);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Pacifico-Regular.ttf");
        textView.setTypeface(typeface);

        doCech = findViewById(R.id.doCech);

        nazwa = findViewById(R.id.nazwa_postaci);
        plec = findViewById(R.id.plec);
        rasa = findViewById(R.id.rasa);
        wiek = findViewById(R.id.wiek);

        zapisz = findViewById(R.id.zapisdane);

        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        doCech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(danePostaci.this, cechyPostaci.class);

                startActivity(intent);
            }

        });
    }

}