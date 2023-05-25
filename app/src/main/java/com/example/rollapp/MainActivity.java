package com.example.rollapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollapp.model.mg;
import com.example.rollapp.model.user;
import com.example.rollapp.retrofit.mgApi;
import com.example.rollapp.retrofit.retrofitservice;
import com.example.rollapp.retrofit.userApi;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import at.favre.lib.crypto.bcrypt.BCrypt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button rejestracja;
    Button nologin;

    Button button;
    Button loginbtn;

    private EditText login;

    private EditText haslo;

    private CheckBox mgczy;

    private String nickzbazy;

    private String haslozbazy;

    private String haslohash2;

    private String nickmgzbazy;

    private String haslomgzbazy;

    private user dane = new user();

    private mg danemg = new mg();

    private static final String SHERED_PREFS = "daneuzyt";


    private String pobranieNickMG(mg mg)
    {

        retrofitservice rts = new retrofitservice();

        mgApi mgApi = rts.getRetrofit().create(mgApi.class);

        mgApi.nick(mg).enqueue(new Callback<ArrayList<mg>>() {
            @Override
            public void onResponse(Call<ArrayList<mg>> call, Response<ArrayList<mg>> response) {
                if(!response.body().isEmpty())
                {
                    nickmgzbazy = response.body().get(0).getNick();
                }
                else {
                    nickmgzbazy = "";
                }
            }

            @Override
            public void onFailure(Call<ArrayList<mg>> call, Throwable t) {
                Toast.makeText(MainActivity.this , "Nie udało się sprawdzić czy dany nick istnieje spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });

        return nickmgzbazy;
    }

    private String pobieraniehaslamg(mg mg)
    {
        retrofitservice rts = new retrofitservice();

        mgApi mgApi = rts.getRetrofit().create(mgApi.class);

        mgApi.haslo(mg).enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                if(response.body().isEmpty())
                {
                    haslomgzbazy = "error";
                }
                else {
                    haslomgzbazy = response.body().get(0);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                Toast.makeText(MainActivity.this , "Nie udało się sprawdzić czy dane haslo jest poprawne spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });

        return haslomgzbazy;
    }

    private String pobranieNick(user user)
    {

        retrofitservice rts = new retrofitservice();

        userApi userApi = rts.getRetrofit().create(userApi.class);

        userApi.nick(user).enqueue(new Callback<ArrayList<user>>() {
            @Override
            public void onResponse(Call<ArrayList<user>> call, Response<ArrayList<user>> response) {
                if(!response.body().isEmpty())
                {
                    nickzbazy = response.body().get(0).getNick();
                }
                else {
                    nickzbazy = "";
                }
            }

            @Override
            public void onFailure(Call<ArrayList<user>> call, Throwable t) {
                Toast.makeText(MainActivity.this , "Nie udało się sprawdzić czy dany nick istnieje spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });

        return nickzbazy;
    }

    private String pobieraniehasla(user user)
    {
        retrofitservice rts = new retrofitservice();

        userApi userApi = rts.getRetrofit().create(userApi.class);

        userApi.haslo(user).enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                if(response.body().isEmpty())
                {
                    haslozbazy = "error";
                }
                else {
                    haslozbazy = response.body().get(0);
                    Log.d("haslo", haslozbazy);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                Toast.makeText(MainActivity.this , "Nie udało się sprawdzić czy dane haslo jest poprawne spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });

        return haslozbazy;
    }

    private user pobierzusera(user user)
    {
        retrofitservice rts = new retrofitservice();
        userApi userApi = rts.getRetrofit().create(userApi.class);
        userApi.allinfo(user).enqueue(new Callback<ArrayList<user>>() {
            @Override
            public void onResponse(Call<ArrayList<user>> call, Response<ArrayList<user>> response) {
                if(response.body().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"błąd",Toast.LENGTH_SHORT).show();
                }
                else {
                    dane.setId(response.body().get(0).getId());
                    dane.setImie(response.body().get(0).getImie());
                    dane.setNazwisko(response.body().get(0).getNazwisko());
                    dane.setNick(response.body().get(0).getNick());
                    dane.setHaslo(response.body().get(0).getHaslo());
                    dane.setEmail(response.body().get(0).getEmail());
                    dane.setId_mg(response.body().get(0).getId_mg());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<user>> call, Throwable t) {
                Toast.makeText(MainActivity.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });

        return dane;
    }

    private mg pobierzmg(mg mg)
    {
        retrofitservice rts = new retrofitservice();
        mgApi mgApi = rts.getRetrofit().create(mgApi.class);
        mgApi.allinfo(mg).enqueue(new Callback<ArrayList<mg>>() {
            @Override
            public void onResponse(Call<ArrayList<mg>> call, Response<ArrayList<mg>> response) {
                if(response.body().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"błąd",Toast.LENGTH_SHORT).show();
                }
                else {
                    danemg.setId(response.body().get(0).getId());
                    danemg.setImie(response.body().get(0).getImie());
                    danemg.setNazwisko(response.body().get(0).getNazwisko());
                    danemg.setNick(response.body().get(0).getNick());
                    danemg.setHaslo(response.body().get(0).getHaslo());
                    danemg.setEmail(response.body().get(0).getEmail());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<mg>> call, Throwable t) {
                Toast.makeText(MainActivity.this , "Problem połączenia z serwerem spróbuj ponownie pózniej !!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });

        return danemg;
    }



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rejestracja = findViewById(R.id.registerbutton);
        rejestracja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, rejestracja.class);
                startActivity(intent);
            }
        });


        nologin = findViewById(R.id.nologinbutton);
        nologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Liczba_losowa.class);
                startActivity(intent);
            }
        });
        login = findViewById(R.id.login);
        haslo = findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbutton);
        mgczy = findViewById(R.id.czymggry);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mgczy.isChecked())
                {
                    String nazwa = login.getText().toString();
                    String haslohash = haslo.getText().toString();
                    user user = new user();
                    user.setNick(nazwa);
                    pobieraniehasla(user);
                    pobranieNick(user);
                    pobierzusera(user);
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    if (nazwa.isEmpty()) {
                                        Toast.makeText(MainActivity.this, "Login nie został podany", Toast.LENGTH_SHORT).show();
                                    } else {
                                        if (haslohash.isEmpty()) {
                                            Toast.makeText(MainActivity.this, "Hasło nie zostało podane", Toast.LENGTH_SHORT).show();
                                        } else {
                                            if (pobranieNick(user) == "") {
                                                Toast.makeText(MainActivity.this, "Użytkownik o podanym loginie nie istnieje", Toast.LENGTH_SHORT).show();
                                            } else {
                                                haslohash2 = BCrypt.withDefaults().hashToString(12, haslohash.trim().toCharArray());
                                                BCrypt.Result wynik = BCrypt.verifyer().verify(haslohash.toCharArray(), haslozbazy);
                                                if (wynik.verified) {

                                                    Intent intent = new Intent(MainActivity.this, stronaglowna.class);

                                                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                                                    SharedPreferences.Editor editor = sessionstorage.edit();
                                                    editor.clear();
                                                    editor.commit();
                                                    editor.putInt("id",dane.getId());
                                                    editor.putString("imie",dane.getImie());
                                                    editor.putString("nazwisko",dane.getNazwisko());
                                                    editor.putString("nick",dane.getNick());
                                                    editor.putString("email",dane.getEmail());
                                                    editor.putString("haslo",dane.getHaslo());
                                                    editor.putInt("idmg",dane.getId_mg());
                                                    editor.commit();
                                                    Toast.makeText(MainActivity.this, "Witaj " + sessionstorage.getString("nick","blad"), Toast.LENGTH_SHORT).show();
                                                    startActivity(intent);

                                                } else {
                                                    Toast.makeText(MainActivity.this, "Podane hasło jest niepoprawne !!!!", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                    }
                                }
                            },300);
                } else {
                    String nazwa = login.getText().toString();
                    String haslohash = haslo.getText().toString();
                    mg mg = new mg();
                    mg.setNick(nazwa);
                    pobieraniehaslamg(mg);
                    pobranieNickMG(mg);
                    pobierzmg(mg);
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    if (nazwa.isEmpty()) {
                                        Toast.makeText(MainActivity.this, "Login nie został podany", Toast.LENGTH_SHORT).show();
                                    } else {
                                        if (haslohash.isEmpty()) {
                                            Toast.makeText(MainActivity.this, "Hasło nie zostało podane", Toast.LENGTH_SHORT).show();
                                        } else {
                                            if (pobranieNickMG(mg) == "") {
                                                Toast.makeText(MainActivity.this, "Mistrz gry o podanym loginie nie istnieje", Toast.LENGTH_SHORT).show();
                                            } else {
                                                haslohash2 = BCrypt.withDefaults().hashToString(12, haslohash.trim().toCharArray());
                                                BCrypt.Result wynik = BCrypt.verifyer().verify(haslohash.toCharArray(), haslomgzbazy);
                                                if (wynik.verified) {

                                                    Toast.makeText(MainActivity.this, "Witaj " + nazwa + " Mistrzu Gry !!!", Toast.LENGTH_SHORT).show();

                                                    Intent intent = new Intent(MainActivity.this, stronaglownamg.class);

                                                    SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
                                                    SharedPreferences.Editor editor = sessionstorage.edit();
                                                    editor.clear();
                                                    editor.commit();
                                                    editor.putInt("id",danemg.getId());
                                                    editor.putString("imie",danemg.getImie());
                                                    editor.putString("nazwisko",danemg.getNazwisko());
                                                    editor.putString("nick",danemg.getNick());
                                                    editor.putString("email",danemg.getEmail());
                                                    editor.putString("haslo",danemg.getHaslo());
                                                    editor.putString("mg","tak");
                                                    editor.commit();
                                                    startActivity(intent);

                                                } else {
                                                    Toast.makeText(MainActivity.this, "Podane hasło jest niepoprawne !!!!", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                    }
                                }
                            },300);
                }
            }
        });
    }
}