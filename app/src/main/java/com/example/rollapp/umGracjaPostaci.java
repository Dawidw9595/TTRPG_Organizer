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
import com.example.rollapp.model.wiedzmin_zdolnosci_gracji;
import com.example.rollapp.retrofit.fachApi;
import com.example.rollapp.retrofit.gracjaApi;
import com.example.rollapp.retrofit.kartaApi;
import com.example.rollapp.retrofit.retrofitservice;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class umGracjaPostaci extends AppCompatActivity {

    private EditText atletyka;

    private EditText kusznictwo;

    private EditText lucznictwo;

    private EditText skrytosc;

    private EditText zreczne_palce;

    private Integer i=0;

    private static final String SHERED_PREFS = "daneuzyt";

    Button zapisz;
    Button dozdolnoscireakcji;

    private void savegracja(wiedzmin_zdolnosci_gracji wiedzmin_zdolnosci_gracji)
    {
        if (atletyka.getText().toString().isEmpty() ||
                kusznictwo.getText().toString().isEmpty() ||
                lucznictwo.getText().toString().isEmpty() ||
                skrytosc.getText().toString().isEmpty() ||
                zreczne_palce.getText().toString().isEmpty())
        {
            Toast.makeText(umGracjaPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2<atletyka.getText().toString().length() ||
                    2<kusznictwo.getText().toString().length() ||
                    2<lucznictwo.getText().toString().length() ||
                    2<skrytosc.getText().toString().length() ||
                    2<zreczne_palce.getText().toString().length())
            {
                Toast.makeText(umGracjaPostaci.this, "Wszystkie cechy nie mogą mieć więcej niż 2 cyfry", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                gracjaApi gracjaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.gracjaApi.class);

                wiedzmin_zdolnosci_gracji.setAtletyka(Integer.valueOf(atletyka.getText().toString()));
                wiedzmin_zdolnosci_gracji.setKusznictwo(Integer.valueOf(kusznictwo.getText().toString()));
                wiedzmin_zdolnosci_gracji.setLucznictwo(Integer.valueOf(lucznictwo.getText().toString()));
                wiedzmin_zdolnosci_gracji.setSkrytosc(Integer.valueOf(skrytosc.getText().toString()));
                wiedzmin_zdolnosci_gracji.setZreczne_palce(Integer.valueOf(zreczne_palce.getText().toString()));


                gracjaApi.save(wiedzmin_zdolnosci_gracji).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(umGracjaPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    private void getall(wiedzmin_zdolnosci_gracji wiedzmin_zdolnosci_gracji)
    {
        retrofitservice rts = new retrofitservice();
        gracjaApi gracjaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.gracjaApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_zdolnosci_gracji.setId_karta(sessionstorage.getInt("idkarty",0));

        gracjaApi.getall(wiedzmin_zdolnosci_gracji).enqueue(new Callback<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_gracji>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_gracji>> call, Response<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_gracji>> response) {
                if (response.body().isEmpty())
                {
                    savegracja(wiedzmin_zdolnosci_gracji);
                } else {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.putInt("idgracji",response.body().get(0).getId());
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_gracji>> call, Throwable t) {
                Toast.makeText(umGracjaPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
        wiedzmin_karta.setId_gracji(sessionstorage.getInt("idgracji",0));
        kartaApi.updategracja(wiedzmin_karta).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(umGracjaPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void getgracja(wiedzmin_zdolnosci_gracji wiedzmin_zdolnosci_gracji)
    {
        retrofitservice rts = new retrofitservice();
        gracjaApi gracjaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.gracjaApi.class);
        gracjaApi.getall(wiedzmin_zdolnosci_gracji).enqueue(new Callback<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_gracji>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_gracji>> call, Response<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_gracji>> response) {
                atletyka.setText(String.valueOf(response.body().get(0).getAtletyka()));
                kusznictwo.setText(String.valueOf(response.body().get(0).getKusznictwo()));
                lucznictwo.setText(String.valueOf(response.body().get(0).getLucznictwo()));
                skrytosc.setText(String.valueOf(response.body().get(0).getSkrytosc()));
                zreczne_palce.setText(String.valueOf(response.body().get(0).getZreczne_palce()));
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.rollapp.model.wiedzmin_zdolnosci_gracji>> call, Throwable t) {
                Toast.makeText(umGracjaPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void modyfikuj(wiedzmin_zdolnosci_gracji wiedzmin_zdolnosci_gracji)
    {
        if (atletyka.getText().toString().isEmpty() ||
                kusznictwo.getText().toString().isEmpty() ||
                lucznictwo.getText().toString().isEmpty() ||
                skrytosc.getText().toString().isEmpty() ||
                zreczne_palce.getText().toString().isEmpty())
        {
            Toast.makeText(umGracjaPostaci.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2<atletyka.getText().toString().length() ||
                    2<kusznictwo.getText().toString().length() ||
                    2<lucznictwo.getText().toString().length() ||
                    2<skrytosc.getText().toString().length() ||
                    2<zreczne_palce.getText().toString().length())
            {
                Toast.makeText(umGracjaPostaci.this, "Wszystkie cechy nie mogą mieć więcej niż 2 cyfry", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                gracjaApi gracjaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.gracjaApi.class);

                wiedzmin_zdolnosci_gracji.setAtletyka(Integer.valueOf(atletyka.getText().toString()));
                wiedzmin_zdolnosci_gracji.setKusznictwo(Integer.valueOf(kusznictwo.getText().toString()));
                wiedzmin_zdolnosci_gracji.setLucznictwo(Integer.valueOf(lucznictwo.getText().toString()));
                wiedzmin_zdolnosci_gracji.setSkrytosc(Integer.valueOf(skrytosc.getText().toString()));
                wiedzmin_zdolnosci_gracji.setZreczne_palce(Integer.valueOf(zreczne_palce.getText().toString()));

                i++;

                gracjaApi.modyfikuj(wiedzmin_zdolnosci_gracji).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(umGracjaPostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_um_gracja_postaci);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

        dozdolnoscireakcji = findViewById(R.id.dorekacji);
        zapisz = findViewById(R.id.zapisgracja);
        atletyka = findViewById(R.id.atletyka);
        kusznictwo = findViewById(R.id.kusznictwo);
        lucznictwo = findViewById(R.id.lucznictwo);
        skrytosc = findViewById(R.id.skrytosc);
        zreczne_palce = findViewById(R.id.zreczne_palce);

        if (sessionstorage.getString("modyfikajca","")=="")
        {
            zapisz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wiedzmin_zdolnosci_gracji wiedzmin_zdolnosci_gracji = new wiedzmin_zdolnosci_gracji();
                    wiedzmin_zdolnosci_gracji.setId_karta(sessionstorage.getInt("idkarty",0));
                    getall(wiedzmin_zdolnosci_gracji);

                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            wiedzmin_karta wiedzmin_karta = new wiedzmin_karta();
                            wiedzmin_karta.setId(sessionstorage.getInt("idkarty",0));
                            wiedzmin_karta.setId_gracji(sessionstorage.getInt("idgracji",0));
                            updatekarta(wiedzmin_karta);
                        }
                    },300);
                    i++;
                }
            });

            dozdolnoscireakcji.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (i==0)
                    {
                        Toast.makeText(umGracjaPostaci.this, "Proszę naciśnij przycisk zapisz", Toast.LENGTH_SHORT).show();
                    }
                    else if (i <= 1)
                    {
                        Toast.makeText(umGracjaPostaci.this, "Proszę naciśnij przycisk ZAPISZ jeszcze raz", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(umGracjaPostaci.this, umReakcjaPostaci.class);
                        wiedzmin_zdolnosci_gracji wiedzmin_zdolnosci_gracji = new wiedzmin_zdolnosci_gracji();
                        getall(wiedzmin_zdolnosci_gracji);
                        startActivity(intent);
                    }
                }
            });
        }else {
            wiedzmin_zdolnosci_gracji wiedzmin_zdolnosci_gracji = new wiedzmin_zdolnosci_gracji();
            wiedzmin_zdolnosci_gracji.setId_karta(sessionstorage.getInt("id_karty",1));
            getgracja(wiedzmin_zdolnosci_gracji);
            dozdolnoscireakcji.setText("Modyfikuj");
            zapisz.setVisibility(View.GONE);

            dozdolnoscireakcji.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i==0)
                    {
                        modyfikuj(wiedzmin_zdolnosci_gracji);
                        Toast.makeText(umGracjaPostaci.this, "Proszę naciśnij modyfikuj jeszcze raz", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(umGracjaPostaci.this,postacmenu.class);
                                startActivity(intent);
                            }
                        },400);
                    }
                }
            });
        }

    }
}