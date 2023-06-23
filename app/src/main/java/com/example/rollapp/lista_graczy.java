package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.rollapp.R;
import com.example.rollapp.adapter.graczAdapter;
import com.example.rollapp.informacjegracza;
import com.example.rollapp.model.postac;
import com.example.rollapp.model.user;
import com.example.rollapp.retrofit.retrofitservice;
import com.example.rollapp.retrofit.userApi;
import com.example.rollapp.retrofit.postacApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class lista_graczy extends AppCompatActivity implements graczAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private graczAdapter adapter;

    private static final String SHARED_PREFS = "daneuzyt";
    private List<user> listaGraczy; // Deklaracja listy graczy

    private postacApi postacApi; // Dodane pole postacApi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_graczy);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, 0);
        recyclerView = findViewById(R.id.graczeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaGraczy = new ArrayList<>(); // Inicjalizacja listy graczy
        adapter = new graczAdapter(listaGraczy); // Tworzenie adaptera z listą graczy
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);

        retrofitservice rts = new retrofitservice();
        userApi userApi = rts.getRetrofit().create(userApi.class);
        postacApi = rts.getRetrofit().create(postacApi.class); // Inicjalizacja postacApi

        user user = new user();
        user.setId_mg(sharedPreferences.getInt("id", 0));
        zaladujGraczy();
    }

    private void zaladujGraczy() {
        retrofitservice rts = new retrofitservice();
        userApi userApi = rts.getRetrofit().create(userApi.class);

        Call<List<user>> call = userApi.getallusers(); // Utwórz zapytanie

        call.enqueue(new Callback<List<user>>() {
            @Override
            public void onResponse(Call<List<user>> call, Response<List<user>> response) {
                if (response.isSuccessful()) {
                    List<user> userList = response.body();
                    if (userList != null) {
                        for (user user : userList) {
                            // Pobierz listę postaci dla danego użytkownika
                            pobierzListePostaciDlaUzytkownika(user);
                        }
                        listaGraczy.addAll(userList); // Dodanie otrzymanych graczy do listy
                        adapter.notifyDataSetChanged(); // Powiadomienie adaptera o zmianach w liście
                    }
                } else {
                    Toast.makeText(lista_graczy.this, "Wystąpił błąd", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<user>> call, Throwable t) {
                Toast.makeText(lista_graczy.this, "Wystąpił błąd", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void pobierzListePostaciDlaUzytkownika(user user) {
        postacApi.getPostacieForUser(user.getId()).enqueue(new Callback<List<postac>>() {
            @Override
            public void onResponse(Call<List<postac>> call, Response<List<postac>> response) {
                if (response.isSuccessful()) {
                    List<postac> listaPostaci = response.body();
                    if (listaPostaci != null) {
                        user.setListaPostaci(listaPostaci);

                        // Dodaj listę postaci do adaptera
                        adapter.setPostacie(user.getListaPostaci());
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(lista_graczy.this, "Wystąpił błąd", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<postac>> call, Throwable t) {
                Toast.makeText(lista_graczy.this, "Wystąpił błąd", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(user user) {
        Intent intent = new Intent(this, informacjegracza.class);
        intent.putExtra("userId", user.getId());
        startActivity(intent);
    }
}
