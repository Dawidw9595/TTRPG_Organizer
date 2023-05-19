package com.example.rollapp;

import android.annotation.SuppressLint;
import android.content.Intent;
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

<<<<<<< Updated upstream
=======
<<<<<<< HEAD
    private user dane = new user();

    private mg danemg = new mg();

=======
>>>>>>> 81568e8100a3d23a5a36b7788c085541bdc1a7df
>>>>>>> Stashed changes
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
                    dane.setImie(response.body().get(0).getImie());
                    dane.setNazwisko(response.body().get(0).getNazwisko());
                    dane.setNick(response.body().get(0).getNick());
                    dane.setHaslo(response.body().get(0).getHaslo());
                    dane.setEmail(response.body().get(0).getEmail());
                }
            }

<<<<<<< Updated upstream
=======
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


>>>>>>> Stashed changes
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

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, umGracjaPostaci.class);
                startActivity(intent);
            }
        });

        nologin = findViewById(R.id.nologinbutton);
        nologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, nologin.class);
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
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
                    pobierzusera(user);
=======
>>>>>>> 81568e8100a3d23a5a36b7788c085541bdc1a7df
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

                                                    Toast.makeText(MainActivity.this, "Witaj " + nazwa, Toast.LENGTH_SHORT).show();

                                                    Intent intent = new Intent(MainActivity.this, stronaglowna.class);
                                                    startActivity(intent);

=======
<<<<<<< HEAD
                                                    Toast.makeText(MainActivity.this, "Witaj " + nazwa, Toast.LENGTH_SHORT).show();

                                                    Intent intent = new Intent(MainActivity.this, stronaglowna.class);
                                                    intent.putExtra("imie" , dane.getImie());
                                                    intent.putExtra("nazwisko" , dane.getNazwisko());
                                                    intent.putExtra("nick" , dane.getNick());
                                                    intent.putExtra("haslo" , dane.getHaslo());
                                                    intent.putExtra("email" , dane.getEmail());
                                                    startActivity(intent);
=======

                                                    Toast.makeText(MainActivity.this, "Witaj " + nazwa, Toast.LENGTH_SHORT).show();

                                                    Intent intent = new Intent(MainActivity.this, stronaglowna.class);
                                                    startActivity(intent);

>>>>>>> 81568e8100a3d23a5a36b7788c085541bdc1a7df
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
                    pobierzmg(mg);
=======
>>>>>>> 81568e8100a3d23a5a36b7788c085541bdc1a7df
>>>>>>> Stashed changes
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

                                                    Intent intent = new Intent(MainActivity.this, stronaglowna.class);
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
                                                    intent.putExtra("imie" , danemg.getImie());
                                                    intent.putExtra("nazwisko" , danemg.getNazwisko());
                                                    intent.putExtra("nick" , danemg.getNick());
                                                    intent.putExtra("haslo" , danemg.getHaslo());
                                                    intent.putExtra("email" , danemg.getEmail());
=======
>>>>>>> 81568e8100a3d23a5a36b7788c085541bdc1a7df
>>>>>>> Stashed changes
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