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

    private void setkoniecpostac(postac postac)
    {
        retrofitservice rts = new retrofitservice();
        postacApi postacApi = rts.getRetrofit().create(com.example.rollapp.retrofit.postacApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        postac.setId_karty(sessionstorage.getInt("idkarty",0));

        postacApi.koniec(postac).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                wiedzmin_karta wiedzmin_karta = new wiedzmin_karta();
                setkonieckarta(wiedzmin_karta);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void setkonieckarta(wiedzmin_karta wiedzmin_karta)
    {
        retrofitservice rts = new retrofitservice();
        kartaApi kartaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.kartaApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_karta.setId(sessionstorage.getInt("idkarty",0));

        kartaApi.koniec(wiedzmin_karta).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                wiedzmin_cechy wiedzmin_cechy = new wiedzmin_cechy();
                setkonieccechy(wiedzmin_cechy);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void setkonieccechy(wiedzmin_cechy wiedzmin_cechy)
    {
        retrofitservice rts = new retrofitservice();
        cechaApi cechaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.cechaApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_cechy.setId_karty(sessionstorage.getInt("idkarty",0));

        cechaApi.koniec(wiedzmin_cechy).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                wiedzmin_zdolnosci_ciala wiedzmin_zdolnosci_ciala = new wiedzmin_zdolnosci_ciala();
                setkonieccialo(wiedzmin_zdolnosci_ciala);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void setkonieccialo(wiedzmin_zdolnosci_ciala wiedzmin_zdolnosci_ciala)
    {
        retrofitservice rts = new retrofitservice();
        cialoApi cialoApi = rts.getRetrofit().create(com.example.rollapp.retrofit.cialoApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_zdolnosci_ciala.setId_karta(sessionstorage.getInt("idkarty",0));

        cialoApi.koniec(wiedzmin_zdolnosci_ciala).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                wiedzmin_zdolnosci_emocji wiedzmin_zdolnosci_emocji = new wiedzmin_zdolnosci_emocji();
                setkoniecemocji(wiedzmin_zdolnosci_emocji);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }
    private void setkoniecemocji(wiedzmin_zdolnosci_emocji wiedzmin_zdolnosci_emocji)
    {
        retrofitservice rts = new retrofitservice();
        emocjaApi emocjaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.emocjaApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_zdolnosci_emocji.setId_karta(sessionstorage.getInt("idkarty",0));

        emocjaApi.koniec(wiedzmin_zdolnosci_emocji).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                wiedzmin_zdolnosc_fachu wiedzmin_zdolnosc_fachu = new wiedzmin_zdolnosc_fachu();
                setkoniefachu(wiedzmin_zdolnosc_fachu);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }
    private void setkoniefachu(wiedzmin_zdolnosc_fachu wiedzmin_zdolnosc_fachu)
    {
        retrofitservice rts = new retrofitservice();
        fachApi fachApi = rts.getRetrofit().create(com.example.rollapp.retrofit.fachApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_zdolnosc_fachu.setId_karta(sessionstorage.getInt("idkarty",0));

        fachApi.koniec(wiedzmin_zdolnosc_fachu).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                wiedzmin_zdolnosci_gracji wiedzmin_zdolnosci_gracji = new wiedzmin_zdolnosci_gracji();
                setkoniecgracja(wiedzmin_zdolnosci_gracji);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }
    private void setkoniecgracja(wiedzmin_zdolnosci_gracji wiedzmin_zdolnosci_gracji)
    {
        retrofitservice rts = new retrofitservice();
        gracjaApi gracjaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.gracjaApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_zdolnosci_gracji.setId_karta(sessionstorage.getInt("idkarty",0));

        gracjaApi.koniec(wiedzmin_zdolnosci_gracji).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                wiedzmin_zdolnosci_reakcji wiedzmin_zdolnosci_reakcji = new wiedzmin_zdolnosci_reakcji();
                setkoniecreakcji(wiedzmin_zdolnosci_reakcji);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }
    private void setkoniecreakcji(wiedzmin_zdolnosci_reakcji wiedzmin_zdolnosci_reakcji)
    {
        retrofitservice rts = new retrofitservice();
        reakcjaApi reakcjaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.reakcjaApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_zdolnosci_reakcji.setId_karta(sessionstorage.getInt("idkarty",0));

        reakcjaApi.koniec(wiedzmin_zdolnosci_reakcji).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                wiedzmin_zdolnosci_rozum wiedzmin_zdolnosci_rozum = new wiedzmin_zdolnosci_rozum();
                setkoniecrozum(wiedzmin_zdolnosci_rozum);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }
    private void setkoniecrozum(wiedzmin_zdolnosci_rozum wiedzmin_zdolnosci_rozum)
    {
        retrofitservice rts = new retrofitservice();
        rozumApi rozumApi = rts.getRetrofit().create(com.example.rollapp.retrofit.rozumApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_zdolnosci_rozum.setId_karta(sessionstorage.getInt("idkarty",0));

        rozumApi.koniec(wiedzmin_zdolnosci_rozum).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                wiedzmin_zdolnosci_woli wiedzmin_zdolnosci_woli = new wiedzmin_zdolnosci_woli();
                setkoniecwoli(wiedzmin_zdolnosci_woli);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }
    private void setkoniecwoli(wiedzmin_zdolnosci_woli wiedzmin_zdolnosci_woli)
    {
        retrofitservice rts = new retrofitservice();
        wolaApi wolaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.wolaApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_zdolnosci_woli.setId_karta(sessionstorage.getInt("idkarty",0));

        wolaApi.koniec(wiedzmin_zdolnosci_woli).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                wiedzmin_bron wiedzmin_bron = new wiedzmin_bron();
                setkoniecbroni(wiedzmin_bron);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void setkoniecbroni(wiedzmin_bron wiedzmin_bron)
    {
        retrofitservice rts = new retrofitservice();
        bronApi bronApi = rts.getRetrofit().create(com.example.rollapp.retrofit.bronApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_bron.setId_karty(sessionstorage.getInt("idkarty",0));

        bronApi.koniec(wiedzmin_bron).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                wiedzmin_pancerz wiedzmin_pancerz = new wiedzmin_pancerz();
                setkoniecpancerz(wiedzmin_pancerz);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void setkoniecpancerz(wiedzmin_pancerz wiedzmin_pancerz)
    {
        retrofitservice rts = new retrofitservice();
        pancerzApi pancerzApi = rts.getRetrofit().create(com.example.rollapp.retrofit.pancerzApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_pancerz.setId_karta(sessionstorage.getInt("idkarty",0));

        pancerzApi.koniec(wiedzmin_pancerz).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                wiedzmin_uszkodzenia_pancerz wiedzmin_uszkodzenia_pancerz = new wiedzmin_uszkodzenia_pancerz();
                setkoniecuszpancerz(wiedzmin_uszkodzenia_pancerz);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(pancerz.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void setkoniecuszpancerz(wiedzmin_uszkodzenia_pancerz wiedzmin_uszkodzenia_pancerz)
    {
        retrofitservice rts = new retrofitservice();
        uszkodzeniapancerzApi uszkodzeniapancerzApi = rts.getRetrofit().create(com.example.rollapp.retrofit.uszkodzeniapancerzApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wiedzmin_uszkodzenia_pancerz.setId_pancerz(sessionstorage.getInt("idpancerza",0));

        uszkodzeniapancerzApi.koniec(wiedzmin_uszkodzenia_pancerz).enqueue(new Callback<Void>() {
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
                            Intent intent = new Intent(pancerz.this, pancerz.class);
                            wiedzmin_pancerz cechy =new wiedzmin_pancerz();
                            getall(cechy);
                            postac postac = new postac();
                            setkoniecpostac(postac);
                            startActivity(intent);
                        }
                    },1000);
                }
            }
        });
    }
}