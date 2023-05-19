package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class umCialoPostaci extends AppCompatActivity {
Button dozdolnosciemocji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_um_cialo_postaci);

        dozdolnosciemocji = findViewById(R.id.doemocji);
        dozdolnosciemocji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(umCialoPostaci.this, umEmocjePostaci.class);

                startActivity(intent);
            }

        });
    }
}