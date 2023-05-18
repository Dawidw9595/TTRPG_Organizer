package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class bronPostaci extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bron_postaci);
        TextView textView = findViewById(R.id.textView2);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Pacifico-Regular.ttf");
        textView.setTypeface(typeface);

    }
}