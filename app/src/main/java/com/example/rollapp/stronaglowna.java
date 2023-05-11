package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class stronaglowna extends AppCompatActivity {

    ImageButton losowanie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stronaglowna);
        losowanie = findViewById(R.id.imageButton6);
        losowanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(stronaglowna.this, Liczba_losowa.class);

                startActivity(intent);
            }

        });
    }
}