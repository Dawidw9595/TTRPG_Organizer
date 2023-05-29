package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rollapp.model.wiedzmin_bron;
import com.example.rollapp.model.wiedzmin_cechy;
import com.example.rollapp.model.wiedzmin_karta;
import com.example.rollapp.retrofit.bronApi;
import com.example.rollapp.retrofit.cechaApi;
import com.example.rollapp.retrofit.kartaApi;
import com.example.rollapp.retrofit.retrofitservice;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class bronPostaci extends AppCompatActivity {

    private EditText celnosc;

    private EditText dyskrecja;

    private EditText efekty;

    private EditText nazwa;

    private EditText obrazenia;

    private EditText recznosc;

    private EditText trwalosc;

    private EditText zasieg;

    private EditText wzmocnienia;

    private Button zapiszbron;

    private Button przejdzpancerz;

    private static final String SHERED_PREFS = "daneuzyt";

    private int i=0;

    private void getall(wiedzmin_bron wiedzmin_bron)
    {
        retrofitservice rts = new retrofitservice();
        bronApi bronApi = rts.getRetrofit().create(com.example.rollapp.retrofit.bronApi.class);
        bronApi.czyjest(wiedzmin_bron).enqueue(new Callback<ArrayList<wiedzmin_bron>>() {
            @Override
            public void onResponse(Call<ArrayList<wiedzmin_bron>> call, Response<ArrayList<wiedzmin_bron>> response) {
                if (response.body().isEmpty())
                {
                    savebron(wiedzmin_bron);
                }
                else {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.putInt("idbroni",response.body().get(0).getId());
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<wiedzmin_bron>> call, Throwable t) {
                Toast.makeText(bronPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void savebron(wiedzmin_bron wiedzmin_bron)
    {
        if (celnosc.getText().toString().isEmpty() ||
                dyskrecja.getText().toString().isEmpty() ||
                efekty.getText().toString().isEmpty() ||
                nazwa.getText().toString().isEmpty() ||
                obrazenia.getText().toString().isEmpty() ||
                recznosc.getText().toString().isEmpty() ||
                trwalosc.getText().toString().isEmpty() ||
                wzmocnienia.getText().toString().isEmpty() ||
                zasieg.getText().toString().isEmpty())
        {
            Toast.makeText(bronPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (20<celnosc.getText().toString().length() ||
                    20<dyskrecja.getText().toString().length() ||
                    20<efekty.getText().toString().length() ||
                    20<nazwa.getText().toString().length() ||
                    20<obrazenia.getText().toString().length() ||
                    20<recznosc.getText().toString().length() ||
                    20<trwalosc.getText().toString().length() ||
                    20<wzmocnienia.getText().toString().length() ||
                    20<zasieg.getText().toString().length() )
            {
                Toast.makeText(bronPostaci.this, "Wszystkie statystyki nie moga mieć więcej niż 20 znaków ", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                bronApi bronApi = rts.getRetrofit().create(com.example.rollapp.retrofit.bronApi.class);

                SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

                wiedzmin_bron.setCelnosc(celnosc.getText().toString());
                wiedzmin_bron.setDyskrecja(dyskrecja.getText().toString());
                wiedzmin_bron.setEfekty(efekty.getText().toString());
                wiedzmin_bron.setNazwa(nazwa.getText().toString());
                wiedzmin_bron.setObrazenia(obrazenia.getText().toString());
                wiedzmin_bron.setRecznosc(Integer.valueOf(recznosc.getText().toString()));
                wiedzmin_bron.setTrwalosc(Integer.valueOf(trwalosc.getText().toString()));
                wiedzmin_bron.setWzmocnienia(Integer.valueOf(wzmocnienia.getText().toString()));
                wiedzmin_bron.setZasieg(zapiszbron.getText().toString());
                wiedzmin_bron.setId_karty(Integer.valueOf(sessionstorage.getInt("idkarty",0)));

                bronApi.save(wiedzmin_bron).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(bronPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    private void mody(wiedzmin_bron wiedzmin_bron)
    {
        if (celnosc.getText().toString().isEmpty() ||
                dyskrecja.getText().toString().isEmpty() ||
                efekty.getText().toString().isEmpty() ||
                nazwa.getText().toString().isEmpty() ||
                obrazenia.getText().toString().isEmpty() ||
                recznosc.getText().toString().isEmpty() ||
                trwalosc.getText().toString().isEmpty() ||
                wzmocnienia.getText().toString().isEmpty() ||
                zasieg.getText().toString().isEmpty())
        {
            Toast.makeText(bronPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (20<celnosc.getText().toString().length() ||
                    20<dyskrecja.getText().toString().length() ||
                    20<efekty.getText().toString().length() ||
                    20<nazwa.getText().toString().length() ||
                    20<obrazenia.getText().toString().length() ||
                    20<recznosc.getText().toString().length() ||
                    20<trwalosc.getText().toString().length() ||
                    20<wzmocnienia.getText().toString().length() ||
                    20<zasieg.getText().toString().length() )
            {
                Toast.makeText(bronPostaci.this, "Wszystkie statystyki nie moga mieć więcej niż 20 znaków ", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                bronApi bronApi = rts.getRetrofit().create(com.example.rollapp.retrofit.bronApi.class);

                SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

                wiedzmin_bron.setCelnosc(celnosc.getText().toString());
                wiedzmin_bron.setDyskrecja(dyskrecja.getText().toString());
                wiedzmin_bron.setEfekty(efekty.getText().toString());
                wiedzmin_bron.setNazwa(nazwa.getText().toString());
                wiedzmin_bron.setObrazenia(obrazenia.getText().toString());
                wiedzmin_bron.setRecznosc(Integer.valueOf(recznosc.getText().toString()));
                wiedzmin_bron.setTrwalosc(Integer.valueOf(trwalosc.getText().toString()));
                wiedzmin_bron.setWzmocnienia(Integer.valueOf(wzmocnienia.getText().toString()));
                wiedzmin_bron.setZasieg(zapiszbron.getText().toString());
                wiedzmin_bron.setId_karty(Integer.valueOf(sessionstorage.getInt("idkarty",0)));

                bronApi.mody(wiedzmin_bron).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(bronPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    private void updatekarta(wiedzmin_karta wiedzmin_karta)
    {
        retrofitservice rts = new retrofitservice();
        kartaApi kartaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.kartaApi.class);
        kartaApi.updatebron(wiedzmin_karta).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(bronPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bron_postaci);

        celnosc = findViewById(R.id.uszkodzeniaglowa);
        dyskrecja = findViewById(R.id.uszkodzeniakorpus);
        efekty = findViewById(R.id.uszkodzenialnoga);
        nazwa = findViewById(R.id.uszkodzenialreka);
        obrazenia = findViewById(R.id.wartoscpnoga);
        recznosc = findViewById(R.id.uszkodzeniapreka);
        trwalosc = findViewById(R.id.trwalosc);
        zasieg = findViewById(R.id.zasieg);
        wzmocnienia = findViewById(R.id.wzmocnienia);
        zapiszbron = findViewById(R.id.zapis_statystyki_bron);
        przejdzpancerz = findViewById(R.id.zapiszbron);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        SharedPreferences.Editor editor = sessionstorage.edit();

        zapiszbron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wiedzmin_bron wiedzmin_bron = new wiedzmin_bron();
                wiedzmin_bron.setId_karty(sessionstorage.getInt("idkarty",1));
                getall(wiedzmin_bron);
                mody(wiedzmin_bron);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        wiedzmin_karta karta = new wiedzmin_karta();
                        karta.setId(sessionstorage.getInt("idkarty",0));
                        karta.setId_broni(sessionstorage.getInt("idbroni",0));
                        updatekarta(karta);
                    }
                },300);
                i++;
            }
        });

        przejdzpancerz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i==0)
                {
                    Toast.makeText(bronPostaci.this, "Proszę naciśnij przycisk zapisz", Toast.LENGTH_SHORT).show();
                }
                else if (i<=1)
                {
                    Toast.makeText(bronPostaci.this, "Proszę naciśnij przycisk ZAPISZ jeszcze raz", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(bronPostaci.this, stronaglowna.class);
                    wiedzmin_bron cechy =new wiedzmin_bron();
                    getall(cechy);
                    startActivity(intent);
                }
            }
        });
    }
}