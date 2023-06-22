package com.example.rollapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class WynikiLosActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyniki_los);

        databaseHelper = new DatabaseHelper(this);

        // Pobranie wyników z bazy danych
        List<RollData> rollDataList = databaseHelper.getAllRollData();

        // Wyświetlenie wyników w widoku
        displayRollData(rollDataList);
    }

    private void displayRollData(List<RollData> rollDataList) {
        TextView wynikiTextView = findViewById(R.id.wynikiTextView);

        StringBuilder stringBuilder = new StringBuilder();

        // Odwrócenie kolejności elementów w liście
        List<RollData> reversedList = new ArrayList<>(rollDataList);
        Collections.reverse(reversedList);

        for (RollData rollData : reversedList) {
            stringBuilder.append("Osoba: ").append(rollData.getPerson()).append("\n");
            stringBuilder.append("Numer: ").append(rollData.getNumber()).append("\n");

            // Parsowanie daty i godziny
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            Date dateTime;
            try {
                dateTime = sdf.parse(rollData.getDateTime());
                // Formatowanie daty i godziny
                SimpleDateFormat displayFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
                String formattedDateTime = displayFormat.format(dateTime);
                stringBuilder.append("Data i godzina: ").append(formattedDateTime).append("\n");
            } catch (ParseException e) {
                e.printStackTrace();
            }

            stringBuilder.append("\n");
        }

        wynikiTextView.setText(stringBuilder.toString());
    }}