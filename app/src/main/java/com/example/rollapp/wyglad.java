package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rollapp.model.charakter;
import com.example.rollapp.model.wiedzmin_karta;
import com.example.rollapp.retrofit.kartaApi;
import com.example.rollapp.retrofit.retrofitservice;
import com.example.rollapp.retrofit.wygladApi;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class wyglad extends AppCompatActivity {

    private EditText wygladd;
    private EditText ozdoby;
    private EditText ubranie;

    private Button zapiszwyglad;

    private Button next;

    private static final String SHERED_PREFS = "daneuzyt";

    private int i=0;

    public void czyjestwyglad(com.example.rollapp.model.wyglad wyglad)
    {
        retrofitservice rts = new retrofitservice();
        wygladApi wygladApi = rts.getRetrofit().create(com.example.rollapp.retrofit.wygladApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

        wyglad.setId_karty(sessionstorage.getInt("idkarty",0));

        wygladApi.czyjest(wyglad).enqueue(new Callback<ArrayList<charakter>>() {
            @Override
            public void onResponse(Call<ArrayList<charakter>> call, Response<ArrayList<charakter>> response) {
                if (response.body().isEmpty())
                {
                    savewyglad(wyglad);
                }
                else {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.putInt("idwyglad",response.body().get(0).getId());
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<charakter>> call, Throwable t) {
                Toast.makeText(wyglad.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    public void savewyglad(com.example.rollapp.model.wyglad wyglad)
    {
        if (wygladd.getText().toString().isEmpty()||
                ozdoby.getText().toString().isEmpty()||
                ubranie.getText().toString().isEmpty())
        {
            Toast.makeText(com.example.rollapp.wyglad.this, "Pola nie mogą być puste", Toast.LENGTH_SHORT).show();
        } else {
            if (100<wygladd.getText().toString().length()||
                    100<ozdoby.getText().toString().length()||
                    100<ubranie.getText().toString().length())
            {
                Toast.makeText(com.example.rollapp.wyglad.this, "Wszytkie dane nie mogą przekraczać 100 znaków", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                wygladApi wygladApi = rts.getRetrofit().create(com.example.rollapp.retrofit.wygladApi.class);
                SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

                wyglad.setId_karty(sessionstorage.getInt("idkarty",0));
                wyglad.setUbranie(ubranie.getText().toString());
                wyglad.setWlosy(wygladd.getText().toString());
                wyglad.setOzdoby(ozdoby.getText().toString());
                wyglad.setKoniec(0);

                wygladApi.save(wyglad).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(wyglad.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    private void updatekarte(wiedzmin_karta wiedzmin_karta)
    {
        retrofitservice rts = new retrofitservice();
        kartaApi kartaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.kartaApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

        wiedzmin_karta.setId(sessionstorage.getInt("idkarty",0));
        wiedzmin_karta.setId_wyglad(sessionstorage.getInt("idwyglad",0));
        kartaApi.updatewyglad(wiedzmin_karta).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(wyglad.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyglad);


        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wygladd = findViewById(R.id.editTextTextMultiLine2);
        ozdoby = findViewById(R.id.editTextTextMultiLine3);
        ubranie = findViewById(R.id.editTextTextMultiLine4);

        zapiszwyglad = findViewById(R.id.button);

        next = findViewById(R.id.dochara);

        zapiszwyglad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.rollapp.model.wyglad wyglad = new com.example.rollapp.model.wyglad();
                czyjestwyglad(wyglad);

                wiedzmin_karta wiedzmin_karta = new wiedzmin_karta();
                updatekarte(wiedzmin_karta);
                i++;
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i==0)
                {
                    Toast.makeText(wyglad.this, "Proszę naciśnij przycisk zapisz", Toast.LENGTH_SHORT).show();

                }
                else if(i<=4)
                {
                    Toast.makeText(wyglad.this, "Proszę naciśnij przycisk ZAPISZ jeszcze raz", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(wyglad.this, charakter2.class);
                    startActivity(intent);
                }
            }

        });
    }
}