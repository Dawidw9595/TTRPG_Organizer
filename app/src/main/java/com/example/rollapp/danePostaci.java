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

import com.example.rollapp.model.wiedzmin_karta;
import com.example.rollapp.retrofit.graApi;
import com.example.rollapp.retrofit.kartaApi;
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
        postacApi.save(postac).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(danePostaci.this, "Działa", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(danePostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    public void sprawdzczyjest(postac postac)
    {
        retrofitservice rts = new retrofitservice();
        postacApi postacApi = rts.getRetrofit().create(com.example.rollapp.retrofit.postacApi.class);
        postacApi.getpostac(postac).enqueue(new Callback<ArrayList<postac>>() {
            @Override
            public void onResponse(Call<ArrayList<postac>> call, Response<ArrayList<postac>> response) {
                if (response.body().isEmpty())
                {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    postac.setId_user(sessionstorage.getInt("id",0));
                    postac.setId_gry(1);
                    stworzpostac(postac);
                }
                else {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.putInt("idpostaci",response.body().get(0).getId());
                    editor.putInt("idgry",1);
                    editor.putInt("idkarty",response.body().get(0).getId_karty());
                    editor.putString("nazwapostaci",response.body().get(0).getNazwa_postaci());
                    editor.putString("plec",response.body().get(0).getPlec());
                    editor.putString("rasa",response.body().get(0).getRasa());
                    editor.putInt("wiek",response.body().get(0).getWiek());
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<postac>> call, Throwable t) {
                Toast.makeText(danePostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    public void modyfikuj(postac postac)
    {
        if (nazwa.getText().toString().isEmpty() ||
            plec.getText().toString().isEmpty() ||
            rasa.getText().toString().isEmpty() ||
            wiek.getText().toString().isEmpty())
        {
            Toast.makeText(danePostaci.this, "Pola nie mogą być puste", Toast.LENGTH_SHORT).show();
        }
        else {
            if (3<wiek.getText().toString().length())
            {
                Toast.makeText(danePostaci.this, "Wiek postanci nie może byc większy niż 1000", Toast.LENGTH_SHORT).show();
            } else {
               if (nazwa.getText().toString().contains("1") ||
                       nazwa.getText().toString().contains("2") ||
                       nazwa.getText().toString().contains("3") ||
                       nazwa.getText().toString().contains("4") ||
                       nazwa.getText().toString().contains("5") ||
                       nazwa.getText().toString().contains("6") ||
                       nazwa.getText().toString().contains("7") ||
                       nazwa.getText().toString().contains("8") ||
                       nazwa.getText().toString().contains("9") ||
                       nazwa.getText().toString().contains("0") )
               {
                   Toast.makeText(danePostaci.this, "Nazwa postaci nie może zawierać cyfr", Toast.LENGTH_SHORT).show();
               } else {
                   if (20<nazwa.getText().toString().length())
                   {
                       Toast.makeText(danePostaci.this, "Nazwa postaci nie może przekraczać 20 znaków", Toast.LENGTH_SHORT).show();
                   } else {
                       if (plec.getText().toString().contains("1") ||
                               plec.getText().toString().contains("2") ||
                               plec.getText().toString().contains("3") ||
                               plec.getText().toString().contains("4") ||
                               plec.getText().toString().contains("5") ||
                               plec.getText().toString().contains("6") ||
                               plec.getText().toString().contains("7") ||
                               plec.getText().toString().contains("8") ||
                               plec.getText().toString().contains("9") ||
                               plec.getText().toString().contains("0") )
                       {
                           Toast.makeText(danePostaci.this, "Nazwa płci nie może zawierać cyfr", Toast.LENGTH_SHORT).show();
                       } else {
                           if (15<plec.getText().toString().length())
                           {
                               Toast.makeText(danePostaci.this, "Nazwa płci nie może przekraczać 15 znakow", Toast.LENGTH_SHORT).show();
                           } else {
                               if (rasa.getText().toString().contains("1") ||
                                       rasa.getText().toString().contains("2") ||
                                       rasa.getText().toString().contains("3") ||
                                       rasa.getText().toString().contains("4") ||
                                       rasa.getText().toString().contains("5") ||
                                       rasa.getText().toString().contains("6") ||
                                       rasa.getText().toString().contains("7") ||
                                       rasa.getText().toString().contains("8") ||
                                       rasa.getText().toString().contains("9") ||
                                       rasa.getText().toString().contains("0"))
                               {
                                   Toast.makeText(danePostaci.this, "Nazwa rasy nie może zawierać znaków", Toast.LENGTH_SHORT).show();
                               } else {
                                   if (20<rasa.getText().toString().length())
                                   {
                                       Toast.makeText(danePostaci.this, "Nazwa rasy nie może przekraczać 20 znaków", Toast.LENGTH_SHORT).show();
                                   } else {
                                       if (wiek.getText().toString().equals("0"))
                                       {
                                           Toast.makeText(danePostaci.this, "Postać nie może mieć 0 lat", Toast.LENGTH_SHORT).show();
                                       } else {
                                           retrofitservice rts = new retrofitservice();
                                           postacApi postacApi = rts.getRetrofit().create(com.example.rollapp.retrofit.postacApi.class);
                                           postacApi.setall(postac).enqueue(new Callback<Void>() {
                                               @Override
                                               public void onResponse(Call<Void> call, Response<Void> response) {
                                                   SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                                                   SharedPreferences.Editor editor = sessionstorage.edit();
                                                   editor.putString("nazwapostaci",postac.getNazwa_postaci());
                                                   editor.putString("plec",postac.getPlec());
                                                   editor.putString("rasa",postac.getRasa());
                                                   editor.putInt("wiek",postac.getWiek());
                                                   editor.commit();
                                                   Toast.makeText(danePostaci.this, "Operacja powiodła się", Toast.LENGTH_SHORT).show();

                                               }

                                               @Override
                                               public void onFailure(Call<Void> call, Throwable t) {
                                                   Toast.makeText(danePostaci.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                                                   Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                                               }
                                           });
                                       }
                                   }
                               }
                           }
                       }
                   }
               }
            }
        }
    }

    public void createcard(wiedzmin_karta wiedzmin_karta)
    {
        retrofitservice rts = new retrofitservice();
        kartaApi kartaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.kartaApi.class);
        kartaApi.save(wiedzmin_karta).enqueue(new Callback<Void>() {
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
    public void czyjestkarta(wiedzmin_karta wiedzmin_karta)
    {
        retrofitservice rts = new retrofitservice();
        kartaApi kartaApi = rts.getRetrofit().create(com.example.rollapp.retrofit.kartaApi.class);
        kartaApi.czyjest(wiedzmin_karta).enqueue(new Callback<ArrayList<wiedzmin_karta>>() {
            @Override
            public void onResponse(Call<ArrayList<wiedzmin_karta>> call, Response<ArrayList<wiedzmin_karta>> response) {
                if (response.body().isEmpty())
                {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    wiedzmin_karta.setId_postaci(sessionstorage.getInt("idpostaci",0));
                    createcard(wiedzmin_karta);
                }
                else {
                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                    SharedPreferences.Editor editor = sessionstorage.edit();
                    editor.putInt("idkarty",response.body().get(0).getId());
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<wiedzmin_karta>> call, Throwable t) {
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

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);

        doCech = findViewById(R.id.doCech);

        nazwa = findViewById(R.id.nazwa_postaci);
        plec = findViewById(R.id.plec);
        rasa = findViewById(R.id.rasa);
        wiek = findViewById(R.id.wiek);

        zapisz = findViewById(R.id.zapisdane);

        gra gra = new gra();
        gra.setNazwa("Wiedźmin");
        czyistnieje(gra);

        postac postac = new postac();
        postac.setId_user(sessionstorage.getInt("id",0));
        sprawdzczyjest(postac);

        if (sessionstorage.getInt("idkarta",0)==0)
        {
            nazwa.setText("");
            plec.setText("");
            rasa.setText("");
            wiek.setText("");
        }
        else {
            nazwa.setText(sessionstorage.getString("nazwapostaci","blad"));
            plec.setText(sessionstorage.getString("plec","blad"));
            rasa.setText(sessionstorage.getString("rasa","blad"));
            wiek.setText(String.valueOf(sessionstorage.getInt("wiek",0)));
        }

        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    wiedzmin_karta karta = new wiedzmin_karta();
                    karta.setId_postaci(sessionstorage.getInt("idpostaci",0));
                    czyjestkarta(karta);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            postac.setId(sessionstorage.getInt("idpostaci",0));
                            postac.setId_karty(sessionstorage.getInt("idkarty",0));
                            postac.setId_user(sessionstorage.getInt("id",0));
                            postac.setId_gry(sessionstorage.getInt("idgry",1));
                            postac.setNazwa_postaci(nazwa.getText().toString());
                            postac.setPlec(plec.getText().toString());
                            postac.setRasa(rasa.getText().toString());
                            postac.setWiek(Integer.valueOf(wiek.getText().toString()));
                            modyfikuj(postac);
                        }
                    },300);
            }
        });
        doCech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(danePostaci.this, cechyPostaci.class);
                wiedzmin_karta karta = new wiedzmin_karta();
                karta.setId_postaci(sessionstorage.getInt("idpostaci",0));
                czyjestkarta(karta);
                startActivity(intent);
            }

        });
    }

}