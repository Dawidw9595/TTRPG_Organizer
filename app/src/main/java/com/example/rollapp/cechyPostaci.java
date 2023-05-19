package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cechyPostaci extends AppCompatActivity {
    Button doZdolnosciCiala;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cechy_postaci);

        doZdolnosciCiala = findViewById(R.id.dociala);
        doZdolnosciCiala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cechyPostaci.this, umCialoPostaci.class);

                startActivity(intent);
            }

        });
    }



}

