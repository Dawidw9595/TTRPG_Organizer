package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rollapp.model.postac;
import com.example.rollapp.model.wiedzmin_cechy;
import com.example.rollapp.model.wiedzmin_karta;
import com.example.rollapp.retrofit.cechaApi;
import com.example.rollapp.retrofit.kartaApi;
import com.example.rollapp.retrofit.postacApi;
import com.example.rollapp.retrofit.retrofitservice;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class cechyPostaci extends AppCompatActivity {
    Button doZdolnosciCiala;

    Button zapisz;

    private EditText cialo;
    private EditText fach;
    private EditText fart;
    private EditText gracja;
    private EditText reakcja;
    private EditText rozum;
    private EditText tempo;
    private EditText wola;

    private Integer i=0;

    private static final String SHERED_PREFS = "daneuzyt";

    private void savecechy(wiedzmin_cechy wiedzmin_cechy)
    {
        if (cialo.getText().toString().isEmpty() ||
                fach.getText().toString().isEmpty() ||
                fart.getText().toString().isEmpty() ||
                gracja.getText().toString().isEmpty() ||
                reakcja.getText().toString().isEmpty() ||
                rozum.getText().toString().isEmpty() ||
                tempo.getText().toString().isEmpty() ||
                wola.getText().toString().isEmpty())
        {
            Toast.makeText(cechyPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2<cialo.getText().toString().length() ||
                    2<fach.getText().toString().length() ||
                    2<fart.getText().toString().length() ||
                    2<gracja.getText().toString().length() ||
                    2<reakcja.getText().toString().length() ||
                    2<rozum.getText().toString().length() ||
                    2<tempo.getText().toString().length() ||
                    2<wola.getText().toString().length() )
            {
                Toast.makeText(cechyPostaci.this, "Wszystkie umiejętności nie moga mieć więcej niż 2 cyfry", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                cechaApi cechaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.cechaApi.class);

                wiedzmin_cechy.setCialo(Integer.valueOf(cialo.getText().toString()));
                wiedzmin_cechy.setFach(Integer.valueOf(fach.getText().toString()));
                wiedzmin_cechy.setFart(Integer.valueOf(fart.getText().toString()));
                wiedzmin_cechy.setGracja(Integer.valueOf(gracja.getText().toString()));
                wiedzmin_cechy.setReakcja(Integer.valueOf(reakcja.getText().toString()));
                wiedzmin_cechy.setRozum(Integer.valueOf(rozum.getText().toString()));
                wiedzmin_cechy.setTempo(Integer.valueOf(tempo.getText().toString()));
                wiedzmin_cechy.setWola(Integer.valueOf(wola.getText().toString()));

                cechaApi.save(wiedzmin_cechy).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(cechyPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });

            }
        }
    }

    private void getall(wiedzmin_cechy wiedzmin_cechy)
    {
        retrofitservice rts = new retrofitservice();
        cechaApi cechaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.cechaApi.class);
        cechaApi.getall(wiedzmin_cechy).enqueue(new Callback<ArrayList<wiedzmin_cechy>>() {
            @Override
            public void onResponse(Call<ArrayList<wiedzmin_cechy>> call, Response<ArrayList<wiedzmin_cechy>> response) {
                if (response.body().isEmpty())
                {
                    savecechy(wiedzmin_cechy);
                }
                else {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.putInt("idcechy",response.body().get(0).getId());
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<wiedzmin_cechy>> call, Throwable t) {
                Toast.makeText(cechyPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void updatekarta(wiedzmin_karta wiedzmin_karta)
    {
        retrofitservice rts = new retrofitservice();
        kartaApi kartaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.kartaApi.class);
        kartaApi.updatecehca(wiedzmin_karta).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(cechyPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void setByid(wiedzmin_cechy wiedzmin_cechy)
    {
        retrofitservice rts = new retrofitservice();
        cechaApi cechaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.cechaApi.class);
        cechaApi.getallbyid(wiedzmin_cechy).enqueue(new Callback<ArrayList<com.example.rollapp.model.wiedzmin_cechy>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.rollapp.model.wiedzmin_cechy>> call, Response<ArrayList<com.example.rollapp.model.wiedzmin_cechy>> response) {
                cialo.setText(String.valueOf(response.body().get(0).getCialo()));
                fach.setText(String.valueOf(response.body().get(0).getFach()));
                fart.setText(String.valueOf(response.body().get(0).getFart()));
                gracja.setText(String.valueOf(response.body().get(0).getGracja()));
                reakcja.setText(String.valueOf(response.body().get(0).getReakcja()));
                rozum.setText(String.valueOf(response.body().get(0).getRozum()));
                tempo.setText(String.valueOf(response.body().get(0).getTempo()));
                wola.setText(String.valueOf(response.body().get(0).getWola()));
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.rollapp.model.wiedzmin_cechy>> call, Throwable t) {
                Toast.makeText(cechyPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    public void modyfikuj(wiedzmin_cechy wiedzmin_cechy)
    {
        if (cialo.getText().toString().isEmpty() ||
                fach.getText().toString().isEmpty() ||
                fart.getText().toString().isEmpty() ||
                gracja.getText().toString().isEmpty() ||
                reakcja.getText().toString().isEmpty() ||
                rozum.getText().toString().isEmpty() ||
                tempo.getText().toString().isEmpty() ||
                wola.getText().toString().isEmpty())
        {
            Toast.makeText(cechyPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2 < cialo.getText().toString().length() ||
                    2 < fach.getText().toString().length() ||
                    2 < fart.getText().toString().length() ||
                    2 < gracja.getText().toString().length() ||
                    2 < reakcja.getText().toString().length() ||
                    2 < rozum.getText().toString().length() ||
                    2 < tempo.getText().toString().length() ||
                    2 < wola.getText().toString().length()) {
                Toast.makeText(cechyPostaci.this, "Wszystkie umiejętności nie moga mieć więcej niż 2 cyfry", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                cechaApi cechaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.cechaApi.class);

                i++;

                wiedzmin_cechy.setCialo(Integer.valueOf(cialo.getText().toString()));
                wiedzmin_cechy.setFach(Integer.valueOf(fach.getText().toString()));
                wiedzmin_cechy.setFart(Integer.valueOf(fart.getText().toString()));
                wiedzmin_cechy.setGracja(Integer.valueOf(gracja.getText().toString()));
                wiedzmin_cechy.setReakcja(Integer.valueOf(reakcja.getText().toString()));
                wiedzmin_cechy.setRozum(Integer.valueOf(rozum.getText().toString()));
                wiedzmin_cechy.setTempo(Integer.valueOf(tempo.getText().toString()));
                wiedzmin_cechy.setWola(Integer.valueOf(wola.getText().toString()));
                cechaApi.modyfikuj(wiedzmin_cechy).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(cechyPostaci.this, "Problem połączenia z serwerem spróbuj ponownie pózniej !!!", Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE, "Wystapil blad", t);
                    }
                });
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cechy_postaci);

        doZdolnosciCiala = findViewById(R.id.dociala);
        zapisz = findViewById(R.id.zapiszCechy);

        cialo = findViewById(R.id.cialo);
        fach = findViewById(R.id.fach);
        fart = findViewById(R.id.fart);
        gracja = findViewById(R.id.gracja);
        reakcja = findViewById(R.id.reakcja);
        rozum = findViewById(R.id.editTextNumber6);
        tempo = findViewById(R.id.editTextNumber8);
        wola = findViewById(R.id.editTextNumber7);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        SharedPreferences.Editor editor = sessionstorage.edit();


        if (sessionstorage.getString("modyfikajca","") == "")
        {
            zapisz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wiedzmin_cechy cechy =new wiedzmin_cechy();
                    cechy.setId_karty(sessionstorage.getInt("idkarty",0));
                    getall(cechy);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            wiedzmin_karta karta = new wiedzmin_karta();
                            karta.setId(sessionstorage.getInt("idkarty",0));
                            karta.setId_cechy(sessionstorage.getInt("idcechy",0));
                            updatekarta(karta);
                        }
                    },300);
                    i++;
                }
            });
            doZdolnosciCiala.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (i==0)
                    {
                        Toast.makeText(cechyPostaci.this, "Proszę naciśnij przycisk zapisz", Toast.LENGTH_SHORT).show();
                    }
                    else if (i<=1)
                    {
                        Toast.makeText(cechyPostaci.this, "Proszę naciśnij przycisk ZAPISZ jeszcze raz", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(cechyPostaci.this, umCialoPostaci.class);
                        wiedzmin_cechy cechy =new wiedzmin_cechy();
                        getall(cechy);
                        startActivity(intent);
                    }
                }
            });
        } else {
            wiedzmin_cechy wiedzmin_cechy = new wiedzmin_cechy();
            wiedzmin_cechy.setId_karty(sessionstorage.getInt("id_karty",1));
            setByid(wiedzmin_cechy);
            doZdolnosciCiala.setText("Modyfikuj");
            zapisz.setVisibility(View.GONE);
            doZdolnosciCiala.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i==0)
                    {
                        modyfikuj(wiedzmin_cechy);
                        Toast.makeText(cechyPostaci.this, "Proszę naciśnij modyfikuj jeszcze raz", Toast.LENGTH_SHORT).show();

                    } else {
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(cechyPostaci.this,postacmenu.class);
                                startActivity(intent);
                            }
                        },400);
                    }
                }
            });
        }
    }
}