package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class umEmocjePostaci extends AppCompatActivity {
Button dozdolnoscifachu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_um_emocje_postaci);

        dozdolnoscifachu = findViewById(R.id.dofachu);
        dozdolnoscifachu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(umEmocjePostaci.this, umFachPostaci.class);

                startActivity(intent);
            }

        });
    }
}