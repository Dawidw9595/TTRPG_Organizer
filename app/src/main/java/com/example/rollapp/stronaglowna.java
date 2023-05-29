package com.example.rollapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

public class stronaglowna extends AppCompatActivity {

    private ImageButton losowanie;

    private ImageButton twojepostacie;

    private TextView nickuzyt;

    private Object[] id;

    private static final String SHERED_PREFS = "daneuzyt";

    private void usunkarteniedoko()
    {
        retrofitservice rts = new retrofitservice();
        kartaApi kartaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.kartaApi.class);

        kartaApi.usunpuste().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                usunpostacniedoko();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(stronaglowna.this , "Problem połączenia z serwerem spróbuj ponownie pózniej " , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void usunpostacniedoko()
    {
        retrofitservice rts = new retrofitservice();
        postacApi postacApi=rts.getRetrofit().create(com.example.rollapp.retrofit.postacApi.class);

        postacApi.usunpostac().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                usuncialoniedoko();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(stronaglowna.this , "Problem połączenia z serwerem spróbuj ponownie pózniej" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void usuncialoniedoko()
    {
        retrofitservice rts = new retrofitservice();
        cialoApi cialoApi=rts.getRetrofit().create(com.example.rollapp.retrofit.cialoApi.class);

        cialoApi.usunpuste().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                usuncechaniedoko();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(stronaglowna.this , "Problem połączenia z serwerem spróbuj ponownie pózniej" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void usuncechaniedoko()
    {
        retrofitservice rts = new retrofitservice();
        cechaApi cechaApi=rts.getRetrofit().create(com.example.rollapp.retrofit.cechaApi.class);

        cechaApi.usunpuste().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                usunemocjaniedoko();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(stronaglowna.this , "Problem połączenia z serwerem spróbuj ponownie pózniej" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void usunemocjaniedoko()
    {
        retrofitservice rts = new retrofitservice();
        emocjaApi emocjaApi=rts.getRetrofit().create(com.example.rollapp.retrofit.emocjaApi.class);

        emocjaApi.usunpuste().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                usunfachniedoko();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(stronaglowna.this , "Problem połączenia z serwerem spróbuj ponownie pózniej" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void usunfachniedoko()
    {
        retrofitservice rts = new retrofitservice();
        fachApi fachApi=rts.getRetrofit().create(com.example.rollapp.retrofit.fachApi.class);

        fachApi.usunpuste().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                usungracjaniedoko();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(stronaglowna.this , "Problem połączenia z serwerem spróbuj ponownie pózniej" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void usungracjaniedoko()
    {
        retrofitservice rts = new retrofitservice();
        gracjaApi gracjaApi=rts.getRetrofit().create(com.example.rollapp.retrofit.gracjaApi.class);

        gracjaApi.usunpuste().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                usunreakcjaniedoko();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(stronaglowna.this , "Problem połączenia z serwerem spróbuj ponownie pózniej" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void usunreakcjaniedoko()
    {
        retrofitservice rts = new retrofitservice();
        reakcjaApi reakcjaApi=rts.getRetrofit().create(com.example.rollapp.retrofit.reakcjaApi.class);

        reakcjaApi.usunpuste().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                usunrozumniedoko();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(stronaglowna.this , "Problem połączenia z serwerem spróbuj ponownie pózniej" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void usunrozumniedoko()
    {
        retrofitservice rts = new retrofitservice();
        rozumApi rozumApi=rts.getRetrofit().create(com.example.rollapp.retrofit.rozumApi.class);

        rozumApi.usunpuste().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                usunwolaiedoko();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(stronaglowna.this , "Problem połączenia z serwerem spróbuj ponownie pózniej" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void usunwolaiedoko()
    {
        retrofitservice rts = new retrofitservice();
        wolaApi wolaApi=rts.getRetrofit().create(com.example.rollapp.retrofit.wolaApi.class);

        wolaApi.usunpuste().enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(stronaglowna.this , "Problem połączenia z serwerem spróbuj ponownie pózniej" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }


    private ImageButton stworzPostac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stronaglowna);
        losowanie = findViewById(R.id.imageButton6);
        nickuzyt = findViewById(R.id.nickclick);
        twojepostacie = findViewById(R.id.twojepostacie);

        usunkarteniedoko();

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                nickuzyt.setText(sessionstorage.getString("nick","Błąd"));

                nickuzyt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(stronaglowna.this, zmianadanychuzyt.class);
                        startActivity(intent);
                    }
                });

                losowanie.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(stronaglowna.this, Liczba_losowa.class);
                        startActivity(intent);
                    }

                });

                stworzPostac = findViewById(R.id.stworzPostac);
                stworzPostac.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(stronaglowna.this, danePostaci.class);
                        SharedPreferences.Editor editor = sessionstorage.edit();
                        editor.remove("modyfikajca");
                        editor.commit();
                        startActivity(intent);
                    }

                });

                twojepostacie.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(stronaglowna.this, lista_postaci.class);
                        startActivity(intent);
                    }
                });
            }
        },1000);
    }
}