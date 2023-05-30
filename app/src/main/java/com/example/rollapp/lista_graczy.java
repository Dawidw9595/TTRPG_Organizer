package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.rollapp.adapter.graczAdapter;
import com.example.rollapp.model.user;
import com.example.rollapp.retrofit.retrofitservice;
import com.example.rollapp.retrofit.userApi;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_graczy);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, 0);
        recyclerView = findViewById(R.id.listaGraczy);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaGraczy = new ArrayList<>(); // Inicjalizacja listy graczy
        adapter = new graczAdapter(); // Tworzenie adaptera bez argumentów
        adapter.setGracze(listaGraczy); // Przekazanie listy graczy do adaptera
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);

        user user = new user();
        user.setId_mg(sharedPreferences.getInt("id", 0));
        zaladujgraczy();
    }

    private void zaladujgraczy() {
        retrofitservice rts = new retrofitservice();
        userApi userApi = rts.getRetrofit().create(userApi.class);

        userApi.getallusers().enqueue(new Callback<List<user>>() {
            @Override
            public void onResponse(Call<List<user>> call, Response<List<user>> response) {
                if (response.isSuccessful()) {
                    List<user> userList = response.body();
                    if (userList != null) {
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

    @Override
    public void onItemClick(user user) {
        Intent intent = new Intent(this, informacjegracza.class);
        intent.putExtra("userId", user.getId());
        startActivity(intent);
    }
}
