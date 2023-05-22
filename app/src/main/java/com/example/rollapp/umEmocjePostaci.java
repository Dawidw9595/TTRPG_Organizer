package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rollapp.model.wiedzmin_karta;
import com.example.rollapp.retrofit.emocjaApi;
import com.example.rollapp.retrofit.kartaApi;
import com.example.rollapp.retrofit.retrofitservice;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class umEmocjePostaci extends AppCompatActivity {

    private EditText amory;

    private EditText empatia;

    private EditText hazard;

    private EditText oszustwo;

    private EditText perswazja;

    private EditText przywodztwo;

    private EditText styl;

    private EditText sztuka;

    private EditText urok;

    private EditText wystepy;

    private Integer i=0;

    private static final String SHERED_PREFS = "daneuzyt";
    Button dozdolnoscifachu;

    Button zapisz;

    private void saveemocje(wiedzmin_zdolnosci_emocji wiedzmin_zdolnosci_emocji)
    {
        if (amory.getText().toString().isEmpty() ||
                empatia.getText().toString().isEmpty() ||
                hazard.getText().toString().isEmpty() ||
                oszustwo.getText().toString().isEmpty() ||
                perswazja.getText().toString().isEmpty() ||
                przywodztwo.getText().toString().isEmpty() ||
                sztuka.getText().toString().isEmpty() ||
                urok.getText().toString().isEmpty() ||
                wystepy.getText().toString().isEmpty() ||
                styl.getText().toString().isEmpty())
        {
            Toast.makeText(umEmocjePostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2<amory.getText().toString().length() ||
                    2<empatia.getText().toString().length() ||
                    2<hazard.getText().toString().length() ||
                    2<oszustwo.getText().toString().length() ||
                    2<perswazja.getText().toString().length() ||
                    2<przywodztwo.getText().toString().length() ||
                    2<sztuka.getText().toString().length() ||
                    2<urok.getText().toString().length() ||
                    2<wystepy.getText().toString().length() ||
                    2<styl.getText().toString().length())
            {
                Toast.makeText(umEmocjePostaci.this, "Wszystkie cechy nie mogą mieć więcej niż 2 cyfry", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                emocjaApi emocjaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.emocjaApi.class);

                wiedzmin_zdolnosci_emocji.setAmory(Integer.valueOf(amory.getText().toString()));
                wiedzmin_zdolnosci_emocji.setEmpatia(Integer.valueOf(empatia.getText().toString()));
                wiedzmin_zdolnosci_emocji.setHazard(Integer.valueOf(hazard.getText().toString()));
                wiedzmin_zdolnosci_emocji.setOszustwo(Integer.valueOf(oszustwo.getText().toString()));
                wiedzmin_zdolnosci_emocji.setPerswazja(Integer.valueOf(perswazja.getText().toString()));
                wiedzmin_zdolnosci_emocji.setPrzywodztwo(Integer.valueOf(przywodztwo.getText().toString()));
                wiedzmin_zdolnosci_emocji.setUrok(Integer.valueOf(urok.getText().toString()));
                wiedzmin_zdolnosci_emocji.setWystepy(Integer.valueOf(wystepy.getText().toString()));
                wiedzmin_zdolnosci_emocji.setStyl(Integer.valueOf(styl.getText().toString()));
                wiedzmin_zdolnosci_emocji.setSztuka(Integer.valueOf(sztuka.getText().toString()));
                emocjaApi.save(wiedzmin_zdolnosci_emocji).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(umEmocjePostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    private void getall(wiedzmin_zdolnosci_emocji wiedzmin_zdolnosci_emocji)
    {
        retrofitservice rts = new retrofitservice();
        emocjaApi emocjaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.emocjaApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

        wiedzmin_zdolnosci_emocji.setId_karta(sessionstorage.getInt("idkarty",0));
        emocjaApi.getall(wiedzmin_zdolnosci_emocji).enqueue(new Callback<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_emocji>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_emocji>> call, Response<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_emocji>> response) {
                if (response.body().isEmpty())
                {
                    saveemocje(wiedzmin_zdolnosci_emocji);
                }
                else {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.putInt("idemocji",response.body().get(0).getId());
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_emocji>> call, Throwable t) {
                Toast.makeText(umEmocjePostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void updatekarta(wiedzmin_karta wiedzmin_karta)
    {
        retrofitservice rts = new retrofitservice();
        kartaApi kartaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.kartaApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_karta.setId(sessionstorage.getInt("idkarty",0));
        wiedzmin_karta.setId_emocji(sessionstorage.getInt("idemocji",0));

        kartaApi.updateemocji(wiedzmin_karta).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(umEmocjePostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_um_emocje_postaci);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

        dozdolnoscifachu = findViewById(R.id.dofachu);
        zapisz = findViewById(R.id.zapisemocje);
        amory = findViewById(R.id.amory);
        empatia = findViewById(R.id.empatia);
        hazard = findViewById(R.id.Hazard);
        oszustwo = findViewById(R.id.oszustwo);
        perswazja = findViewById(R.id.perswazja);
        przywodztwo = findViewById(R.id.przywodztwo);
        styl = findViewById(R.id.editTextNumber10);
        sztuka = findViewById(R.id.sztuka);
        urok = findViewById(R.id.urok);
        wystepy = findViewById(R.id.wystepy);

        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wiedzmin_zdolnosci_emocji wiedzmin_zdolnosci_emocji = new wiedzmin_zdolnosci_emocji();
                wiedzmin_zdolnosci_emocji.setId_karta(sessionstorage.getInt("idkarty",0));
                getall(wiedzmin_zdolnosci_emocji);

                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        wiedzmin_karta karta = new wiedzmin_karta();
                        karta.setId(sessionstorage.getInt("idkarty",0));
                        karta.setId_emocji(sessionstorage.getInt("idemocji",0));
                        updatekarta(karta);
                    }
                },300);
                i++;
            }
        });

        dozdolnoscifachu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i==0)
                {
                    Toast.makeText(umEmocjePostaci.this, "Proszę naciśnij przycisk zapisz", Toast.LENGTH_SHORT).show();
                }
                else if (i <= 1)
                {
                    Toast.makeText(umEmocjePostaci.this, "Proszę naciśnij przycisk ZAPISZ jeszcze raz", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(umEmocjePostaci.this, umFachPostaci.class);
                    wiedzmin_zdolnosci_emocji wiedzmin_zdolnosci_emocji = new wiedzmin_zdolnosci_emocji();
                    getall(wiedzmin_zdolnosci_emocji);
                    Toast.makeText(umEmocjePostaci.this, String.valueOf(sessionstorage.getInt("idkarty",0)), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }

        });
    }
}