package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rollapp.model.charakter;
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
import com.example.rollapp.model.wyglad;
import com.example.rollapp.retrofit.bronApi;
import com.example.rollapp.retrofit.cechaApi;
import com.example.rollapp.retrofit.charakterApi;
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
import com.example.rollapp.retrofit.wydarzeniaApi;
import com.example.rollapp.retrofit.wygladApi;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class wydarzenia extends AppCompatActivity {

    private EditText l10;
    private EditText l20;
    private EditText l30;
    private EditText l40;
    private EditText l50;
    private EditText l60;
    private EditText l70;
    private EditText l80;
    private EditText l90;
    private EditText l100;

    private Button zapiszDzieje;

    private Button koniec;

    private static final String SHERED_PREFS = "daneuzyt";

    private int i=0;

    public void czyjestwyglad(com.example.rollapp.model.wydarzenia wydarzenia)
    {
        retrofitservice rts = new retrofitservice();
        wydarzeniaApi wydarzeniaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.wydarzeniaApi.class);
        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wydarzenia.setId_karty(sessionstorage.getInt("idkarty",0));
        wydarzeniaApi.getallw(wydarzenia).enqueue(new Callback<ArrayList<com.example.rollapp.model.wydarzenia>>() {
            @Override
            public void onResponse(Call<ArrayList<com.example.rollapp.model.wydarzenia>> call, Response<ArrayList<com.example.rollapp.model.wydarzenia>> response) {
                if (response.body().isEmpty())
                {
                    savewyglad(wydarzenia);
                }else {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.putInt("idwydarzenie",response.body().get(0).getId());
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<com.example.rollapp.model.wydarzenia>> call, Throwable t) {
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    public void savewyglad(com.example.rollapp.model.wydarzenia wydarzenia)
    {
        if (l10.getText().toString().isEmpty()||
                l20.getText().toString().isEmpty()||
                l30.getText().toString().isEmpty()||
                l40.getText().toString().isEmpty()||
                l50.getText().toString().isEmpty()||
                l60.getText().toString().isEmpty()||
                l70.getText().toString().isEmpty()||
                l80.getText().toString().isEmpty()||
                l90.getText().toString().isEmpty()||
                l100.getText().toString().isEmpty())
        {
            Toast.makeText(wydarzenia.this, "Pola nie mogą być puste", Toast.LENGTH_SHORT).show();
        } else {
            if (100<l10.getText().toString().length()||
                    100<l20.getText().toString().length()||
                    100<l30.getText().toString().length()||
                    100< l40.getText().toString().length()||
                    100<l50.getText().toString().length()||
                    100<l60.getText().toString().length()||
                    100<l70.getText().toString().length()||
                    100<l80.getText().toString().length()||
                    100<l90.getText().toString().length()||
                    100<l100.getText().toString().length())
            {
                Toast.makeText(wydarzenia.this, "Wszytkie dane nie mogą przekraczać 100 znaków", Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                wydarzeniaApi wydarzeniaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.wydarzeniaApi.class);
                SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

                wydarzenia.setId_karty(sessionstorage.getInt("idkarty",0));
                wydarzenia.setLata_10(l10.getText().toString());
                wydarzenia.setLata_20(l20.getText().toString());
                wydarzenia.setLata_30(l30.getText().toString());
                wydarzenia.setLata_40(l40.getText().toString());
                wydarzenia.setLata_50(l50.getText().toString());
                wydarzenia.setLata_60(l60.getText().toString());
                wydarzenia.setLata_70(l70.getText().toString());
                wydarzenia.setLata_80(l80.getText().toString());
                wydarzenia.setLata_90(l90.getText().toString());
                wydarzenia.setLata_100(l100.getText().toString());
                wydarzenia.setKoniec(0);

                wydarzeniaApi.save(wydarzenia).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    private void updatekarte(wiedzmin_karta wiedzmin_karta)
    {
        retrofitservice rts = new retrofitservice();
        kartaApi kartaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.kartaApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

        wiedzmin_karta.setId(sessionstorage.getInt("idkarty",0));
        wiedzmin_karta.setId_wydarzenia(sessionstorage.getInt("idwydarzenie",5));
        kartaApi.updatewydarzenia(wiedzmin_karta).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
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
                charakter charakter = new charakter();
                setkonieccharakter(charakter);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void setkonieccharakter(charakter charakter)
    {
        retrofitservice rts = new retrofitservice();
        charakterApi charakterApi = rts.getRetrofit().create(com.example.rollapp.retrofit.charakterApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        charakter.setId_karty(sessionstorage.getInt("idkarty",0));

        charakterApi.koniec(charakter).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                com.example.rollapp.model.wyglad wyglad = new com.example.rollapp.model.wyglad();
                setkoniecwyglad(wyglad);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void setkoniecwyglad(com.example.rollapp.model.wyglad wyglad)
    {
        retrofitservice rts = new retrofitservice();
        wygladApi wygladApi = rts.getRetrofit().create(com.example.rollapp.retrofit.wygladApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wyglad.setId_karty(sessionstorage.getInt("idkarty",0));
        wygladApi.koniec(wyglad).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                com.example.rollapp.model.wydarzenia wydarzenia = new com.example.rollapp.model.wydarzenia();
                setkoniecwydarzen(wydarzenia);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private void setkoniecwydarzen(com.example.rollapp.model.wydarzenia wydarzenia)
    {
        retrofitservice rts = new retrofitservice();
        wydarzeniaApi wydarzeniaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.wydarzeniaApi.class);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        wydarzenia.setId_karty(sessionstorage.getInt("idkarty",0));
        wydarzeniaApi.koniec(wydarzenia).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(wydarzenia.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wydarzenia);

        l10 = findViewById(R.id.lata10);
        l20 = findViewById(R.id.lata20);
        l30 = findViewById(R.id.lata30);
        l40 = findViewById(R.id.lata40);
        l50 = findViewById(R.id.lata50);
        l60 = findViewById(R.id.lata60);
        l70 = findViewById(R.id.lata70);
        l80 = findViewById(R.id.lata80);
        l90 = findViewById(R.id.lata90);
        l100 = findViewById(R.id.lata100);

        zapiszDzieje = findViewById(R.id.zapiszDzieje);
        koniec = findViewById(R.id.koniec);

        zapiszDzieje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.rollapp.model.wydarzenia wydarzenia = new com.example.rollapp.model.wydarzenia();
                czyjestwyglad(wydarzenia);

                wiedzmin_karta wiedzmin_karta = new wiedzmin_karta();
                updatekarte(wiedzmin_karta);
                i++;

                postac postac = new postac();
                setkoniecpostac(postac);
            }
        });

        koniec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i==0)
                {
                    Toast.makeText(wydarzenia.this, "Proszę naciśnij przycisk zapisz", Toast.LENGTH_SHORT).show();

                }
                else if(i<=4)
                {
                    Toast.makeText(wydarzenia.this, "Proszę naciśnij przycisk ZAPISZ jeszcze raz", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(wydarzenia.this, stronaglowna.class);
                    startActivity(intent);
                }
            }

        });
    }
}