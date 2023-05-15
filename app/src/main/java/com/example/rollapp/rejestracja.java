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

import at.favre.lib.crypto.bcrypt.BCrypt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class rejestracja extends AppCompatActivity {

    private EditText imie;
    private EditText nazwisko;
    private EditText nick;
    private EditText haslo1;
    private EditText haslo2;
    private EditText email;
    Button rejestracja;

    private String passworhash;

    private String zbazy;

    private String emailzbazy;

    private void dodajuser(user user)
    {
        retrofitservice rts = new retrofitservice();

        userApi userApi = rts.getRetrofit().create(userApi.class);

        userApi.save(user).enqueue(new Callback<user>() {
            @Override
            public void onResponse(Call<com.example.rollapp.model.user> call, Response<com.example.rollapp.model.user> response) {
                Toast.makeText(rejestracja.this,"Dodano do użytkownika do bazy danych !!!!",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<com.example.rollapp.model.user> call, Throwable t) {
                Toast.makeText(rejestracja.this , "Nie udało się sprawdzić dodać użytkownika do bazy spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
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
                    zbazy = response.body().get(0).getNick();
                    Toast.makeText(rejestracja.this, "Podany Login jest już zajęty",Toast.LENGTH_SHORT).show();
                }
                else {
                    zbazy = "";
                }
            }

            @Override
            public void onFailure(Call<ArrayList<user>> call, Throwable t) {
                Toast.makeText(rejestracja.this , "Nie udało się sprawdzić czy dany nick istnieje spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });

        return zbazy;
    }

    private String pobranieEmail(user user)
    {

        retrofitservice rts = new retrofitservice();

        userApi userApi = rts.getRetrofit().create(userApi.class);

        userApi.email(user).enqueue(new Callback<ArrayList<user>>() {
            @Override
            public void onResponse(Call<ArrayList<user>> call, Response<ArrayList<user>> response) {
                if(!response.body().isEmpty())
                {
                    emailzbazy = response.body().get(0).getEmail();
                    Toast.makeText(rejestracja.this, "Użytkownik o takim adresie e-mail już istnieje",Toast.LENGTH_SHORT).show();
                }
                else {
                    emailzbazy = "";
                }
            }

            @Override
            public void onFailure(Call<ArrayList<user>> call, Throwable t) {
                Toast.makeText(rejestracja.this , "Nie udało się sprawdzić czy dany email istnieje spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });

        return emailzbazy;
    }

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

        rejestracja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                passworhash = BCrypt.withDefaults().hashToString(12,haslo1.getText().toString().toCharArray());
                user user = new user();
                user.setImie(imie.getText().toString());
                user.setNazwisko((nazwisko.getText().toString()));
                user.setEmail(email.getText().toString());
                user.setHaslo(passworhash);
                user.setNick(nick.getText().toString());

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
                        if (pobranieNick(user) != "")
                        {

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
                                                if(pobranieEmail(user) != "")
                                                {

                                                }
                                                else
                                                {
                                                    dodajuser(user);
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