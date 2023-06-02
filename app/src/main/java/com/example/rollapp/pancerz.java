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
import com.example.rollapp.model.wiedzmin_bron;
import com.example.rollapp.model.wiedzmin_cechy;
import com.example.rollapp.model.wiedzmin_karta;
import com.example.rollapp.model.wiedzmin_pancerz;
import com.example.rollapp.model.wiedzmin_uszkodzenia_pancerz;
import com.example.rollapp.model.wiedzmin_zdolnosc_fachu;
import com.example.rollapp.model.wiedzmin_zdolnosci_ciala;
import com.example.rollapp.model.wiedzmin_zdolnosci_emocji;
import com.example.rollapp.model.wiedzmin_zdolnosci_gracji;
import com.example.rollapp.model.wiedzmin_zdolnosci_reakcji;
import com.example.rollapp.model.wiedzmin_zdolnosci_rozum;
import com.example.rollapp.model.wiedzmin_zdolnosci_woli;
import com.example.rollapp.retrofit.bronApi;
import com.example.rollapp.retrofit.cechaApi;
import com.example.rollapp.retrofit.cialoApi;
import com.example.rollapp.retrofit.emocjaApi;
import com.example.rollapp.retrofit.fachApi;
import com.example.rollapp.retrofit.gracjaApi;
import com.example.rollapp.retrofit.kartaApi;
import com.example.rollapp.retrofit.pancerzApi;
import com.example.rollapp.retrofit.postacApi;
import com.example.rollapp.retrofit.reakcjaApi;
import com.example.rollapp.retrofit.retrofitservice;
import com.example.rollapp.retrofit.rozumApi;
import com.example.rollapp.retrofit.uszkodzeniapancerzApi;
import com.example.rollapp.retrofit.wolaApi;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pancerz extends AppCompatActivity {

    private EditText glowa;

    private EditText korpus;

    private EditText l_noga;

    private EditText l_reka;

    private EditText p_noga;

    private EditText p_reka;

    private EditText uglowa;

    private EditText ukorpus;

    private EditText ul_noga;

    private EditText ul_reka;

    private EditText up_noga;

    private EditText up_reka;

    private Button zapiszpacerz;

    private Button koniec;

    private static final String SHERED_PREFS = "daneuzyt";

    private int i=0;

    private void getall(wiedzmin_pancerz wiedzmin_pancerz)
    {
        retrofitservice rts = new retrofitservice();
        pancerzApi pancerzApi = rts.getRetrofit().create(com.example.rollapp.retrofit.pancerzApi.class);
        pancerzApi.czyjest(wiedzmin_pancerz).enqueue(new Callback<ArrayList<wiedzmin_pancerz>>() {
            @Override
            public void onResponse(Call<ArrayList<wiedzmin_pancerz>> call, Response<ArrayList<wiedzmin_pancerz>> response) {
                if (response.body().isEmpty())
                {
                    savepancerz(wiedzmin_pancerz);
                }
                else {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.putInt("idpancerza",response.body().get(0).getId());
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<wiedzmin_pancerz>> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void savepancerz(wiedzmin_pancerz wiedzmin_pancerz)
    {
        if (glowa.getText().toString().isEmpty() ||
                korpus.getText().toString().isEmpty() ||
                l_noga.getText().toString().isEmpty() ||
                l_reka.getText().toString().isEmpty() ||
                p_noga.getText().toString().isEmpty() ||
                p_reka.getText().toString().isEmpty())
        {
            Toast.makeText(pancerz.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2<glowa.getText().toString().length() ||
                    2<korpus.getText().toString().length() ||
                    2<l_noga.getText().toString().length() ||
                    2<l_reka.getText().toString().length() ||
                    2<p_noga.getText().toString().length() ||
                    2<p_reka.getText().toString().length())
            {
                Toast.makeText(pancerz.this, "Wszystkie statystyki nie moga mieć więcej niż 2 znaków ", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                pancerzApi pancerzApi = rts.getRetrofit().create(com.example.rollapp.retrofit.pancerzApi.class);

                SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

                wiedzmin_pancerz.setGlowa(Integer.valueOf(glowa.getText().toString()));
                wiedzmin_pancerz.setKorpus(Integer.valueOf(korpus.getText().toString()));
                wiedzmin_pancerz.setL_noga(Integer.valueOf(l_noga.getText().toString()));
                wiedzmin_pancerz.setL_reka(Integer.valueOf(l_reka.getText().toString()));
                wiedzmin_pancerz.setR_noga(Integer.valueOf(p_noga.getText().toString()));
                wiedzmin_pancerz.setP_reka(Integer.valueOf(p_reka.getText().toString()));
                wiedzmin_pancerz.setId_karta(Integer.valueOf(sessionstorage.getInt("idkarty",0)));

                pancerzApi.save(wiedzmin_pancerz).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    private void modpancerzdomyslne(wiedzmin_pancerz wiedzmin_pancerz)
    {
        if (glowa.getText().toString().isEmpty() ||
                korpus.getText().toString().isEmpty() ||
                l_noga.getText().toString().isEmpty() ||
                l_reka.getText().toString().isEmpty() ||
                p_noga.getText().toString().isEmpty() ||
                p_reka.getText().toString().isEmpty())
        {
            Toast.makeText(pancerz.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2<glowa.getText().toString().length() ||
                    2<korpus.getText().toString().length() ||
                    2<l_noga.getText().toString().length() ||
                    2<l_reka.getText().toString().length() ||
                    2<p_noga.getText().toString().length() ||
                    2<p_reka.getText().toString().length())
            {
                Toast.makeText(pancerz.this, "Wszystkie statystyki nie moga mieć więcej niż 2 znaków ", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                pancerzApi pancerzApi = rts.getRetrofit().create(com.example.rollapp.retrofit.pancerzApi.class);

                SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

                wiedzmin_pancerz.setGlowa(Integer.valueOf(glowa.getText().toString()));
                wiedzmin_pancerz.setKorpus(Integer.valueOf(korpus.getText().toString()));
                wiedzmin_pancerz.setL_noga(Integer.valueOf(l_noga.getText().toString()));
                wiedzmin_pancerz.setL_reka(Integer.valueOf(l_reka.getText().toString()));
                wiedzmin_pancerz.setR_noga(Integer.valueOf(p_noga.getText().toString()));
                wiedzmin_pancerz.setP_reka(Integer.valueOf(p_reka.getText().toString()));
                wiedzmin_pancerz.setId_karta(Integer.valueOf(sessionstorage.getInt("idkarty",0)));

                pancerzApi.mody(wiedzmin_pancerz).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    private void moduszpancerz(wiedzmin_uszkodzenia_pancerz wiedzmin_uszkodzenia_pancerz)
    {
        if (uglowa.getText().toString().isEmpty() ||
                ukorpus.getText().toString().isEmpty() ||
                ul_noga.getText().toString().isEmpty() ||
                ul_reka.getText().toString().isEmpty() ||
                up_noga.getText().toString().isEmpty() ||
                up_reka.getText().toString().isEmpty())
        {
            Toast.makeText(pancerz.this, "Wszystkie pola muszą być uzupełnione", Toast.LENGTH_SHORT).show();
        } else {
            if (2<uglowa.getText().toString().length() ||
                    2<ukorpus.getText().toString().length() ||
                    2<ul_noga.getText().toString().length() ||
                    2<ul_reka.getText().toString().length() ||
                    2<up_noga.getText().toString().length() ||
                    2<up_reka.getText().toString().length())
            {
                Toast.makeText(pancerz.this, "Wszystkie statystyki nie moga mieć więcej niż 2 znaków ", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                uszkodzeniapancerzApi uszkodzeniapancerzApi = rts.getRetrofit().create(com.example.rollapp.retrofit.uszkodzeniapancerzApi.class);

                SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

                wiedzmin_uszkodzenia_pancerz.setGlowa(Integer.valueOf(glowa.getText().toString()));
                wiedzmin_uszkodzenia_pancerz.setKorpus(Integer.valueOf(korpus.getText().toString()));
                wiedzmin_uszkodzenia_pancerz.setL_noga(Integer.valueOf(l_noga.getText().toString()));
                wiedzmin_uszkodzenia_pancerz.setL_reka(Integer.valueOf(l_reka.getText().toString()));
                wiedzmin_uszkodzenia_pancerz.setP_noga(Integer.valueOf(p_noga.getText().toString()));
                wiedzmin_uszkodzenia_pancerz.setP_reka(Integer.valueOf(p_reka.getText().toString()));
                wiedzmin_uszkodzenia_pancerz.setId_pancerz(Integer.valueOf(sessionstorage.getInt("idkarty",0)));

                uszkodzeniapancerzApi.mody(wiedzmin_uszkodzenia_pancerz).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    private void saveuszpanc(wiedzmin_uszkodzenia_pancerz wiedzmin_uszkodzenia_pancerz)
    {
        retrofitservice rts = new retrofitservice();
        uszkodzeniapancerzApi uszkodzeniapancerzApi = rts.getRetrofit().create(com.example.rollapp.retrofit.uszkodzeniapancerzApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

        wiedzmin_uszkodzenia_pancerz.setId_pancerz(sessionstorage.getInt("idpancerza",0));

        uszkodzeniapancerzApi.save(wiedzmin_uszkodzenia_pancerz).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void updatekarta(wiedzmin_karta wiedzmin_karta)
    {
        retrofitservice rts = new retrofitservice();
        kartaApi kartaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.kartaApi.class);
        kartaApi.updatepancerz(wiedzmin_karta).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void getallusz(wiedzmin_uszkodzenia_pancerz wiedzmin_uszkodzenia_pancerz)
    {
        retrofitservice rts = new retrofitservice();
        uszkodzeniapancerzApi uszkodzeniapancerzApi = rts.getRetrofit().create(com.example.rollapp.retrofit.uszkodzeniapancerzApi.class);
        uszkodzeniapancerzApi.getall(wiedzmin_uszkodzenia_pancerz).enqueue(new Callback<ArrayList<wiedzmin_uszkodzenia_pancerz>>() {
            @Override
            public void onResponse(Call<ArrayList<wiedzmin_uszkodzenia_pancerz>> call, Response<ArrayList<wiedzmin_uszkodzenia_pancerz>> response) {
                if (response.body().isEmpty())
                {
                    saveuszpanc(wiedzmin_uszkodzenia_pancerz);
                }
                else {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.putInt("idusz",response.body().get(0).getId());
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<wiedzmin_uszkodzenia_pancerz>> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void updatepancerz(wiedzmin_pancerz wiedzmin_pancerz)
    {
        retrofitservice rts = new retrofitservice();
        pancerzApi pancerzApi = rts.getRetrofit().create(com.example.rollapp.retrofit.pancerzApi.class);
        pancerzApi.updateusz(wiedzmin_pancerz).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pancerz);

        glowa=findViewById(R.id.wartoscglowa);
        korpus=findViewById(R.id.wartosckorpus);
        l_noga=findViewById(R.id.wartoscl_noga);
        l_reka=findViewById(R.id.wartosclreka);
        p_noga=findViewById(R.id.uszkodzeniapnoga);
        p_reka=findViewById(R.id.wartoscpreka);

        uglowa=findViewById(R.id.uszkodzeniaglowa);
        ukorpus=findViewById(R.id.uszkodzeniakorpus);
        ul_noga=findViewById(R.id.uszkodzenialnoga);
        ul_reka=findViewById(R.id.uszkodzenialreka);
        up_noga=findViewById(R.id.wartoscpnoga);
        up_reka=findViewById(R.id.uszkodzeniapreka);

        uglowa.setText("0");
        ukorpus.setText("0");
        ul_noga.setText("0");
        ul_reka.setText("0");
        up_noga.setText("0");
        up_reka.setText("0");


        uglowa.setEnabled(false);
        ukorpus.setEnabled(false);
        ul_noga.setEnabled(false);
        ul_reka.setEnabled(false);
        up_noga.setEnabled(false);
        up_reka.setEnabled(false);

        zapiszpacerz=findViewById(R.id.zapiszpancerz);
        koniec=findViewById(R.id.zapiszbron);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        SharedPreferences.Editor editor = sessionstorage.edit();

        zapiszpacerz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wiedzmin_pancerz wiedzmin_pancerz = new wiedzmin_pancerz();
                wiedzmin_pancerz.setId_karta(sessionstorage.getInt("idkarty",0));
                getall(wiedzmin_pancerz);
                modpancerzdomyslne(wiedzmin_pancerz);

                wiedzmin_uszkodzenia_pancerz wiedzmin_uszkodzenia_pancerz = new wiedzmin_uszkodzenia_pancerz();
                wiedzmin_uszkodzenia_pancerz.setId_pancerz(sessionstorage.getInt("idpancerza",1));
                getallusz(wiedzmin_uszkodzenia_pancerz);

                wiedzmin_pancerz.setId_uszkodzeniapancerza(sessionstorage.getInt("idusz",1));
                updatepancerz(wiedzmin_pancerz);

                wiedzmin_karta wiedzmin_karta = new wiedzmin_karta();
                wiedzmin_karta.setId(sessionstorage.getInt("idkarty",0));
                wiedzmin_karta.setId_pancerza(sessionstorage.getInt("idpancerza",0));
                updatekarta(wiedzmin_karta);


                i++;
            }
        });

        koniec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i==0)
                {
                    Toast.makeText(pancerz.this, "Proszę naciśnij przycisk zapisz", Toast.LENGTH_SHORT).show();
                }
                else if (i<=4)
                {
                    Toast.makeText(pancerz.this, "Proszę naciśnij przycisk ZAPISZ jeszcze raz", Toast.LENGTH_SHORT).show();
                } else {
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(pancerz.this, wyglad.class);
                            wiedzmin_pancerz cechy =new wiedzmin_pancerz();
                            getall(cechy);
                            startActivity(intent);
                        }
                    },1000);
                }
            }
        });
    }
}