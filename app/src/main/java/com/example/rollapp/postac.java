package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class postac extends AppCompatActivity {
    ImageButton dozdciala;
    ImageButton dozdrozumu;
    ImageButton dozdreakcji;
    ImageButton dozdemocji;
    ImageButton dozdgracji;
    ImageButton dozdfachu;
    ImageButton dozdwola;
    ImageButton docech;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postac);

        dozdciala = findViewById(R.id.dozdciala);
        dozdrozumu = findViewById(R.id.dozdrozumu);
        dozdreakcji = findViewById(R.id.dozdreakcji);
        dozdemocji = findViewById(R.id.dozdemocji);
        dozdgracji = findViewById(R.id.dozdgracji);
        dozdfachu = findViewById(R.id.dozdfachu);
        dozdwola = findViewById(R.id.dozdwoli);
        docech = findViewById(R.id.docech);
        dozdciala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(postac.this, umCialoPostaci.class);

                startActivity(intent);
            }

        });
        dozdrozumu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(postac.this, umRozumPostaci.class);

                startActivity(intent);
            }

        });
        dozdreakcji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(postac.this, umReakcjaPostaci.class);

                startActivity(intent);
            }

        });
        dozdemocji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(postac.this, umEmocjePostaci.class);

                startActivity(intent);
            }

        });
        dozdgracji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(postac.this, umGracjaPostaci.class);

                startActivity(intent);
            }

        });
        dozdfachu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(postac.this, umFachPostaci.class);

                startActivity(intent);
            }

        });
        dozdwola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(postac.this, umWolaPostaci.class);

                startActivity(intent);
            }

        });
        docech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(postac.this, cechyPostaci.class);

                startActivity(intent);
            }

        });
    }


    }
