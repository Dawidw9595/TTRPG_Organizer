package com.example.rollapp;

import android.content.Intent;
import android.os.Bundle;
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

public class rejestracja extends AppCompatActivity {

    private EditText imie;
    private EditText nazwisko;
    private EditText nick;
    private EditText haslo1;
    private EditText haslo2;
    private EditText email;
    Button rejestracja;

    private CheckBox czymistrzgry;

    private String passworhash;

    private String nickzbazy;

    private String emailzbazy;

    private String nickmgzbazy;

    private String emailmgzbazy;


    private void dodajmg(mg mg)
    {
        retrofitservice rts = new retrofitservice();
        mgApi mgApi = rts.getRetrofit().create(mgApi.class);
        mgApi.save(mg).enqueue(new Callback<mg>() {
            @Override
            public void onResponse(Call<com.example.rollapp.model.mg> call, Response<com.example.rollapp.model.mg> response) {
                Toast.makeText(rejestracja.this,"Dodano mistrza gry do bazy danych !!!!",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<com.example.rollapp.model.mg> call, Throwable t) {
                Toast.makeText(rejestracja.this , "Nie udało się sprawdzić dodać mistrza gry do bazy spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
    }

    private String pobranieNickMg(mg mg)
    {
        retrofitservice rts = new retrofitservice();
        mgApi mgApi = rts.getRetrofit().create(mgApi.class);
        mgApi.nick(mg).enqueue(new Callback<ArrayList<mg>>() {
            @Override
            public void onResponse(Call<ArrayList<mg>> call, Response<ArrayList<mg>> response) {
                if(!response.body().isEmpty())
                {
                    nickmgzbazy=response.body().get(0).getNick();
                }
                else
                {
                    nickmgzbazy="";
                }
            }

            @Override
            public void onFailure(Call<ArrayList<mg>> call, Throwable t) {
                Toast.makeText(rejestracja.this , "Nie udało się sprawdzić czy dany nick istnieje spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
        return nickmgzbazy;
    }

    private String pobranieEmailMg(mg mg)
    {
        retrofitservice rts = new retrofitservice();
        mgApi mgApi = rts.getRetrofit().create(mgApi.class);
        mgApi.email(mg).enqueue(new Callback<ArrayList<com.example.rollapp.model.mg>>() {
            @Override
            public void onResponse(Call<ArrayList<mg>> call, Response<ArrayList<mg>> response) {
                if(!response.body().isEmpty())
                {
                    emailmgzbazy = response.body().get(0).getEmail();
                }
                else
                {
                    emailmgzbazy = "";
                }
            }

            @Override
            public void onFailure(Call<ArrayList<mg>> call, Throwable t) {
                Toast.makeText(rejestracja.this , "Nie udało się sprawdzić czy dany email istnieje spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });
        return emailmgzbazy;
    }

    private void dodajuser(user user)
    {
        retrofitservice rts = new retrofitservice();

        userApi userApi = rts.getRetrofit().create(userApi.class);

        userApi.save(user).enqueue(new Callback<user>() {
            @Override
            public void onResponse(Call<com.example.rollapp.model.user> call, Response<com.example.rollapp.model.user> response) {
                Toast.makeText(rejestracja.this,"Dodano użytkownika do bazy danych !!!!",Toast.LENGTH_LONG).show();
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
                    nickzbazy = response.body().get(0).getNick();
                }
                else {
                    nickzbazy = "";
                }
            }

            @Override
            public void onFailure(Call<ArrayList<user>> call, Throwable t) {
                Toast.makeText(rejestracja.this , "Nie udało się sprawdzić czy dany nick istnieje spróbuj ponownie póżniej !!!!" , Toast.LENGTH_LONG).show();
                Logger.getLogger(rejestracja.class.getName()).log(Level.SEVERE,"Wystapil blad",t);
            }
        });

        return nickzbazy;
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
        czymistrzgry=(CheckBox) findViewById(R.id.czymistrzgry);

        rejestracja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(czymistrzgry.isChecked())
                {
                    passworhash = BCrypt.withDefaults().hashToString(12,haslo1.getText().toString().toCharArray());
                    mg mg = new mg();
                    mg.setImie(imie.getText().toString());
                    mg.setNazwisko((nazwisko.getText().toString()));
                    mg.setEmail(email.getText().toString());
                    mg.setHaslo(passworhash);
                    mg.setNick(nick.getText().toString());

                    pobranieEmailMg(mg);
                    pobranieNickMg(mg);

                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
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
                                    if (pobranieNickMg(mg) != "")
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
                                                            if(pobranieEmailMg(mg) != "")
                                                            {

                                                                Toast.makeText(rejestracja.this, "Mistrz gry o takim adresie e-mail już istnieje",Toast.LENGTH_SHORT).show();
                                                            }
                                                            else
                                                            {
                                                                dodajmg(mg);
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
                    },300);

                }
                else
                {
                    passworhash = BCrypt.withDefaults().hashToString(12,haslo1.getText().toString().toCharArray());
                    user user = new user();
                    user.setImie(imie.getText().toString());
                    user.setNazwisko((nazwisko.getText().toString()));
                    user.setEmail(email.getText().toString());
                    user.setHaslo(passworhash);
                    user.setNick(nick.getText().toString());

                    pobranieNick(user);
                    pobranieEmail(user);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
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
                                                            if(pobranieEmail(user) != "")
                                                            {
                                                                Toast.makeText(rejestracja.this, "Użytkownik o takim adresie e-mail już istnieje",Toast.LENGTH_SHORT).show();
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
                    },300);
                }
            }
        });
    }
}