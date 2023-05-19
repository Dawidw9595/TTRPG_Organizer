package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class umReakcjaPostaci extends AppCompatActivity {
Button dozdolnoscirozumu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_um_reakcja_postaci);

        dozdolnoscirozumu = findViewById(R.id.dorozumu);
        dozdolnoscirozumu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(umReakcjaPostaci.this, umRozumPostaci.class);

                startActivity(intent);
            }

        });
    }
}