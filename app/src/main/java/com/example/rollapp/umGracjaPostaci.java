package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class umGracjaPostaci extends AppCompatActivity {
Button dozdolnoscireakcji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_um_gracja_postaci);


        dozdolnoscireakcji = findViewById(R.id.dorekacji);
        dozdolnoscireakcji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(umGracjaPostaci.this, umReakcjaPostaci.class);

                startActivity(intent);
            }

        });
    }
}