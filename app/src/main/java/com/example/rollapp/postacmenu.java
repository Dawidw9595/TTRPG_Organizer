package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class postacmenu extends AppCompatActivity {
    private ImageButton dozdciala;
    private ImageButton dozdrozumu;
    private ImageButton dozdreakcji;
    private ImageButton dozdemocji;
    private ImageButton dozdgracji;
    private ImageButton dozdfachu;
    private ImageButton dozdwola;
    private ImageButton docech;
    private ImageButton statystyki;
    private ImageButton Ekwipunek;

    private TextView nazwa;

    private static final String SHERED_PREFS = "daneuzyt";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postac);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        SharedPreferences.Editor editor = sessionstorage.edit();
        editor.putString("modyfikajca","tak");
        editor.commit();

        Toast.makeText(this, String.valueOf(sessionstorage.getInt("id_karty",0)), Toast.LENGTH_SHORT).show();

        dozdciala = findViewById(R.id.dozdciala);
        dozdrozumu = findViewById(R.id.dozdrozumu);
        dozdreakcji = findViewById(R.id.imageButton7);
        dozdemocji = findViewById(R.id.dozdemocji);
        dozdgracji = findViewById(R.id.dozdgracji);
        dozdfachu = findViewById(R.id.dozdfachu);
        dozdwola = findViewById(R.id.dozdwoli);
        docech = findViewById(R.id.docech);
        statystyki = findViewById(R.id.imageButton);
        Ekwipunek = findViewById(R.id.imageButton2);

        docech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(postacmenu.this,cechyPostaci.class);
                startActivity(intent);
            }
        });

        dozdciala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(postacmenu.this,umCialoPostaci.class);
                startActivity(intent);
            }
        });

        dozdemocji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(postacmenu.this,umEmocjePostaci.class);
                startActivity(intent);
            }
        });

        dozdfachu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(postacmenu.this,umFachPostaci.class);
                startActivity(intent);
            }
        });

        dozdgracji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(postacmenu.this,umGracjaPostaci.class);
                startActivity(intent);
            }
        });

        dozdreakcji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(postacmenu.this,umReakcjaPostaci.class);
                startActivity(intent);
            }
        });

        dozdrozumu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(postacmenu.this,umRozumPostaci.class);
                startActivity(intent);
            }
        });

        dozdwola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(postacmenu.this,umWolaPostaci.class);
                startActivity(intent);
            }
        });

        nazwa = findViewById(R.id.nazwapostaci);
        nazwa.setText(sessionstorage.getString("nazwapostaci","Dziala"));
    }
}
