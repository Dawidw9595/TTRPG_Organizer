package com.example.rollapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollapp.model.user;
import com.example.rollapp.retrofit.retrofitservice;
import com.example.rollapp.retrofit.userApi;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button rejestracja;
    Button nologin;
    Button test;
    Button button;
    Button loginbtn;

    private EditText login;

    private EditText haslo;

    private String zbazy;

    private String haslozbazy;


    private String pobranieNick(user user)
    {

        retrofitservice rts = new retrofitservice();

        userApi userApi = rts.getRetrofit().create(userApi.class);

        userApi.nick(user).enqueue(new Callback<ArrayList<user>>() {
            @Override
            public void onResponse(Call<ArrayList<user>> call, Response<ArrayList<user>> response) {
                if(!response.body().isEmpty())
                {
                    zbazy = response.body().get(0).getNick();
                }
                else {
                    zbazy = "";
                    Toast.makeText(MainActivity.this, "Użytkownik o podanym loginie nie istnieje", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<user>> call, Throwable t) {
                Toast.makeText(MainActivity.this , "Nie udało się sprawdzić czy dany nick istnieje spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });

        return zbazy;
    }

    private String pobieraniehasla(user user)
    {
        retrofitservice rts = new retrofitservice();

        userApi userApi = rts.getRetrofit().create(userApi.class);

        userApi.haslo(user).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(!response.body().isEmpty())
                {
                    haslozbazy = response.body();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this , "Nie udało się pobrać hasła z bazy spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });

        return haslozbazy;
    }


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
        test = findViewById(R.id.button);


        String nazwa = "Wiedzmin";
        Integer gracz = 1;
        Integer gra = 1;

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nazwa = login.getText().toString();
                String haslohash = haslo.getText().toString();

                user user = new user();
                user.setNick(nazwa);

                if (nazwa.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Login nie został podany", Toast.LENGTH_SHORT).show();
                } else {
                    if (haslohash.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Hasło nie zostało podane", Toast.LENGTH_SHORT).show();
                    } else if (pobranieNick(user) == "") {
                    } else {

                        pobieraniehasla(user);
                        Toast.makeText(MainActivity.this,haslozbazy,Toast.LENGTH_LONG).show();

                        //BCrypt.Result wynik = BCrypt.verifyer().verify(haslohash.toCharArray(), String.valueOf(myDB.haslo(nazwa.trim())));
                        if (1!=1) {
                            //Intent intent = new Intent(MainActivity.this, stronaglowna.class);
                            //startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Hasło jest niepoprawne", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
        });
    }
}