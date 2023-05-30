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
import com.example.rollapp.retrofit.cialoApi;
import com.example.rollapp.retrofit.kartaApi;
import com.example.rollapp.retrofit.retrofitservice;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class umCialoPostaci extends AppCompatActivity {

    private EditText wytrzymalosc;

    private EditText krzepa;

    private Integer i=0;

    private static final String SHERED_PREFS = "daneuzyt";

    Button dozdolnosciemocji;

    Button zapisz;

    private void savecailo(wiedzmin_zdolnosci_ciala wiedzmin_zdolnosci_ciala)
    {
       if (krzepa.getText().toString().isEmpty() ||
       wytrzymalosc.getText().toString().isEmpty())
       {
           Toast.makeText(umCialoPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
       } else {
           if (2<krzepa.getText().toString().length() ||
           2<wytrzymalosc.getText().toString().length())
           {
               Toast.makeText(umCialoPostaci.this, "Wszystkie cechy nie mogą mieć więcej niż 2 cyfry", Toast.LENGTH_SHORT).show();
           } else {
               retrofitservice rts = new retrofitservice();
               cialoApi cialoApi = rts.getRetrofit().create(com.example.rollapp.retrofit.cialoApi.class);

               wiedzmin_zdolnosci_ciala.setKrzepa(Integer.valueOf(krzepa.getText().toString()));
               wiedzmin_zdolnosci_ciala.setWytrzymalosc(Integer.valueOf(wytrzymalosc.getText().toString()));

               cialoApi.save(wiedzmin_zdolnosci_ciala).enqueue(new Callback<Void>() {
                   @Override
                   public void onResponse(Call<Void> call, Response<Void> response) {

                   }

                   @Override
                   public void onFailure(Call<Void> call, Throwable t) {
                       Toast.makeText(umCialoPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                       Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                   }
               });

           }
       }
    }

    private void getall(wiedzmin_zdolnosci_ciala wiedzmin_zdolnosci_ciala)
    {
        retrofitservice rts = new retrofitservice();
        cialoApi cialoApi = rts.getRetrofit().create(com.example.rollapp.retrofit.cialoApi.class);
        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_zdolnosci_ciala.setId_karta(sessionstorage.getInt("idkarty",0));

        cialoApi.getbyid(wiedzmin_zdolnosci_ciala).enqueue(new Callback<ArrayList<wiedzmin_zdolnosci_ciala>>() {
            @Override
            public void onResponse(Call<ArrayList<wiedzmin_zdolnosci_ciala>> call, Response<ArrayList<wiedzmin_zdolnosci_ciala>> response) {
                if (response.body().isEmpty())
                {
                    savecailo(wiedzmin_zdolnosci_ciala);
                }
                else {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.putInt("idciala",response.body().get(0).getId());
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<wiedzmin_zdolnosci_ciala>> call, Throwable t) {
                Toast.makeText(umCialoPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
        wiedzmin_karta.setId_ciala(sessionstorage.getInt("idciala",0));

        kartaApi.updatecialo(wiedzmin_karta).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(umCialoPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void getcialo(wiedzmin_zdolnosci_ciala wiedzmin_zdolnosci_ciala)
    {
        retrofitservice rts = new retrofitservice();
        cialoApi cialoApi = rts.getRetrofit().create(com.example.rollapp.retrofit.cialoApi.class);
        cialoApi.getbyid(wiedzmin_zdolnosci_ciala).enqueue(new Callback<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_ciala>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_ciala>> call, Response<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_ciala>> response) {
                wytrzymalosc.setText(String.valueOf(response.body().get(0).getWytrzymalosc()));
                krzepa.setText(String.valueOf(response.body().get(0).getKrzepa()));
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_ciala>> call, Throwable t) {
                Toast.makeText(umCialoPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void modyfikuj(wiedzmin_zdolnosci_ciala wiedzmin_zdolnosci_ciala)
    {
        if (krzepa.getText().toString().isEmpty() ||
                wytrzymalosc.getText().toString().isEmpty())
        {
            Toast.makeText(umCialoPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2 < krzepa.getText().toString().length() ||
                    2 < wytrzymalosc.getText().toString().length()) {
                Toast.makeText(umCialoPostaci.this, "Wszystkie cechy nie mogą mieć więcej niż 2 cyfry", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                cialoApi cialoApi = rts.getRetrofit().create(com.example.rollapp.retrofit.cialoApi.class);

                i++;

                wiedzmin_zdolnosci_ciala.setKrzepa(Integer.valueOf(krzepa.getText().toString()));
                wiedzmin_zdolnosci_ciala.setWytrzymalosc(Integer.valueOf(wytrzymalosc.getText().toString()));

                cialoApi.modyfikuj(wiedzmin_zdolnosci_ciala).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(umCialoPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_um_cialo_postaci);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);


        dozdolnosciemocji = findViewById(R.id.doemocji);
        zapisz = findViewById(R.id.zapiscialo);
        wytrzymalosc = findViewById(R.id.wytrzymalosc);
        krzepa = findViewById(R.id.krzepa);

        if (sessionstorage.getString("modyfikajca","")=="")
        {
            zapisz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wiedzmin_zdolnosci_ciala wiedzmin_zdolnosci_ciala = new wiedzmin_zdolnosci_ciala();
                    wiedzmin_zdolnosci_ciala.setId_karta(sessionstorage.getInt("idkarty",0));
                    getall(wiedzmin_zdolnosci_ciala);

                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            wiedzmin_karta karta = new wiedzmin_karta();
                            karta.setId(sessionstorage.getInt("idkarty",0));
                            karta.setId_ciala(sessionstorage.getInt("idciala",0));
                            updatekarta(karta);
                        }
                    },300);
                    i++;
                }
            });

            dozdolnosciemocji.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (i==0)
                    {
                        Toast.makeText(umCialoPostaci.this, "Proszę naciśnij przycisk zapisz", Toast.LENGTH_SHORT).show();
                    }
                    else if (i <= 1)
                    {
                        Toast.makeText(umCialoPostaci.this, "Proszę naciśnij przycisk ZAPISZ jeszcze raz", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(umCialoPostaci.this, umEmocjePostaci.class);
                        wiedzmin_zdolnosci_ciala wiedzmin_zdolnosci_ciala = new wiedzmin_zdolnosci_ciala();
                        getall(wiedzmin_zdolnosci_ciala);
                        startActivity(intent);
                    }
                }

            });
        } else {
            wiedzmin_zdolnosci_ciala wiedzmin_zdolnosci_ciala= new wiedzmin_zdolnosci_ciala();
            wiedzmin_zdolnosci_ciala.setId_karta(sessionstorage.getInt("id_karty",1));
            getcialo(wiedzmin_zdolnosci_ciala);
            dozdolnosciemocji.setText("Modyfikuj");
            zapisz.setVisibility(View.GONE);

            dozdolnosciemocji.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i==0)
                    {
                        modyfikuj(wiedzmin_zdolnosci_ciala);
                        Toast.makeText(umCialoPostaci.this, "Proszę naciśnij modyfikuj jeszcze raz", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(umCialoPostaci.this,postacmenu.class);
                                startActivity(intent);
                            }
                        },400);
                    }
                }
            });
        }
    }
}