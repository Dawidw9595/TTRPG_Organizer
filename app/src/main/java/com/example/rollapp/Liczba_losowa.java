package com.example.rollapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Liczba_losowa extends AppCompatActivity implements SensorEventListener {

    private long lastUpdate = 0;
    private float lastX = 0;
    private float lastY = 0;
    private float lastZ = 0;
    private int numSides = 6; // początkowa liczba ścianek na kości do gry

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losowanie);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        // pobranie elementu, który będzie reprezentował aktualną liczbę ścianek na ekranie
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView numSidesDisplay = findViewById(R.id.Losuj);

        // ustawienie przycisków do zmiany liczby ścianek na kości do gry
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(view -> changeNumSides(4, numSidesDisplay));
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(view -> changeNumSides(6, numSidesDisplay));
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(view -> changeNumSides(8, numSidesDisplay));
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button10 = findViewById(R.id.button10);
        button10.setOnClickListener(view -> changeNumSides(10, numSidesDisplay));
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button12 = findViewById(R.id.button12);
        button12.setOnClickListener(view -> changeNumSides(12, numSidesDisplay));
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button20 = findViewById(R.id.button20);
        button20.setOnClickListener(view -> changeNumSides(20, numSidesDisplay));
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button100 = findViewById(R.id.button100);
        button100.setOnClickListener(view -> changeNumSides(100, numSidesDisplay));

    }
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

                // jeśli prędkość przekracza próg potrząsania, generuj losową liczbę
                if (speed > SHAKE_THRESHOLD) {
                    int randomNum;
                    if (numSides == 100) {
                        randomNum = (int) (Math.random() * 10) + 1;
                        double randomDecimal = Math.floor(Math.random() * 10) + 1;
                        randomNum = randomNum + (int) (randomDecimal * 0.1);
                    } else {
                        randomNum = (int) (Math.random() * numSides) + 1;
                    }
                    Log.d("Shake", "Random number: " + randomNum);
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

    private static final int SHAKE_THRESHOLD = 1000; // ustalenie prógu potrząsania
}
