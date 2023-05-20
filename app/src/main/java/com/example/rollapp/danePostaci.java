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

import com.example.rollapp.retrofit.graApi;
import com.example.rollapp.retrofit.postacApi;
import com.example.rollapp.retrofit.retrofitservice;

import com.example.rollapp.model.gra;
import com.example.rollapp.model.postac;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class danePostaci extends AppCompatActivity {

    private EditText nazwa;

    private EditText plec;

    private EditText rasa;

    private EditText wiek;

    private static final String SHERED_PREFS = "daneuzyt";

    Button zapisz;

    Button doCech;

    public void stworzgre(gra gra)
    {
        retrofitservice rts = new retrofitservice();
        graApi graApi = rts.getRetrofit().create(com.example.rollapp.retrofit.graApi.class);
        graApi.save(gra).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(danePostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    public void czyistnieje(gra gra)
    {
        retrofitservice rts = new retrofitservice();
        graApi graApi = rts.getRetrofit().create(com.example.rollapp.retrofit.graApi.class);
        graApi.czyjest(gra).enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                if(response.body().isEmpty())
                {
                    gra gra = new gra();
                    gra.setNazwa("Wiedźmin");
                    stworzgre(gra);
                }
                else {
                    Toast.makeText(danePostaci.this, "Gra wiedżmin znajduje się już w bazie!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                Toast.makeText(danePostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    public void stworzpostac(postac postac)
    {
        retrofitservice rts = new retrofitservice();
        postacApi postacApi = rts.getRetrofit().create(com.example.rollapp.retrofit.postacApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

        postacApi.save(postac).enqueue(new Callback<com.example.rollapp.model.postac>() {
            @Override
            public void onResponse(Call<com.example.rollapp.model.postac> call, Response<com.example.rollapp.model.postac> response) {

            }

            @Override
            public void onFailure(Call<com.example.rollapp.model.postac> call, Throwable t) {
                Toast.makeText(danePostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dane_postaci);
        TextView textView = findViewById(R.id.textView);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Pacifico-Regular.ttf");
        textView.setTypeface(typeface);

        doCech = findViewById(R.id.doCech);

        nazwa = findViewById(R.id.nazwa_postaci);
        plec = findViewById(R.id.plec);
        rasa = findViewById(R.id.rasa);
        wiek = findViewById(R.id.wiek);

        zapisz = findViewById(R.id.zapisdane);

        gra gra = new gra();
        gra.setNazwa("Wiedźmin");
        czyistnieje(gra);

        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                SharedPreferences.Editor editor = sessionstorage.edit();
                editor.putString("nazwa",nazwa.getText().toString());
                editor.putString("plec",plec.getText().toString());
                editor.putString("rasa",rasa.getText().toString());
                editor.putString("wiek",wiek.getText().toString());
                editor.commit();
            }
        });
        doCech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(danePostaci.this, cechyPostaci.class);

                startActivity(intent);
            }

        });
    }

}