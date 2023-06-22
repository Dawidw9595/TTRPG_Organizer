package com.example.rollapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Liczba_losowa extends AppCompatActivity implements SensorEventListener {

    Button wyniki;
    private long lastUpdate = 0;
    private float lastX = 0;
    private float lastY = 0;
    private float lastZ = 0;
    private int numSides = 6; // początkowa liczba ścianek na kości do gry
    private DatabaseHelper databaseHelper;
    private boolean isUserLoggedIn;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losowanie);

        // Inicjalizacja helpera bazy danych
        databaseHelper = new DatabaseHelper(this);

        // Sprawdzenie, czy użytkownik jest zalogowany
        SharedPreferences sharedPreferences = getSharedPreferences("daneuzyt", 0);
        isUserLoggedIn = sharedPreferences.contains("nick"); // Sprawdzenie, czy klucz "nick" istnieje w SharedPreferences

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        // pobranie elementu, który będzie reprezentował aktualną liczbę ścianek na ekranie
        TextView numSidesDisplay = findViewById(R.id.Liczba);

        // ustawienie przycisków do zmiany liczby ścianek na kości do gry
        ImageButton button4 = findViewById(R.id.k4);
        button4.setOnClickListener(view -> changeNumSides(4, numSidesDisplay));
        ImageButton button6 = findViewById(R.id.k6);
        button6.setOnClickListener(view -> changeNumSides(6, numSidesDisplay));
        ImageButton button8 = findViewById(R.id.k8);
        button8.setOnClickListener(view -> changeNumSides(8, numSidesDisplay));
        ImageButton button10 = findViewById(R.id.k10);
        button10.setOnClickListener(view -> changeNumSides(10, numSidesDisplay));
        ImageButton button12 = findViewById(R.id.k12);
        button12.setOnClickListener(view -> changeNumSides(12, numSidesDisplay));
        ImageButton button20 = findViewById(R.id.k20);
        button20.setOnClickListener(view -> changeNumSides(20, numSidesDisplay));
        ImageButton button100 = findViewById(R.id.k100);
        button100.setOnClickListener(view -> changeNumSides(100, numSidesDisplay));

        wyniki = findViewById(R.id.wyniki);
        wyniki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Liczba_losowa.this, WynikiLosActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Sprawdzenie, czy użytkownik jest zalogowany
        sharedPreferences = getSharedPreferences("daneuzyt", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("nick", "");
        isUserLoggedIn = !username.isEmpty(); // Sprawdzenie, czy nazwa użytkownika jest pusta

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float[] acceleration = event.values;
            long curTime = System.currentTimeMillis();

            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;

                float x = acceleration[0];
                float y = acceleration[1];
                float z = acceleration[2];

                float speed = Math.abs(x + y + z - lastX - lastY - lastZ) / diffTime * 10000;

                // Sprawdzenie, czy użytkownik jest zalogowany
                String username = sharedPreferences.getString("nick", "");
                isUserLoggedIn = !username.isEmpty(); // Sprawdzenie, czy nazwa użytkownika jest pusta

                // jeśli prędkość przekracza próg potrząsania, generuj losową liczbę
                if (speed > SHAKE_THRESHOLD) {
                    int randomNum;
                    String person;

                    if (isUserLoggedIn) {
                        person = username; // Użyj nazwy użytkownika z SharedPreferences
                        randomNum = (int) (Math.random() * numSides) + 1;  // generowanie losowej liczby
                    } else {
                        person = "gość";
                        randomNum = (int) (Math.random() * numSides) + 1;  // generowanie losowej liczby
                    }

                    // Zapisz informacje do bazy danych
                    String dateTime = getCurrentDateTime();  // pobranie aktualnej daty i godziny
                    databaseHelper.saveRollData(person, randomNum, dateTime);

                    TextView textView = findViewById(R.id.Losuj);
                    textView.setText(Integer.toString(randomNum)); // ustawienie wylosowanej liczby w widoku
                }

                lastX = x;
                lastY = y;
                lastZ = z;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @SuppressLint("SetTextI18n")
    private void changeNumSides(int newNumSides, TextView numSidesDisplay) {
        numSides = newNumSides;
        numSidesDisplay.setText(Integer.toString(numSides));
    }

    private static final int SHAKE_THRESHOLD = 100; // ustalenie prógu potrząsania

    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }
}
