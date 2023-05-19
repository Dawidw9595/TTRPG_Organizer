package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class umRozumPostaci extends AppCompatActivity {
Button dozdolnosciwoli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_um_rozum_postaci);

        dozdolnosciwoli = findViewById(R.id.dowoli);
        dozdolnosciwoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(umRozumPostaci.this, umWolaPostaci.class);

                startActivity(intent);
            }

        });
    }
}