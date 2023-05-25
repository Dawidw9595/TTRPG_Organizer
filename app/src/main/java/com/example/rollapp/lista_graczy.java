package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.rollapp.adapter.graczAdapter;
import com.example.rollapp.model.mg;
import com.example.rollapp.model.postac;
import com.example.rollapp.model.user;
import com.example.rollapp.retrofit.retrofitservice;
import com.example.rollapp.retrofit.userApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class lista_graczy extends AppCompatActivity {

    private RecyclerView recyclerView;

    private static final String SHERED_PREFS = "daneuzyt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_graczy);
        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        recyclerView = findViewById(R.id.listaGraczy);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        user user = new user();
        user.setId_mg(sessionstorage.getInt("id",0));
        zaladujgraczy(user);


    }

    private void zaladujgraczy(user user){
        retrofitservice rts = new retrofitservice();
        userApi userApi = rts.getRetrofit().create(com.example.rollapp.retrofit.userApi.class);

        userApi.getallusers().enqueue(new Callback<List<com.example.rollapp.model.user>>() {
            @Override
            public void onResponse(Call<List<com.example.rollapp.model.user>> call, Response<List<com.example.rollapp.model.user>> response) {
                listaGraczyWidok(response.body());
            }

            @Override
            public void onFailure(Call<List<com.example.rollapp.model.user>> call, Throwable t) {
                Toast.makeText(lista_graczy.this, "Wystąpił Błąd", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void listaGraczyWidok(List<user> user){
        graczAdapter graczAdapter = new graczAdapter(user);
        recyclerView.setAdapter(graczAdapter);
    }
}