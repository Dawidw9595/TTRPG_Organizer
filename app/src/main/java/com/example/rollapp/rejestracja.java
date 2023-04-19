package com.example.rollapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class rejestracja extends AppCompatActivity {

    private EditText imie;
    private EditText nazwisko;
    private EditText nick;
    private EditText haslo1;
    private EditText haslo2;
    private EditText email;
    Button rejestracja;

    private String passworhash;

    private baza myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);
        Toast.makeText(rejestracja.this, "Wszystkie pola są wymagane",Toast.LENGTH_LONG).show();
        rejestracja=findViewById(R.id.rejestracja);

        imie=findViewById(R.id.imie);
        nazwisko=findViewById(R.id.nazwisko);
        nick=findViewById(R.id.login);
        haslo1=findViewById(R.id.haslo1);
        haslo2=findViewById(R.id.haslo2);
        email=findViewById(R.id.email);

        baza myDB = new baza(rejestracja.this);

        rejestracja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(imie.getText().toString().equals("") || nazwisko.getText().toString().equals("") || nick.getText().toString().equals("") || haslo1.getText().toString().equals("") || haslo2.getText().toString().equals("") || email.getText().toString().equals("") )
                {
                    Toast.makeText(rejestracja.this, "Nie uzupełniono któregoś z pól",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(5>nick.getText().toString().length() || 15<nick.getText().toString().length())
                    {
                        Toast.makeText(rejestracja.this, "Login powinien zawierać od 5 do 15 znaków ",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if (1 == myDB.login(nick.getText().toString().trim()))
                        {
                            Toast.makeText(rejestracja.this, "Podany Login jest już zajęty",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            if(haslo1.getText().toString().equals(haslo2.getText().toString()))
                            {
                                if(5>haslo1.getText().toString().length())
                                {
                                    Toast.makeText(rejestracja.this, "Hasło powinno zawierać przynajmniej 5 znaków",Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    if(imie.getText().toString().contains("0") || imie.getText().toString().contains("1") || imie.getText().toString().contains("2") || imie.getText().toString().contains("3") || imie.getText().toString().contains("4") || imie.getText().toString().contains("5") || imie.getText().toString().contains("6") || imie.getText().toString().contains("7") || imie.getText().toString().contains("8") || imie.getText().toString().contains("9"))
                                    {
                                        Toast.makeText(rejestracja.this, "Imię nie może zawierać cyfr",Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        if (nazwisko.getText().toString().contains("0") || nazwisko.getText().toString().contains("1") || nazwisko.getText().toString().contains("2") || nazwisko.getText().toString().contains("3") || nazwisko.getText().toString().contains("4") || nazwisko.getText().toString().contains("5") || nazwisko.getText().toString().contains("6") || nazwisko.getText().toString().contains("7") || nazwisko.getText().toString().contains("8") || nazwisko.getText().toString().contains("9") )
                                        {
                                            Toast.makeText(rejestracja.this, "Nazwisko nie może zawierać cyfr",Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            if(!email.getText().toString().contains("@") || !email.getText().toString().contains(".") || !email.getText().toString().contains(".") || !email.getText().toString().contains("."))
                                            {
                                                Toast.makeText(rejestracja.this, "Podany e-mail jest niepoprawny",Toast.LENGTH_SHORT).show();
                                            }
                                            else
                                            {
                                                if(1 == myDB.mail(email.getText().toString().trim()))
                                                {
                                                    Toast.makeText(rejestracja.this, "Użytkownik o takim adresie e-mail już istnieje",Toast.LENGTH_SHORT).show();
                                                }
                                                else
                                                {
                                                    passworhash = BCrypt.withDefaults().hashToString(12,haslo1.getText().toString().toCharArray());
                                                    myDB.addUser(imie.getText().toString().trim(),
                                                            nazwisko.getText().toString().trim(),
                                                            nick.getText().toString().trim(),
                                                            passworhash.trim(),
                                                            email.getText().toString().trim());
                                                    Intent intent=new Intent(rejestracja.this,MainActivity.class);
                                                    startActivity(intent);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else
                            {
                                Toast.makeText(rejestracja.this, "Podane hasła są różne",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });
    }
}