package com.example.rollapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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


public class zmianadanychuzyt extends AppCompatActivity {

    private Integer id;
    private TextView imie;
    private TextView nazwisko;
    private TextView nick;
    private TextView email;

    private EditText noweimie;

    private EditText nowenazwisko;

    private EditText nowenick;

    private EditText nowehalo;

    private EditText noweemial;

    private String nickzbazy;

    private String emailzbazy;

    private String tmphaslo;

    private static final String SHERED_PREFS = "daneuzyt";

    private String mgj;

    Button bimie;
    Button bnazwisko;
    Button bnick;
    Button bemail;
    Button bhaslo;

    private String nick(user user)
    {
        retrofitservice rts = new retrofitservice();
        userApi userApi = rts.getRetrofit().create(userApi.class);
        userApi.czyjest(user).enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                if(response.body().isEmpty())
                {
                    nickzbazy= "";
                } else {
                    nickzbazy = "jest";
                }
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                Toast.makeText(zmianadanychuzyt.this , "Nie udało się sprawdzić czy dany nick znajduje się w bazie spróbuj ponownie póżniej" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });

        return nickzbazy;
    }

    private String email(user user)
    {
        retrofitservice rts = new retrofitservice();
        userApi userApi = rts.getRetrofit().create(com.example.rollapp.retrofit.userApi.class);
        userApi.czyjestemail(user).enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                if(response.body().isEmpty())
                {
                    emailzbazy = "";
                }
                else{
                    emailzbazy = "jest";
                }
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                Toast.makeText(zmianadanychuzyt.this , "Nie udało się sprawdzić czy dany email znajduje się w bazie spróbuj ponownie póżniej" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
        return emailzbazy;
    }

    private void zmianaimienia(user user)
    {
        if(noweimie.getText().toString().equals(""))
        {
            Toast.makeText(zmianadanychuzyt.this, "Pole zmiany imienia nie może byc puste", Toast.LENGTH_SHORT).show();
        }
        else {
            if(noweimie.getText().toString().contains("0") ||
                    noweimie.getText().toString().contains("1") ||
                    noweimie.getText().toString().contains("2") ||
                    noweimie.getText().toString().contains("3") ||
                    noweimie.getText().toString().contains("4") ||
                    noweimie.getText().toString().contains("5") ||
                    noweimie.getText().toString().contains("6") ||
                    noweimie.getText().toString().contains("7") ||
                    noweimie.getText().toString().contains("8") ||
                    noweimie.getText().toString().contains("9"))
            {
                Toast.makeText(zmianadanychuzyt.this, "Imię nie może zawierać cyfr",Toast.LENGTH_SHORT).show();
            }
            else {
                retrofitservice rts = new retrofitservice();
                userApi userApi = rts.getRetrofit().create(userApi.class);
                userApi.changename(user).enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        Intent intent = new Intent(zmianadanychuzyt.this,zmianadanychuzyt.class);
                        Toast.makeText(zmianadanychuzyt.this, "Twoje imię zostało zmienione", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText(zmianadanychuzyt.this , "Nie udało się zmienić imienia w bazie spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }

    }

    private void zmiananazwiska(user user)
    {
        if(nowenazwisko.getText().toString().equals(""))
        {
            Toast.makeText(zmianadanychuzyt.this, "Pole zmiany nazwiska nie może byc puste !!!!", Toast.LENGTH_SHORT).show();
        }
        else {
            if (nowenazwisko.getText().toString().contains("0") ||
                    nowenazwisko.getText().toString().contains("1") ||
                    nowenazwisko.getText().toString().contains("2") ||
                    nowenazwisko.getText().toString().contains("3") ||
                    nowenazwisko.getText().toString().contains("4") ||
                    nowenazwisko.getText().toString().contains("5") ||
                    nowenazwisko.getText().toString().contains("6") ||
                    nowenazwisko.getText().toString().contains("7") ||
                    nowenazwisko.getText().toString().contains("8") ||
                    nowenazwisko.getText().toString().contains("9") )
            {
                Toast.makeText(zmianadanychuzyt.this, "Nazwisko nie może zawierać cyfr",Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                userApi userApi = rts.getRetrofit().create(userApi.class);
                userApi.changesurname(user).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Intent intent = new Intent(zmianadanychuzyt.this,zmianadanychuzyt.class);
                        Toast.makeText(zmianadanychuzyt.this, "Twoje nazwisko zostało zmienione", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(zmianadanychuzyt.this , "Nie udało się zmienić nazwiska w bazie spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }
    private void zmiananicku(user user)
    {
        nick(user);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (nowenick.getText().toString().equals(""))
                {
                    Toast.makeText(zmianadanychuzyt.this, "Pole zmiany nicku nie może byc puste !!!!", Toast.LENGTH_SHORT).show();
                } else {
                    if(5>nowenick.getText().toString().length() || 15<nowenick.getText().toString().length())
                    {
                        Toast.makeText(zmianadanychuzyt.this, "Nick powinien zawierać od 5 do 15 znaków ",Toast.LENGTH_SHORT).show();
                    } else {
                        if(!nickzbazy.equals(""))
                        {
                            Toast.makeText(zmianadanychuzyt.this, "Podany nick jest już zajęty proszę podać inny !!!!", Toast.LENGTH_SHORT).show();
                        } else {
                            retrofitservice rts = new retrofitservice();
                            userApi userApi = rts.getRetrofit().create(com.example.rollapp.retrofit.userApi.class);
                            userApi.changenick(user).enqueue(new Callback<Void>() {
                                @Override
                                public void onResponse(Call<Void> call, Response<Void> response) {
                                    Intent intent = new Intent(zmianadanychuzyt.this,zmianadanychuzyt.class);
                                    Toast.makeText(zmianadanychuzyt.this, "Twoje nick został zmieniony", Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                }

                                @Override
                                public void onFailure(Call<Void> call, Throwable t) {
                                    Toast.makeText(zmianadanychuzyt.this , "Nie udało się zmienić nicku w bazie spróbuj ponownie póżniej" , Toast.LENGTH_LONG).show();
                                    Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                                }
                            });
                        }
                    }
                }
            }
        },300);
    }

    private void zmianamaila(user user)
    {
        email(user);

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(noweemial.getText().toString().equals("")) {
                    Toast.makeText(zmianadanychuzyt.this, "Pole zmiany email nie może byc puste", Toast.LENGTH_SHORT).show();
                } else {
                    if(!noweemial.getText().toString().contains("@") ||
                            !noweemial.getText().toString().contains("."))
                    {
                        Toast.makeText(zmianadanychuzyt.this, "Podany e-mail jest niepoprawny",Toast.LENGTH_SHORT).show();
                    } else {
                        if(emailzbazy != "")
                        {
                            Toast.makeText(zmianadanychuzyt.this, "Podany email znajduje się już w bazie , proszę o podanie innego emaila", Toast.LENGTH_LONG).show();
                        } else {
                            retrofitservice rts = new retrofitservice();
                            userApi userApi = rts.getRetrofit().create(com.example.rollapp.retrofit.userApi.class);
                            userApi.changeemail(user).enqueue(new Callback<Void>() {
                                @Override
                                public void onResponse(Call<Void> call, Response<Void> response) {
                                    Intent intent = new Intent(zmianadanychuzyt.this,zmianadanychuzyt.class);
                                    Toast.makeText(zmianadanychuzyt.this, "Twój emial został zmieniony !!!!", Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                }

                                @Override
                                public void onFailure(Call<Void> call, Throwable t) {
                                    Toast.makeText(zmianadanychuzyt.this , "Nie udało się zmienić emiala w bazie spróbuj ponownie póżniej" , Toast.LENGTH_LONG).show();
                                    Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                                }
                            });
                        }
                    }
                }
            }
        },300);
    }

    private void zmianahasla(user user)
    {
        if(nowehalo.getText().toString().equals(""))
        {
            Toast.makeText(zmianadanychuzyt.this, "Pole zmiany hasła nie może być puste", Toast.LENGTH_SHORT).show();
        } else {
            retrofitservice rts = new retrofitservice();
            userApi userApi = rts.getRetrofit().create(com.example.rollapp.retrofit.userApi.class);
            userApi.changepass(user).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Intent intent = new Intent(zmianadanychuzyt.this,MainActivity.class);
                    Toast.makeText(zmianadanychuzyt.this, "Twoje hasło zostało zmienione, zostałeś wylogowany ! ", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(zmianadanychuzyt.this , "Nie udało się zmienić twojego hasła w bazie spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                    Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                }
            });
        }
    }

    private String nick(mg mg)
    {
        retrofitservice rts = new retrofitservice();
        mgApi mgApi = rts.getRetrofit().create(com.example.rollapp.retrofit.mgApi.class);

        mgApi.czyjest(mg).enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                if(response.body().isEmpty())
                {
                    nickzbazy = "";
                }
                else {
                    nickzbazy = "jest";
                }
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                Toast.makeText(zmianadanychuzyt.this , "Nie udało się sprawdzić czy dany nick znajduje się w bazie spróbuj ponownie póżniej" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
        return nickzbazy;
    }

    private String email(mg mg)
    {
        retrofitservice rts = new retrofitservice();
        mgApi mgApi = rts.getRetrofit().create(com.example.rollapp.retrofit.mgApi.class);

        mgApi.czyjestemail(mg).enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                if (response.body().isEmpty())
                {
                    emailzbazy = "";
                }else {
                    emailzbazy = "jest";
                }
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                Toast.makeText(zmianadanychuzyt.this , "Nie udało się sprawdzić czy dany email znajduje się w bazie spróbuj ponownie póżniej" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
        return emailzbazy;
    }

    private void zmianaimieniamg(mg mg)
    {
        if(noweimie.getText().toString().equals(""))
        {
            Toast.makeText(zmianadanychuzyt.this, "Pole zmiany imienia nie może byc puste", Toast.LENGTH_SHORT).show();
        }
        else {
            if(noweimie.getText().toString().contains("0") ||
                    noweimie.getText().toString().contains("1") ||
                    noweimie.getText().toString().contains("2") ||
                    noweimie.getText().toString().contains("3") ||
                    noweimie.getText().toString().contains("4") ||
                    noweimie.getText().toString().contains("5") ||
                    noweimie.getText().toString().contains("6") ||
                    noweimie.getText().toString().contains("7") ||
                    noweimie.getText().toString().contains("8") ||
                    noweimie.getText().toString().contains("9"))
            {
                Toast.makeText(zmianadanychuzyt.this, "Imię nie może zawierać cyfr",Toast.LENGTH_SHORT).show();
            }
            else {
                retrofitservice rts = new retrofitservice();
                mgApi mgApi = rts.getRetrofit().create(mgApi.class);
                mgApi.changename(mg).enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        Intent intent = new Intent(zmianadanychuzyt.this,zmianadanychuzyt.class);
                        Toast.makeText(zmianadanychuzyt.this, "Twoje imię zostało zmienione", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText(zmianadanychuzyt.this , "Nie udało się zmienić imienia w bazie spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    private void zmiananazwiskamg(mg mg)
    {
        if(nowenazwisko.getText().toString().equals(""))
        {
            Toast.makeText(zmianadanychuzyt.this, "Pole zmiany nazwiska nie może byc puste !!!!", Toast.LENGTH_SHORT).show();
        }
        else {
            if (nowenazwisko.getText().toString().contains("0") ||
                    nowenazwisko.getText().toString().contains("1") ||
                    nowenazwisko.getText().toString().contains("2") ||
                    nowenazwisko.getText().toString().contains("3") ||
                    nowenazwisko.getText().toString().contains("4") ||
                    nowenazwisko.getText().toString().contains("5") ||
                    nowenazwisko.getText().toString().contains("6") ||
                    nowenazwisko.getText().toString().contains("7") ||
                    nowenazwisko.getText().toString().contains("8") ||
                    nowenazwisko.getText().toString().contains("9") )
            {
                Toast.makeText(zmianadanychuzyt.this, "Nazwisko nie może zawierać cyfr",Toast.LENGTH_SHORT).show();
            } else {
                retrofitservice rts = new retrofitservice();
                mgApi mgApi = rts.getRetrofit().create(mgApi.class);
                mgApi.changesurname(mg).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Intent intent = new Intent(zmianadanychuzyt.this,zmianadanychuzyt.class);
                        Toast.makeText(zmianadanychuzyt.this, "Twoje nazwisko zostało zmienione", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(zmianadanychuzyt.this , "Nie udało się zmienić nazwiska w bazie spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                        Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                    }
                });
            }
        }
    }

    private void zmiananickumg(mg mg)
    {
        nick(mg);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (nowenick.getText().toString().equals(""))
                {
                    Toast.makeText(zmianadanychuzyt.this, "Pole zmiany nicku nie może byc puste !!!!", Toast.LENGTH_SHORT).show();
                } else {
                    if(5>nowenick.getText().toString().length() || 15<nowenick.getText().toString().length())
                    {
                        Toast.makeText(zmianadanychuzyt.this, "Nick powinien zawierać od 5 do 15 znaków ",Toast.LENGTH_SHORT).show();
                    } else {
                        if(!nickzbazy.equals(""))
                        {
                            Toast.makeText(zmianadanychuzyt.this, "Podany nick jest już zajęty proszę podać inny !!!!", Toast.LENGTH_SHORT).show();
                        } else {
                            retrofitservice rts = new retrofitservice();
                            mgApi mgApi = rts.getRetrofit().create(com.example.rollapp.retrofit.mgApi.class);
                            mgApi.changenick(mg).enqueue(new Callback<Void>() {
                                @Override
                                public void onResponse(Call<Void> call, Response<Void> response) {
                                    Intent intent = new Intent(zmianadanychuzyt.this,zmianadanychuzyt.class);
                                    Toast.makeText(zmianadanychuzyt.this, "Twoje nick został zmieniony", Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                }

                                @Override
                                public void onFailure(Call<Void> call, Throwable t) {
                                    Toast.makeText(zmianadanychuzyt.this , "Nie udało się zmienić nicku w bazie spróbuj ponownie póżniej" , Toast.LENGTH_LONG).show();
                                    Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                                }
                            });
                        }
                    }
                }
            }
        },300);
    }

    private void zmianaemailamg(mg mg)
    {
        email(mg);

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(noweemial.getText().toString().equals("")) {
                    Toast.makeText(zmianadanychuzyt.this, "Pole zmiany email nie może byc puste", Toast.LENGTH_SHORT).show();
                } else {
                    if(!noweemial.getText().toString().contains("@") ||
                            !noweemial.getText().toString().contains("."))
                    {
                        Toast.makeText(zmianadanychuzyt.this, "Podany e-mail jest niepoprawny",Toast.LENGTH_SHORT).show();
                    } else {
                        if(emailzbazy != "")
                        {
                            Toast.makeText(zmianadanychuzyt.this, "Podany email znajduje się już w bazie , proszę o podanie innego emaila", Toast.LENGTH_LONG).show();
                        } else {
                            retrofitservice rts = new retrofitservice();
                            mgApi mgApi = rts.getRetrofit().create(com.example.rollapp.retrofit.mgApi.class);
                            mgApi.changeemail(mg).enqueue(new Callback<Void>() {
                                @Override
                                public void onResponse(Call<Void> call, Response<Void> response) {
                                    Intent intent = new Intent(zmianadanychuzyt.this,zmianadanychuzyt.class);
                                    Toast.makeText(zmianadanychuzyt.this, "Twój emial został zmieniony !!!!", Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                }

                                @Override
                                public void onFailure(Call<Void> call, Throwable t) {
                                    Toast.makeText(zmianadanychuzyt.this , "Nie udało się zmienić emiala w bazie spróbuj ponownie póżniej" , Toast.LENGTH_LONG).show();
                                    Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                                }
                            });
                        }
                    }
                }
            }
        },300);
    }

    private void zmianahaslamg(mg mg)
    {
        if(nowehalo.getText().toString().equals(""))
        {
            Toast.makeText(zmianadanychuzyt.this, "Pole zmiany hasła nie może być puste", Toast.LENGTH_SHORT).show();
        } else {
            retrofitservice rts = new retrofitservice();
            mgApi mgApi = rts.getRetrofit().create(com.example.rollapp.retrofit.mgApi.class);
            mgApi.changepass(mg).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Intent intent = new Intent(zmianadanychuzyt.this,MainActivity.class);
                    Toast.makeText(zmianadanychuzyt.this, "Twoje hasło zostało zmienione, zostałeś wylogowany ! ", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(zmianadanychuzyt.this , "Nie udało się zmienić twojego hasła w bazie spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                    Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
                }
            });
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ativity_zmianabaza);

        noweimie = findViewById(R.id.p1);
        nowenazwisko = findViewById(R.id.p2);
        nowenick = findViewById(R.id.p3);
        noweemial = findViewById(R.id.p4);
        nowehalo = findViewById(R.id.p5);

        imie = findViewById(R.id.i1);
        nazwisko = findViewById(R.id.n2);
        nick = findViewById(R.id.n3);
        email = findViewById(R.id.e4);

        bimie = findViewById(R.id.b1);
        bnazwisko = findViewById(R.id.b2);
        bnick = findViewById(R.id.b3);
        bemail = findViewById(R.id.b4);
        bhaslo = findViewById(R.id.b5);

        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        SharedPreferences.Editor editor = sessionstorage.edit();

        mgj =sessionstorage.getString("mg","nie");

        if (mgj != "nie")
        {
            id = sessionstorage.getInt("id",0);
            imie.setText(sessionstorage.getString("imie","Błąd"));
            nazwisko.setText(sessionstorage.getString("nazwisko","Błąd"));
            nick.setText(sessionstorage.getString("nick","Błąd"));
            email.setText(sessionstorage.getString("email","Błąd"));

            bimie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mg mg = new mg();
                    mg.setId(id);
                    mg.setImie(noweimie.getText().toString());
                    editor.putString("imie",noweimie.getText().toString());
                    editor.commit();
                    zmianaimieniamg(mg);
                }
            });

            bnazwisko.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mg mg = new mg();
                    mg.setId(id);
                    mg.setNazwisko(nowenazwisko.getText().toString());
                    editor.putString("nazwisko",nowenazwisko.getText().toString());
                    editor.commit();
                    zmiananazwiskamg(mg);
                }
            });

            bnick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mg mg = new mg();
                    mg.setId(id);
                    mg.setNick(nowenick.getText().toString());
                    editor.putString("nick",nowenick.getText().toString());
                    editor.commit();
                    zmiananickumg(mg);
                }
            });

            bemail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mg mg = new mg();
                    mg.setId(id);
                    mg.setEmail(noweemial.getText().toString());
                    editor.putString("email",noweemial.getText().toString());
                    editor.commit();
                    zmianaemailamg(mg);
                }
            });

            bhaslo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    tmphaslo =BCrypt.withDefaults().hashToString(12,nowehalo.getText().toString().toCharArray());
                    mg mg = new mg();
                    mg.setId(id);
                    mg.setHaslo(tmphaslo);
                    editor.putString("haslo",tmphaslo);
                    editor.commit();
                    zmianahaslamg(mg);
                    tmphaslo = "";
                }
            });
        } else {

            id = sessionstorage.getInt("id",0);
            imie.setText(sessionstorage.getString("imie","Błąd"));
            nazwisko.setText(sessionstorage.getString("nazwisko","Błąd"));
            nick.setText(sessionstorage.getString("nick","Błąd"));
            email.setText(sessionstorage.getString("email","Błąd"));

            bimie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    user user = new user();
                    user.setId(id);
                    user.setImie(noweimie.getText().toString());
                    editor.putString("imie",noweimie.getText().toString());
                    editor.commit();
                    zmianaimienia(user);
                }
            });

            bnazwisko.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    user user = new user();
                    user.setId(id);
                    user.setNazwisko(nowenazwisko.getText().toString());
                    editor.putString("nazwisko",nowenazwisko.getText().toString());
                    editor.commit();
                    zmiananazwiska(user);
                }
            });

            bnick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    user user = new user();
                    user.setId(id);
                    user.setNick(nowenick.getText().toString());
                    editor.putString("nick",nowenick.getText().toString());
                    editor.commit();
                    zmiananicku(user);
                }
            });

            bemail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    user user = new user();
                    user.setId(id);
                    user.setEmail(noweemial.getText().toString());
                    editor.putString("email",noweemial.getText().toString());
                    editor.commit();
                    zmianamaila(user);
                }
            });

            bhaslo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    tmphaslo =BCrypt.withDefaults().hashToString(12,nowehalo.getText().toString().toCharArray());
                    user user = new user();
                    user.setId(id);
                    user.setHaslo(tmphaslo);
                    editor.putString("haslo",tmphaslo);
                    editor.commit();
                    zmianahasla(user);
                    tmphaslo = "";
                }
            });

        }

    }

}
