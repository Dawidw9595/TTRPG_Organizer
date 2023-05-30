package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rollapp.model.wiedzmin_cechy;
import com.example.rollapp.model.wiedzmin_karta;
import com.example.rollapp.model.wiedzmin_zdolnosc_fachu;
import com.example.rollapp.model.wiedzmin_zdolnosci_ciala;
import com.example.rollapp.model.wiedzmin_zdolnosci_emocji;
import com.example.rollapp.model.wiedzmin_zdolnosci_gracji;
import com.example.rollapp.model.wiedzmin_zdolnosci_reakcji;
import com.example.rollapp.model.wiedzmin_zdolnosci_rozum;
import com.example.rollapp.model.wiedzmin_zdolnosci_woli;
import com.example.rollapp.model.postac;
import com.example.rollapp.retrofit.cechaApi;
import com.example.rollapp.retrofit.cialoApi;
import com.example.rollapp.retrofit.emocjaApi;
import com.example.rollapp.retrofit.fachApi;
import com.example.rollapp.retrofit.gracjaApi;
import com.example.rollapp.retrofit.kartaApi;
import com.example.rollapp.retrofit.postacApi;
import com.example.rollapp.retrofit.reakcjaApi;
import com.example.rollapp.retrofit.retrofitservice;
import com.example.rollapp.retrofit.rozumApi;
import com.example.rollapp.retrofit.wolaApi;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class umWolaPostaci extends AppCompatActivity {

    private EditText kaltwy;

    private EditText lamanie_magii;

    private EditText nieugietosc;

    private EditText Odawaga;

    private EditText rytualy;

    private EditText zaklecia;

    private EditText zastraszanie;


    private Integer i=0;

    private static final String SHERED_PREFS = "daneuzyt";

    Button zapisz;

    Button zakoncz;

    private void savewola(wiedzmin_zdolnosci_woli wiedzmin_zdolnosci_woli)
    {
        if (kaltwy.getText().toString().isEmpty() ||
                lamanie_magii.getText().toString().isEmpty() ||
                nieugietosc.getText().toString().isEmpty() ||
                Odawaga.getText().toString().isEmpty() ||
                rytualy.getText().toString().isEmpty() ||
                zastraszanie.getText().toString().isEmpty() ||
                zaklecia.getText().toString().isEmpty())
        {
            Toast.makeText(umWolaPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2<kaltwy.getText().toString().length() ||
                    2<lamanie_magii.getText().toString().length() ||
                    2<nieugietosc.getText().toString().length() ||
                    2<Odawaga.getText().toString().length() ||
                    2<rytualy.getText().toString().length() ||
                    2<zastraszanie.getText().toString().length() ||
                    2<zaklecia.getText().toString().length())
            {
                Toast.makeText(umWolaPostaci.this, "Wszystkie cechy nie mogą mieć więcej niż 2 cyfry", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                wolaApi wolaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.wolaApi.class);

                SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

                wiedzmin_zdolnosci_woli.setId_karta(Integer.valueOf(sessionstorage.getInt("idkarty",0)));
                wiedzmin_zdolnosci_woli.setKlatwy(Integer.valueOf(kaltwy.getText().toString()));
                wiedzmin_zdolnosci_woli.setLamanie_magii(Integer.valueOf(lamanie_magii.getText().toString()));
                wiedzmin_zdolnosci_woli.setNieugietosc(Integer.valueOf(nieugietosc.getText().toString()));
                wiedzmin_zdolnosci_woli.setOdwaga(Integer.valueOf(Odawaga.getText().toString()));
                wiedzmin_zdolnosci_woli.setRytualy(Integer.valueOf(rytualy.getText().toString()));
                wiedzmin_zdolnosci_woli.setZaklecia(Integer.valueOf(zaklecia.getText().toString()));
                wiedzmin_zdolnosci_woli.setZastraszanie(Integer.valueOf(zastraszanie.getText().toString()));

                wolaApi.save(wiedzmin_zdolnosci_woli).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(umWolaPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                            Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    private void getall(wiedzmin_zdolnosci_woli wiedzmin_zdolnosci_woli)
    {
        retrofitservice rts = new retrofitservice();
        wolaApi wolaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.wolaApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

        wiedzmin_zdolnosci_woli.setId_karta(sessionstorage.getInt("idkarty",0));
        wolaApi.getall(wiedzmin_zdolnosci_woli).enqueue(new Callback<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_woli>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_woli>> call, Response<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_woli>> response) {
                if (response.body().isEmpty())
                {
                    savewola(wiedzmin_zdolnosci_woli);
                }else {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.putInt("idwoli",response.body().get(0).getId());
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_woli>> call, Throwable t) {
                Toast.makeText(umWolaPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
        wiedzmin_karta.setId_woli(sessionstorage.getInt("idwoli",0));

        kartaApi.updatewola(wiedzmin_karta).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(umWolaPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void getwola(wiedzmin_zdolnosci_woli wiedzmin_zdolnosci_woli)
    {
        retrofitservice rts = new retrofitservice();
        wolaApi wolaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.wolaApi.class);

        wolaApi.getall(wiedzmin_zdolnosci_woli).enqueue(new Callback<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_woli>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_woli>> call, Response<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_woli>> response) {
                kaltwy.setText(String.valueOf(response.body().get(0).getKlatwy()));
                lamanie_magii.setText(String.valueOf(response.body().get(0).getLamanie_magii()));
                nieugietosc.setText(String.valueOf(response.body().get(0).getNieugietosc()));
                Odawaga.setText(String.valueOf(response.body().get(0).getOdwaga()));
                rytualy.setText(String.valueOf(response.body().get(0).getRytualy()));
                zaklecia.setText(String.valueOf(response.body().get(0).getZaklecia()));
                zastraszanie.setText(String.valueOf(response.body().get(0).getZastraszanie()));
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_woli>> call, Throwable t) {
                Toast.makeText(umWolaPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void modyfikuj(wiedzmin_zdolnosci_woli wiedzmin_zdolnosci_woli)
    {
        if (kaltwy.getText().toString().isEmpty() ||
                lamanie_magii.getText().toString().isEmpty() ||
                nieugietosc.getText().toString().isEmpty() ||
                Odawaga.getText().toString().isEmpty() ||
                rytualy.getText().toString().isEmpty() ||
                zastraszanie.getText().toString().isEmpty() ||
                zaklecia.getText().toString().isEmpty())
        {
            Toast.makeText(umWolaPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2<kaltwy.getText().toString().length() ||
                    2<lamanie_magii.getText().toString().length() ||
                    2<nieugietosc.getText().toString().length() ||
                    2<Odawaga.getText().toString().length() ||
                    2<rytualy.getText().toString().length() ||
                    2<zastraszanie.getText().toString().length() ||
                    2<zaklecia.getText().toString().length())
            {
                Toast.makeText(umWolaPostaci.this, "Wszystkie cechy nie mogą mieć więcej niż 2 cyfry", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                wolaApi wolaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.wolaApi.class);

                wiedzmin_zdolnosci_woli.setKlatwy(Integer.valueOf(kaltwy.getText().toString()));
                wiedzmin_zdolnosci_woli.setLamanie_magii(Integer.valueOf(lamanie_magii.getText().toString()));
                wiedzmin_zdolnosci_woli.setNieugietosc(Integer.valueOf(nieugietosc.getText().toString()));
                wiedzmin_zdolnosci_woli.setOdwaga(Integer.valueOf(Odawaga.getText().toString()));
                wiedzmin_zdolnosci_woli.setRytualy(Integer.valueOf(rytualy.getText().toString()));
                wiedzmin_zdolnosci_woli.setZaklecia(Integer.valueOf(zaklecia.getText().toString()));
                wiedzmin_zdolnosci_woli.setZastraszanie(Integer.valueOf(zastraszanie.getText().toString()));

                i++;

                wolaApi.modyfikuj(wiedzmin_zdolnosci_woli).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(umWolaPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_um_wola_postaci);

        zapisz= findViewById(R.id.zapiszreakcje);
        kaltwy= findViewById(R.id.kaltwy);
        lamanie_magii= findViewById(R.id.lamanie_magii);
        nieugietosc= findViewById(R.id.nieugietosc);
        Odawaga= findViewById(R.id.Odawaga);
        rytualy= findViewById(R.id.rytualy);
        zaklecia= findViewById(R.id.zaklecia);
        zastraszanie = findViewById(R.id.zastraszanie);
        zakoncz = findViewById(R.id.zakoncz);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

        if (sessionstorage.getString("modyfikajca","")=="")
        {
            zapisz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wiedzmin_zdolnosci_woli wiedzmin_zdolnosci_woli = new wiedzmin_zdolnosci_woli();
                    wiedzmin_zdolnosci_woli.setId(sessionstorage.getInt("idkarty",0));
                    getall(wiedzmin_zdolnosci_woli);

                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            wiedzmin_karta wiedzmin_karta = new wiedzmin_karta();
                            updatekarta(wiedzmin_karta);
                        }
                    },300);
                    i++;
                }
            });

            zakoncz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i == 0) {
                        Toast.makeText(umWolaPostaci.this, "Proszę naciśnij przycisk zapisz", Toast.LENGTH_SHORT).show();
                    } else if (i <= 1) {
                        Toast.makeText(umWolaPostaci.this, "Proszę naciśnij przycisk ZAPISZ jeszcze raz", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(umWolaPostaci.this, bronPostaci.class);
                        wiedzmin_zdolnosci_woli wiedzmin_zdolnosci_woli = new wiedzmin_zdolnosci_woli();
                        getall(wiedzmin_zdolnosci_woli);
                        startActivity(intent);
                    }
                }
            });
        } else {
            wiedzmin_zdolnosci_woli wiedzmin_zdolnosci_woli= new wiedzmin_zdolnosci_woli();
            wiedzmin_zdolnosci_woli.setId_karta(sessionstorage.getInt("id_karty",1));
            getwola(wiedzmin_zdolnosci_woli);
            zakoncz.setText("Modyfikuj");
            zapisz.setVisibility(View.GONE);

            zakoncz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i==0)
                    {
                        modyfikuj(wiedzmin_zdolnosci_woli);
                        Toast.makeText(umWolaPostaci.this, "Proszę naciśnij modyfikuj jeszcze raz", Toast.LENGTH_SHORT).show();
                        postac postac = new postac();
                    }
                    else {
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(umWolaPostaci.this,postacmenu.class);
                                startActivity(intent);
                            }
                        },400);
                    }
                }
            });
        }


    }
}