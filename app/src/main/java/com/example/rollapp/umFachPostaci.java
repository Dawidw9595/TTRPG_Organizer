package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class umFachPostaci extends AppCompatActivity {
Button dozdolnoscigracji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_um_fach_postaci);

        dozdolnoscigracji = findViewById(R.id.dogracji);
        dozdolnoscigracji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(umFachPostaci.this, umGracjaPostaci.class);

                startActivity(intent);
            }

        });
    }
}