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
import com.example.rollapp.retrofit.charakterApi;
import com.example.rollapp.retrofit.retrofitservice;
import com.example.rollapp.retrofit.wygladApi;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class charakter2 extends AppCompatActivity {

    private EditText najceni;
    private EditText njaoso;
    private EditText oinnych;
    private EditText osobowosc;

    private Button zapiszwyglad;

    private Button next;

    private static final String SHERED_PREFS = "daneuzyt";

    private int i=0;

    private void update(com.example.rollapp.model.charakter charakter)
    {
        if(najceni.getText().toString().isEmpty()||
                njaoso.getText().toString().isEmpty()||
                oinnych.getText().toString().isEmpty()||
                osobowosc.getText().toString().isEmpty())
        {
            Toast.makeText(com.example.rollapp.charakter2.this, "Pola nie mogą być puste", Toast.LENGTH_SHORT).show();
        } else {
            if (20<najceni.getText().toString().length()||
                    20<njaoso.getText().toString().length()||
                    20<oinnych.getText().toString().length()||
                    20<osobowosc.getText().toString().length())
            {
                Toast.makeText(com.example.rollapp.charakter2.this, "Wartosci w polach nie mogą przekraczać 20 znków", Toast.LENGTH_SHORT).show();
            }else {
                retrofitservice rts = new retrofitservice();
                charakterApi charakterApi = rts.getRetrofit().create(com.example.rollapp.retrofit.charakterApi.class);
                SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                charakter.setId(sessionstorage.getInt("idcharakter",0));
                charakter.setNajbardziej_ceni(najceni.getText().toString());
                charakter.setNajwazniejsza_osoba(njaoso.getText().toString());
                charakter.setO_innych(oinnych.getText().toString());
                charakter.setOsobowosc(osobowosc.getText().toString());
                charakterApi.update(charakter).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(charakter2.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charakter);

        najceni = findViewById(R.id.najbardziejceni);
        njaoso = findViewById(R.id.najwazniejszaosoba);
        oinnych = findViewById(R.id.oinnych);
        osobowosc = findViewById(R.id.osobowosc);

        zapiszwyglad = findViewById(R.id.zapiszcharakter);
        next = findViewById(R.id.dociala);

        zapiszwyglad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.rollapp.model.charakter charakter = new com.example.rollapp.model.charakter();
                update(charakter);
                i++;
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (i==0)
                    {
                        Toast.makeText(charakter2.this, "Proszę naciśnij przycisk zapisz", Toast.LENGTH_SHORT).show();

                    }
                    else if(i<=2)
                    {
                        Toast.makeText(charakter2.this, "Proszę naciśnij przycisk ZAPISZ jeszcze raz", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(charakter2.this, wydarzenia.class);
                        startActivity(intent);
                    }
                }
        });

    }
}