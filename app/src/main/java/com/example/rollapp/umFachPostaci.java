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
import com.example.rollapp.model.wiedzmin_zdolnosc_fachu;
import com.example.rollapp.retrofit.fachApi;
import com.example.rollapp.retrofit.kartaApi;
import com.example.rollapp.retrofit.retrofitservice;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class umFachPostaci extends AppCompatActivity {

    private EditText alchemia;

    private EditText charakteryzacja;

    private EditText falszerstwo;

    private EditText optrywanie;

    private EditText pulapki;

    private EditText rzemioslo;

    private EditText wlamania;

    private Integer i=0;

    private static final String SHERED_PREFS = "daneuzyt";

    Button dozdolnoscigracji;

    Button zapisz;

    private void savefach(wiedzmin_zdolnosc_fachu wiedzmin_zdolnosc_fachu )
    {
        if (alchemia.getText().toString().isEmpty() ||
                charakteryzacja.getText().toString().isEmpty() ||
                falszerstwo.getText().toString().isEmpty() ||
                optrywanie.getText().toString().isEmpty() ||
                pulapki.getText().toString().isEmpty() ||
                rzemioslo.getText().toString().isEmpty() ||
                wlamania.getText().toString().isEmpty())
        {
            Toast.makeText(umFachPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2<alchemia.getText().toString().length() ||
                    2<charakteryzacja.getText().toString().length() ||
                    2<falszerstwo.getText().toString().length() ||
                    2<optrywanie.getText().toString().length() ||
                    2<pulapki.getText().toString().length() ||
                    2<rzemioslo.getText().toString().length() ||
                    2<wlamania.getText().toString().length())
            {
                Toast.makeText(umFachPostaci.this, "Wszystkie cechy nie mogą mieć więcej niż 2 cyfry", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                fachApi fachApi = rts.getRetrofit().create(com.example.rollapp.retrofit.fachApi.class);

                wiedzmin_zdolnosc_fachu.setAlchemia(Integer.valueOf(alchemia.getText().toString()));
                wiedzmin_zdolnosc_fachu.setCharakteryzacja(Integer.valueOf(charakteryzacja.getText().toString()));
                wiedzmin_zdolnosc_fachu.setFalszerstwo(Integer.valueOf(falszerstwo.getText().toString()));
                wiedzmin_zdolnosc_fachu.setOpatrywanie(Integer.valueOf(optrywanie.getText().toString()));
                wiedzmin_zdolnosc_fachu.setPulapki(Integer.valueOf(pulapki.getText().toString()));
                wiedzmin_zdolnosc_fachu.setRzemioslo(Integer.valueOf(rzemioslo.getText().toString()));
                wiedzmin_zdolnosc_fachu.setWlamania(Integer.valueOf(wlamania.getText().toString()));

                fachApi.save(wiedzmin_zdolnosc_fachu).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(umFachPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    private void getall(wiedzmin_zdolnosc_fachu wiedzmin_zdolnosc_fachu)
    {
        retrofitservice rts = new retrofitservice();
        fachApi fachApi = rts.getRetrofit().create(com.example.rollapp.retrofit.fachApi.class);
        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_zdolnosc_fachu.setId_karta(sessionstorage.getInt("idkarty",0));
        fachApi.getall(wiedzmin_zdolnosc_fachu).enqueue(new Callback<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosc_fachu>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosc_fachu>> call, Response<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosc_fachu>> response) {
                if (response.body().isEmpty())
                {
                    savefach(wiedzmin_zdolnosc_fachu);
                }else {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.putInt("idfachu",response.body().get(0).getId());
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosc_fachu>> call, Throwable t) {
                Toast.makeText(umFachPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
        wiedzmin_karta.setId_fachu(sessionstorage.getInt("idfachu",0));

        kartaApi.updatefach(wiedzmin_karta).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(umFachPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void getfach(wiedzmin_zdolnosc_fachu wiedzmin_zdolnosc_fachu)
    {
        retrofitservice rts = new retrofitservice();
        fachApi fachApi = rts.getRetrofit().create(com.example.rollapp.retrofit.fachApi.class);
        fachApi.getall(wiedzmin_zdolnosc_fachu).enqueue(new Callback<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosc_fachu>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosc_fachu>> call, Response<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosc_fachu>> response) {
                alchemia.setText(String.valueOf(response.body().get(0).getAlchemia()));
                charakteryzacja.setText(String.valueOf(response.body().get(0).getCharakteryzacja()));
                falszerstwo.setText(String.valueOf(response.body().get(0).getFalszerstwo()));
                optrywanie.setText(String.valueOf(response.body().get(0).getOpatrywanie()));
                pulapki.setText(String.valueOf(response.body().get(0).getPulapki()));
                rzemioslo.setText(String.valueOf(response.body().get(0).getRzemioslo()));
                wlamania.setText(String.valueOf(response.body().get(0).getWlamania()));
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosc_fachu>> call, Throwable t) {
                Toast.makeText(umFachPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void mody(wiedzmin_zdolnosc_fachu wiedzmin_zdolnosc_fachu)
    {
        if (alchemia.getText().toString().isEmpty() ||
                charakteryzacja.getText().toString().isEmpty() ||
                falszerstwo.getText().toString().isEmpty() ||
                optrywanie.getText().toString().isEmpty() ||
                pulapki.getText().toString().isEmpty() ||
                rzemioslo.getText().toString().isEmpty() ||
                wlamania.getText().toString().isEmpty())
        {
            Toast.makeText(umFachPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2 < alchemia.getText().toString().length() ||
                    2 < charakteryzacja.getText().toString().length() ||
                    2 < falszerstwo.getText().toString().length() ||
                    2 < optrywanie.getText().toString().length() ||
                    2 < pulapki.getText().toString().length() ||
                    2 < rzemioslo.getText().toString().length() ||
                    2 < wlamania.getText().toString().length()) {
                Toast.makeText(umFachPostaci.this, "Wszystkie cechy nie mogą mieć więcej niż 2 cyfry", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                fachApi fachApi = rts.getRetrofit().create(com.example.rollapp.retrofit.fachApi.class);

                wiedzmin_zdolnosc_fachu.setAlchemia(Integer.valueOf(alchemia.getText().toString()));
                wiedzmin_zdolnosc_fachu.setCharakteryzacja(Integer.valueOf(charakteryzacja.getText().toString()));
                wiedzmin_zdolnosc_fachu.setFalszerstwo(Integer.valueOf(falszerstwo.getText().toString()));
                wiedzmin_zdolnosc_fachu.setOpatrywanie(Integer.valueOf(optrywanie.getText().toString()));
                wiedzmin_zdolnosc_fachu.setPulapki(Integer.valueOf(pulapki.getText().toString()));
                wiedzmin_zdolnosc_fachu.setRzemioslo(Integer.valueOf(rzemioslo.getText().toString()));
                wiedzmin_zdolnosc_fachu.setWlamania(Integer.valueOf(wlamania.getText().toString()));

                i++;

                fachApi.modyfikuj(wiedzmin_zdolnosc_fachu).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(umFachPostaci.this, "Problem połączenia z serwerem spróbuj ponownie pózniej !!!", Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE, "Wystapil blad", t);
                    }
                });
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_um_fach_postaci);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

        dozdolnoscigracji = findViewById(R.id.dogracji);
        zapisz= findViewById(R.id.zapisfachu);
        alchemia= findViewById(R.id.alchemia);
        charakteryzacja= findViewById(R.id.charakteryzacja);
        falszerstwo= findViewById(R.id.falszerstwo);
        optrywanie= findViewById(R.id.optrywanie);
        pulapki= findViewById(R.id.pulapki);
        rzemioslo= findViewById(R.id.rzemioslo);
        wlamania= findViewById(R.id.editTextNumber11);

        if (sessionstorage.getString("modyfikajca","")=="")
        {
            zapisz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wiedzmin_zdolnosc_fachu wiedzmin_zdolnosc_fachu=new wiedzmin_zdolnosc_fachu();
                    wiedzmin_zdolnosc_fachu.setId_karta(sessionstorage.getInt("idkarty",0));
                    getall(wiedzmin_zdolnosc_fachu);

                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            wiedzmin_karta wiedzmin_karta = new wiedzmin_karta();
                            wiedzmin_karta.setId(sessionstorage.getInt("idkarty",0));
                            wiedzmin_karta.setId_fachu(sessionstorage.getInt("idfachu",0));
                            updatekarta(wiedzmin_karta);
                        }
                    },300);
                    i++;
                }
            });

            dozdolnoscigracji.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (i==0)
                    {
                        Toast.makeText(umFachPostaci.this, "Proszę naciśnij przycisk zapisz", Toast.LENGTH_SHORT).show();
                    }
                    else if (i <= 1)
                    {
                        Toast.makeText(umFachPostaci.this, "Proszę naciśnij przycisk ZAPISZ jeszcze raz", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(umFachPostaci.this, umGracjaPostaci.class);
                        wiedzmin_zdolnosc_fachu wiedzmin_zdolnosc_fachu = new wiedzmin_zdolnosc_fachu();
                        getall(wiedzmin_zdolnosc_fachu);
                        Toast.makeText(umFachPostaci.this, String.valueOf(sessionstorage.getInt("idkarty",0)), Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                }
            });
        } else {
            wiedzmin_zdolnosc_fachu wiedzmin_zdolnosc_fachu = new wiedzmin_zdolnosc_fachu();
            wiedzmin_zdolnosc_fachu.setId_karta(sessionstorage.getInt("id_karty",1));
            getfach(wiedzmin_zdolnosc_fachu);
            dozdolnoscigracji.setText("Modyfikuj");
            zapisz.setVisibility(View.GONE);

            dozdolnoscigracji.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i==0)
                    {
                        mody(wiedzmin_zdolnosc_fachu);
                        Toast.makeText(umFachPostaci.this, "Proszę naciśnij modyfikuj jeszcze raz", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(umFachPostaci.this,postacmenu.class);
                                startActivity(intent);
                            }
                        },400);
                    }
                }
            });
        }

    }
}