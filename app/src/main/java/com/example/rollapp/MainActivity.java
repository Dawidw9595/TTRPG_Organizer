package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class MainActivity extends AppCompatActivity {

    Button rejestracja;
    Button nologin;

    Button loginbtn;

    private baza myDB;
    private EditText login;

    private EditText haslo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rejestracja=findViewById(R.id.registerbutton);
        rejestracja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,rejestracja.class);
                startActivity(intent);
            }
        });

        nologin=findViewById(R.id.nologinbutton);
                nologin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, nologin.class);
                        startActivity(intent);
                    }
                });
        login=findViewById(R.id.login);
        haslo=findViewById(R.id.password);
        loginbtn=findViewById(R.id.loginbutton);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baza myDB = new baza(MainActivity.this);
                String nazwa=login.getText().toString();
                String haslohash=haslo.getText().toString();

                if(nazwa.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Login nie został podany", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(haslohash.isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Hasło nie zostało podane", Toast.LENGTH_SHORT).show();
                    }
                    else
                    if(0 == myDB.login(nazwa.trim()))
                    {
                        Toast.makeText(MainActivity.this, "Użytkownik o podanym loginie nie istnieje", Toast.LENGTH_SHORT).show();
                    }
                    else
                   {

                        BCrypt.Result wynik = BCrypt.verifyer().verify(haslohash.toCharArray(),String.valueOf(myDB.haslo(nazwa.trim())));
                        if(wynik.verified)
                        {
                            Intent intent = new Intent(MainActivity.this,stronaglowna.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Hasło jest niepoprawne !!!",Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
        });
    }
}