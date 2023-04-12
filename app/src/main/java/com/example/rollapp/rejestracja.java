package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Range;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class rejestracja extends AppCompatActivity {

    private EditText imie;
    private EditText nazwisko;
    private EditText nick;
    private EditText haslo1;
    private EditText haslo2;
    private EditText email;
    Button rejestracja;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);
        Toast.makeText(rejestracja.this, "W formularzu należy uzupełnić wszystkie pola!!!",Toast.LENGTH_LONG).show();
        rejestracja=findViewById(R.id.rejestracja);

        rejestracja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imie=findViewById(R.id.imie);
                nazwisko=findViewById(R.id.nazwisko);
                nick=findViewById(R.id.login);
                haslo1=findViewById(R.id.haslo1);
                haslo2=findViewById(R.id.haslo2);
                email=findViewById(R.id.email);

                if(imie.getText().toString().equals("") || nazwisko.getText().toString().equals("") || nick.getText().toString().equals("") || haslo1.getText().toString().equals("") || haslo2.getText().toString().equals("") || email.getText().toString().equals("") )
                {
                    Toast.makeText(rejestracja.this, "Nie uzupełniono któregoś z pól !!!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(haslo1.getText().toString().equals(haslo2.getText().toString()))
                    {
                        if(imie.getText().toString().contains("0") || imie.getText().toString().contains("1") || imie.getText().toString().contains("2") || imie.getText().toString().contains("3") || imie.getText().toString().contains("4") || imie.getText().toString().contains("5") || imie.getText().toString().contains("6") || imie.getText().toString().contains("7") || imie.getText().toString().contains("8") || imie.getText().toString().contains("9"))
                        {
                            Toast.makeText(rejestracja.this, "Imię nie może zawierać cyfr !!!",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            if (nazwisko.getText().toString().contains("0") || nazwisko.getText().toString().contains("1") || nazwisko.getText().toString().contains("2") || nazwisko.getText().toString().contains("3") || nazwisko.getText().toString().contains("4") || nazwisko.getText().toString().contains("5") || nazwisko.getText().toString().contains("6") || nazwisko.getText().toString().contains("7") || nazwisko.getText().toString().contains("8") || nazwisko.getText().toString().contains("9") )
                            {
                                Toast.makeText(rejestracja.this, "Nazwisko nie może zawierać cyfr !!!",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                if(!email.getText().toString().contains("@") || !email.getText().toString().contains(".") || !email.getText().toString().contains(".") || !email.getText().toString().contains("."))
                                {
                                    Toast.makeText(rejestracja.this, "Podany e-mail jest niepoprawny !!!",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                    else
                    {
                        Toast.makeText(rejestracja.this, "Podane hasła są różne!!!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}