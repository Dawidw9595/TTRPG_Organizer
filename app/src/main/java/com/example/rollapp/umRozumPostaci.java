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
import com.example.rollapp.model.wiedzmin_zdolnosci_rozum;
import com.example.rollapp.retrofit.cialoApi;
import com.example.rollapp.retrofit.kartaApi;
import com.example.rollapp.retrofit.reakcjaApi;
import com.example.rollapp.retrofit.retrofitservice;
import com.example.rollapp.retrofit.rozumApi;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class umRozumPostaci extends AppCompatActivity {

    private EditText czujnosc;

    private EditText dedukcja;

    private EditText interesy;

    private EditText j_krasnoludzki;

    private EditText j_starsza_mowa;

    private EditText j_wspolny;

    private EditText miastowy;

    private EditText nauczanie;

    private EditText obycie;

    private EditText strategia;

    private EditText sztukaprzetrwania;

    private EditText wiedz_o_poworach;

    private EditText wyksztalcenie;

    Button dozdolnosciwoli;

    Button zapisz;

    private Integer i=0;

    private static final String SHERED_PREFS = "daneuzyt";


    private void saverozum(wiedzmin_zdolnosci_rozum wiedzmin_zdolnosci_rozum)
    {
        if (czujnosc.getText().toString().isEmpty() ||
                dedukcja.getText().toString().isEmpty() ||
                interesy.getText().toString().isEmpty() ||
                j_krasnoludzki.getText().toString().isEmpty() ||
                j_starsza_mowa.getText().toString().isEmpty() ||
                j_wspolny.getText().toString().isEmpty() ||
                miastowy.getText().toString().isEmpty() ||
                nauczanie.getText().toString().isEmpty() ||
                obycie.getText().toString().isEmpty() ||
                strategia.getText().toString().isEmpty() ||
                sztukaprzetrwania.getText().toString().isEmpty() ||
                wiedz_o_poworach.getText().toString().isEmpty() ||
                wyksztalcenie.getText().toString().isEmpty())
        {
            Toast.makeText(umRozumPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2<czujnosc.getText().toString().length() ||
                    2<dedukcja.getText().toString().length() ||
                    2<interesy.getText().toString().length() ||
                    2<j_krasnoludzki.getText().toString().length() ||
                    2<j_starsza_mowa.getText().toString().length() ||
                    2<j_wspolny.getText().toString().length() ||
                    2<miastowy.getText().toString().length() ||
                    2<nauczanie.getText().toString().length() ||
                    2<obycie.getText().toString().length() ||
                    2<strategia.getText().toString().length() ||
                    2<sztukaprzetrwania.getText().toString().length() ||
                    2<wiedz_o_poworach.getText().toString().length() ||
                    2<wyksztalcenie.getText().toString().length())
            {
                Toast.makeText(umRozumPostaci.this, "Wszystkie cechy nie mogą mieć więcej niż 2 cyfry", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                rozumApi rozumApi = rts.getRetrofit().create(com.example.rollapp.retrofit.rozumApi.class);



                wiedzmin_zdolnosci_rozum.setCzujnosc(Integer.valueOf(czujnosc.getText().toString()));
                wiedzmin_zdolnosci_rozum.setDedukcja(Integer.valueOf(dedukcja.getText().toString()));
                wiedzmin_zdolnosci_rozum.setInteresy(Integer.valueOf(interesy.getText().toString()));
                wiedzmin_zdolnosci_rozum.setJ_krasnoludzki(Integer.valueOf(j_krasnoludzki.getText().toString()));
                wiedzmin_zdolnosci_rozum.setJ_starsza_mowa(Integer.valueOf(j_starsza_mowa.getText().toString()));
                wiedzmin_zdolnosci_rozum.setJ_wspolny(Integer.valueOf(j_wspolny.getText().toString()));
                wiedzmin_zdolnosci_rozum.setMiastowy(Integer.valueOf(miastowy.getText().toString()));
                wiedzmin_zdolnosci_rozum.setNauczanie(Integer.valueOf(nauczanie.getText().toString()));
                wiedzmin_zdolnosci_rozum.setObycie(Integer.valueOf(obycie.getText().toString()));
                wiedzmin_zdolnosci_rozum.setStrategia(Integer.valueOf(strategia.getText().toString()));
                wiedzmin_zdolnosci_rozum.setSztuka_przetrwania(Integer.valueOf(sztukaprzetrwania.getText().toString()));
                wiedzmin_zdolnosci_rozum.setWiedz_o_potworach(Integer.valueOf(wiedz_o_poworach.getText().toString()));
                wiedzmin_zdolnosci_rozum.setWyksztalcenie(Integer.valueOf(wyksztalcenie.getText().toString()));


                rozumApi.save(wiedzmin_zdolnosci_rozum).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(umRozumPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    private void getall(wiedzmin_zdolnosci_rozum wiedzmin_zdolnosci_rozum)
    {
        retrofitservice rts = new retrofitservice();
        rozumApi rozumApi = rts.getRetrofit().create(com.example.rollapp.retrofit.rozumApi.class);
        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_zdolnosci_rozum.setId_karta(sessionstorage.getInt("idkarty",0));

        rozumApi.getall(wiedzmin_zdolnosci_rozum).enqueue(new Callback<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_rozum>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_rozum>> call, Response<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_rozum>> response) {
                if (response.body().isEmpty())
                {
                    saverozum(wiedzmin_zdolnosci_rozum);
                }else {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.putInt("idrozumu",response.body().get(0).getId());
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_rozum>> call, Throwable t) {
                Toast.makeText(umRozumPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
        wiedzmin_karta.setId_rozum(sessionstorage.getInt("idrozumu",0));
        kartaApi.updaterozum(wiedzmin_karta).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(umRozumPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void getrozum(wiedzmin_zdolnosci_rozum wiedzmin_zdolnosci_rozum)
    {
        retrofitservice rts = new retrofitservice();
        rozumApi rozumApi = rts.getRetrofit().create(com.example.rollapp.retrofit.rozumApi.class);
        rozumApi.getall(wiedzmin_zdolnosci_rozum).enqueue(new Callback<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_rozum>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_rozum>> call, Response<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_rozum>> response) {
                czujnosc.setText(String.valueOf(response.body().get(0).getCzujnosc()));
                dedukcja.setText(String.valueOf(response.body().get(0).getDedukcja()));
                interesy.setText(String.valueOf(response.body().get(0).getInteresy()));
                j_krasnoludzki.setText(String.valueOf(response.body().get(0).getJ_krasnoludzki()));
                j_starsza_mowa.setText(String.valueOf(response.body().get(0).getJ_starsza_mowa()));
                j_wspolny.setText(String.valueOf(response.body().get(0).getJ_wspolny()));
                miastowy.setText(String.valueOf(response.body().get(0).getMiastowy()));
                nauczanie.setText(String.valueOf(response.body().get(0).getNauczanie()));
                obycie.setText(String.valueOf(response.body().get(0).getObycie()));
                strategia.setText(String.valueOf(response.body().get(0).getStrategia()));
                sztukaprzetrwania.setText(String.valueOf(response.body().get(0).getSztuka_przetrwania()));
                wiedz_o_poworach.setText(String.valueOf(response.body().get(0).getWiedz_o_potworach()));
                wyksztalcenie.setText(String.valueOf(response.body().get(0).getWyksztalcenie()));
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_rozum>> call, Throwable t) {
                Toast.makeText(umRozumPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void modyfikuj(wiedzmin_zdolnosci_rozum wiedzmin_zdolnosci_rozum)
    {
        if (czujnosc.getText().toString().isEmpty() ||
                dedukcja.getText().toString().isEmpty() ||
                interesy.getText().toString().isEmpty() ||
                j_krasnoludzki.getText().toString().isEmpty() ||
                j_starsza_mowa.getText().toString().isEmpty() ||
                j_wspolny.getText().toString().isEmpty() ||
                miastowy.getText().toString().isEmpty() ||
                nauczanie.getText().toString().isEmpty() ||
                obycie.getText().toString().isEmpty() ||
                strategia.getText().toString().isEmpty() ||
                sztukaprzetrwania.getText().toString().isEmpty() ||
                wiedz_o_poworach.getText().toString().isEmpty() ||
                wyksztalcenie.getText().toString().isEmpty())
        {
            Toast.makeText(umRozumPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2<czujnosc.getText().toString().length() ||
                    2<dedukcja.getText().toString().length() ||
                    2<interesy.getText().toString().length() ||
                    2<j_krasnoludzki.getText().toString().length() ||
                    2<j_starsza_mowa.getText().toString().length() ||
                    2<j_wspolny.getText().toString().length() ||
                    2<miastowy.getText().toString().length() ||
                    2<nauczanie.getText().toString().length() ||
                    2<obycie.getText().toString().length() ||
                    2<strategia.getText().toString().length() ||
                    2<sztukaprzetrwania.getText().toString().length() ||
                    2<wiedz_o_poworach.getText().toString().length() ||
                    2<wyksztalcenie.getText().toString().length())
            {
                Toast.makeText(umRozumPostaci.this, "Wszystkie cechy nie mogą mieć więcej niż 2 cyfry", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                rozumApi rozumApi = rts.getRetrofit().create(com.example.rollapp.retrofit.rozumApi.class);

                wiedzmin_zdolnosci_rozum.setCzujnosc(Integer.valueOf(czujnosc.getText().toString()));
                wiedzmin_zdolnosci_rozum.setDedukcja(Integer.valueOf(dedukcja.getText().toString()));
                wiedzmin_zdolnosci_rozum.setInteresy(Integer.valueOf(interesy.getText().toString()));
                wiedzmin_zdolnosci_rozum.setJ_krasnoludzki(Integer.valueOf(j_krasnoludzki.getText().toString()));
                wiedzmin_zdolnosci_rozum.setJ_starsza_mowa(Integer.valueOf(j_starsza_mowa.getText().toString()));
                wiedzmin_zdolnosci_rozum.setJ_wspolny(Integer.valueOf(j_wspolny.getText().toString()));
                wiedzmin_zdolnosci_rozum.setMiastowy(Integer.valueOf(miastowy.getText().toString()));
                wiedzmin_zdolnosci_rozum.setNauczanie(Integer.valueOf(nauczanie.getText().toString()));
                wiedzmin_zdolnosci_rozum.setObycie(Integer.valueOf(obycie.getText().toString()));
                wiedzmin_zdolnosci_rozum.setStrategia(Integer.valueOf(strategia.getText().toString()));
                wiedzmin_zdolnosci_rozum.setSztuka_przetrwania(Integer.valueOf(sztukaprzetrwania.getText().toString()));
                wiedzmin_zdolnosci_rozum.setWiedz_o_potworach(Integer.valueOf(wiedz_o_poworach.getText().toString()));
                wiedzmin_zdolnosci_rozum.setWyksztalcenie(Integer.valueOf(wyksztalcenie.getText().toString()));

                i++;

                rozumApi.modyfikuj(wiedzmin_zdolnosci_rozum).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(umRozumPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_um_rozum_postaci);

        dozdolnosciwoli = findViewById(R.id.dowoli);
        zapisz = findViewById(R.id.zapiswola);
        czujnosc = findViewById(R.id.czujnosc);
        dedukcja = findViewById(R.id.dedukcja);
        interesy = findViewById(R.id.interesy);
        j_krasnoludzki = findViewById(R.id.j_krasnoludzki);
        j_starsza_mowa = findViewById(R.id.j_starsza_mowa);
        j_wspolny = findViewById(R.id.j_wspolny);
        miastowy = findViewById(R.id.miastowy);
        nauczanie = findViewById(R.id.nauczanie);
        obycie = findViewById(R.id.obycie);
        strategia = findViewById(R.id.strategia);
        sztukaprzetrwania = findViewById(R.id.sztukaprzetrwania);
        wiedz_o_poworach = findViewById(R.id.wiedz_o_poworach);
        wyksztalcenie = findViewById(R.id.wyksztalcenie);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

        if (sessionstorage.getString("modyfikajca","")=="")
        {
            zapisz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wiedzmin_zdolnosci_rozum wiedzmin_zdolnosci_rozum = new wiedzmin_zdolnosci_rozum();
                    wiedzmin_zdolnosci_rozum.setId(sessionstorage.getInt("idkarty",0));
                    getall(wiedzmin_zdolnosci_rozum);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            wiedzmin_karta wiedzmin_karta = new wiedzmin_karta();
                            wiedzmin_karta.setId(sessionstorage.getInt("idkarty",0));
                            wiedzmin_karta.setId_rozum(sessionstorage.getInt("idrozumu",0));
                            updatekarta(wiedzmin_karta);
                        }
                    },300);
                    i++;
                }
            });

            dozdolnosciwoli.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (i == 0) {
                        Toast.makeText(umRozumPostaci.this, "Proszę naciśnij przycisk zapisz", Toast.LENGTH_SHORT).show();
                    } else if (i <= 1) {
                        Toast.makeText(umRozumPostaci.this, "Proszę naciśnij przycisk ZAPISZ jeszcze raz", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(umRozumPostaci.this, umWolaPostaci.class);
                        wiedzmin_zdolnosci_rozum wiedzmin_zdolnosci_rozum = new wiedzmin_zdolnosci_rozum();
                        getall(wiedzmin_zdolnosci_rozum);
                        Toast.makeText(umRozumPostaci.this, String.valueOf(sessionstorage.getInt("idkarty",0)), Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                }
            });
        } else {
            wiedzmin_zdolnosci_rozum wiedzmin_zdolnosci_rozum= new wiedzmin_zdolnosci_rozum();
            wiedzmin_zdolnosci_rozum.setId_karta(sessionstorage.getInt("id_karty",1));
            getrozum(wiedzmin_zdolnosci_rozum);
            dozdolnosciwoli.setText("Modyfikuj");
            zapisz.setVisibility(View.GONE);

            dozdolnosciwoli.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i==0)
                    {
                        modyfikuj(wiedzmin_zdolnosci_rozum);
                        Toast.makeText(umRozumPostaci.this, "Proszę naciśnij modyfikuj jeszcze raz", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(umRozumPostaci.this,postacmenu.class);
                                startActivity(intent);
                            }
                        },400);
                    }
                }
            });
        }
    }
}