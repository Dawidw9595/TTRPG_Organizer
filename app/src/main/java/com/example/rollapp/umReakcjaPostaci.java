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
import com.example.rollapp.model.wiedzmin_zdolnosci_ciala;
import com.example.rollapp.model.wiedzmin_zdolnosci_reakcji;
import com.example.rollapp.retrofit.kartaApi;
import com.example.rollapp.retrofit.reakcjaApi;
import com.example.rollapp.retrofit.retrofitservice;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class umReakcjaPostaci extends AppCompatActivity {

    private EditText bojka;

    private EditText bron_drzewcowa;

    private EditText bron_bitewna;

    private EditText bron_krotka;

    private EditText jezdziectwo;

    private EditText szermierka;

    private EditText zeglarstwo;

    private EditText zwinnosc;

    Button dozdolnoscirozumu;

    Button zapisz;

    private static final String SHERED_PREFS = "daneuzyt";

    private Integer i=0;

    private void savereakcja(wiedzmin_zdolnosci_reakcji wiedzmin_zdolnosci_reakcji)
    {
        if (bojka.getText().toString().isEmpty() ||
                bron_drzewcowa.getText().toString().isEmpty() ||
                bron_bitewna.getText().toString().isEmpty() ||
                bron_krotka.getText().toString().isEmpty() ||
                jezdziectwo.getText().toString().isEmpty() ||
                szermierka.getText().toString().isEmpty() ||
                zeglarstwo.getText().toString().isEmpty() ||
                zwinnosc.getText().toString().isEmpty() )
        {
            Toast.makeText(umReakcjaPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2<bojka.getText().toString().length() ||
                    2<bron_drzewcowa.getText().toString().length() ||
                    2<bron_bitewna.getText().toString().length() ||
                    2<bron_krotka.getText().toString().length() ||
                    2<jezdziectwo.getText().toString().length() ||
                    2<szermierka.getText().toString().length() ||
                    2<zeglarstwo.getText().toString().length() ||
                    2<zwinnosc.getText().toString().length())
            {
                Toast.makeText(umReakcjaPostaci.this, "Wszystkie cechy nie mogą mieć więcej niż 2 cyfry", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                reakcjaApi reakcjaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.reakcjaApi.class);


                wiedzmin_zdolnosci_reakcji.setBojka(Integer.valueOf(bojka.getText().toString()));
                wiedzmin_zdolnosci_reakcji.setBron_bitewna(Integer.valueOf(bron_drzewcowa.getText().toString()));
                wiedzmin_zdolnosci_reakcji.setBron_drzewcowa(Integer.valueOf(bron_bitewna.getText().toString()));
                wiedzmin_zdolnosci_reakcji.setBron_krotka(Integer.valueOf(bron_krotka.getText().toString()));
                wiedzmin_zdolnosci_reakcji.setJezdziectwo(Integer.valueOf(jezdziectwo.getText().toString()));
                wiedzmin_zdolnosci_reakcji.setSzermierka(Integer.valueOf(szermierka.getText().toString()));
                wiedzmin_zdolnosci_reakcji.setZeglarstwo(Integer.valueOf(zeglarstwo.getText().toString()));
                wiedzmin_zdolnosci_reakcji.setZwinnosc(Integer.valueOf(zwinnosc.getText().toString()));


                reakcjaApi.save(wiedzmin_zdolnosci_reakcji).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(umReakcjaPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    private void getall(wiedzmin_zdolnosci_reakcji wiedzmin_zdolnosci_reakcji)
    {
        retrofitservice rts = new retrofitservice();
        reakcjaApi reakcjaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.reakcjaApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_zdolnosci_reakcji.setId_karta(sessionstorage.getInt("idkarty",0));

        reakcjaApi.getall(wiedzmin_zdolnosci_reakcji).enqueue(new Callback<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_reakcji>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_reakcji>> call, Response<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_reakcji>> response) {
                if (response.body().isEmpty())
                {
                    savereakcja(wiedzmin_zdolnosci_reakcji);
                }else {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.putInt("idreakcji",response.body().get(0).getId());
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_reakcji>> call, Throwable t) {
                Toast.makeText(umReakcjaPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
        wiedzmin_karta.setId_reakcji(sessionstorage.getInt("idreakcji",0));
        kartaApi.updatereakcja(wiedzmin_karta).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(umReakcjaPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void getreakcja(wiedzmin_zdolnosci_reakcji wiedzmin_zdolnosci_reakcji)
    {
        retrofitservice rts = new retrofitservice();
        reakcjaApi reakcjaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.reakcjaApi.class);
        reakcjaApi.getall(wiedzmin_zdolnosci_reakcji).enqueue(new Callback<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_reakcji>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_reakcji>> call, Response<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_reakcji>> response) {
                bojka.setText(String.valueOf(response.body().get(0).getBojka()));
                bron_drzewcowa.setText(String.valueOf(response.body().get(0).getBron_drzewcowa()));
                bron_bitewna.setText(String.valueOf(response.body().get(0).getBron_bitewna()));
                bron_krotka.setText(String.valueOf(response.body().get(0).getBron_krotka()));
                jezdziectwo.setText(String.valueOf(response.body().get(0).getJezdziectwo()));
                szermierka.setText(String.valueOf(response.body().get(0).getSzermierka()));
                zeglarstwo.setText(String.valueOf(response.body().get(0).getZeglarstwo()));
                zwinnosc.setText(String.valueOf(response.body().get(0).getZwinnosc()));
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_reakcji>> call, Throwable t) {
                Toast.makeText(umReakcjaPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void modyfikuj(wiedzmin_zdolnosci_reakcji wiedzmin_zdolnosci_reakcji)
    {
        if (bojka.getText().toString().isEmpty() ||
                bron_drzewcowa.getText().toString().isEmpty() ||
                bron_bitewna.getText().toString().isEmpty() ||
                bron_krotka.getText().toString().isEmpty() ||
                jezdziectwo.getText().toString().isEmpty() ||
                szermierka.getText().toString().isEmpty() ||
                zeglarstwo.getText().toString().isEmpty() ||
                zwinnosc.getText().toString().isEmpty() )
        {
            Toast.makeText(umReakcjaPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2<bojka.getText().toString().length() ||
                    2<bron_drzewcowa.getText().toString().length() ||
                    2<bron_bitewna.getText().toString().length() ||
                    2<bron_krotka.getText().toString().length() ||
                    2<jezdziectwo.getText().toString().length() ||
                    2<szermierka.getText().toString().length() ||
                    2<zeglarstwo.getText().toString().length() ||
                    2<zwinnosc.getText().toString().length())
            {
                Toast.makeText(umReakcjaPostaci.this, "Wszystkie cechy nie mogą mieć więcej niż 2 cyfry", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                reakcjaApi reakcjaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.reakcjaApi.class);

                i++;

                wiedzmin_zdolnosci_reakcji.setBojka(Integer.valueOf(bojka.getText().toString()));
                wiedzmin_zdolnosci_reakcji.setBron_bitewna(Integer.valueOf(bron_drzewcowa.getText().toString()));
                wiedzmin_zdolnosci_reakcji.setBron_drzewcowa(Integer.valueOf(bron_bitewna.getText().toString()));
                wiedzmin_zdolnosci_reakcji.setBron_krotka(Integer.valueOf(bron_krotka.getText().toString()));
                wiedzmin_zdolnosci_reakcji.setJezdziectwo(Integer.valueOf(jezdziectwo.getText().toString()));
                wiedzmin_zdolnosci_reakcji.setSzermierka(Integer.valueOf(szermierka.getText().toString()));
                wiedzmin_zdolnosci_reakcji.setZeglarstwo(Integer.valueOf(zeglarstwo.getText().toString()));
                wiedzmin_zdolnosci_reakcji.setZwinnosc(Integer.valueOf(zwinnosc.getText().toString()));


                reakcjaApi.modyfikuj(wiedzmin_zdolnosci_reakcji).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(umReakcjaPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_um_reakcja_postaci);

        dozdolnoscirozumu = findViewById(R.id.dorozumu);
        zapisz = findViewById(R.id.zapiszreakcje);
        bojka = findViewById(R.id.kaltwy);
        bron_drzewcowa = findViewById(R.id.lamanie_magii);
        bron_bitewna = findViewById(R.id.nieugietosc);
        bron_krotka = findViewById(R.id.Odawaga);
        jezdziectwo = findViewById(R.id.rytualy);
        szermierka = findViewById(R.id.zaklecia);
        zeglarstwo = findViewById(R.id.zeglarstwo);
        zwinnosc = findViewById(R.id.zwinnosc);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

        if (sessionstorage.getString("modyfikajca","")=="")
        {
            zapisz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wiedzmin_zdolnosci_reakcji wiedzmin_zdolnosci_reakcji = new wiedzmin_zdolnosci_reakcji();
                    wiedzmin_zdolnosci_reakcji.setId(sessionstorage.getInt("idkarty",0));
                    getall(wiedzmin_zdolnosci_reakcji);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            wiedzmin_karta wiedzmin_karta = new wiedzmin_karta();
                            wiedzmin_karta.setId(sessionstorage.getInt("idkarty",0));
                            wiedzmin_karta.setId_reakcji(sessionstorage.getInt("idreakcji",0));
                            updatekarta(wiedzmin_karta);
                        }
                    },300);
                    i++;
                }
            });

            dozdolnoscirozumu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (i==0)
                    {
                        Toast.makeText(umReakcjaPostaci.this, "Proszę naciśnij przycisk zapisz", Toast.LENGTH_SHORT).show();
                    }
                    else if (i <= 1)
                    {
                        Toast.makeText(umReakcjaPostaci.this, "Proszę naciśnij przycisk ZAPISZ jeszcze raz", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(umReakcjaPostaci.this, umRozumPostaci.class);
                        wiedzmin_zdolnosci_reakcji wiedzmin_zdolnosci_reakcji = new wiedzmin_zdolnosci_reakcji();
                        getall(wiedzmin_zdolnosci_reakcji);
                        Toast.makeText(umReakcjaPostaci.this, String.valueOf(sessionstorage.getInt("idkarty",0)), Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                }

            });
        }else {
            wiedzmin_zdolnosci_reakcji wiedzmin_zdolnosci_reakcji= new wiedzmin_zdolnosci_reakcji();
            wiedzmin_zdolnosci_reakcji.setId_karta(sessionstorage.getInt("id_karty",1));
            getreakcja(wiedzmin_zdolnosci_reakcji);
            dozdolnoscirozumu.setText("Modyfikuj");
            zapisz.setVisibility(View.GONE);

            dozdolnoscirozumu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i==0)
                    {
                        modyfikuj(wiedzmin_zdolnosci_reakcji);
                        Toast.makeText(umReakcjaPostaci.this, "Proszę naciśnij modyfikuj jeszcze raz", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(umReakcjaPostaci.this,postacmenu.class);
                                startActivity(intent);
                            }
                        },400);
                    }
                }
            });
        }
    }
}