package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.rollapp.adapter.postacAdapter;
import com.example.rollapp.model.postac;
import com.example.rollapp.retrofit.postacApi;
import com.example.rollapp.retrofit.retrofitservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class lista_postaci extends AppCompatActivity {

    private RecyclerView recyclerView;

    private void zaladujpostacie(postac postac) {
        retrofitservice rts = new retrofitservice();
        postacApi postacApi = rts.getRetrofit().create(com.example.rollapp.retrofit.postacApi.class);
        postacApi.getpostac(postac).enqueue(new Callback<ArrayList<postac>>() {
            @Override
            public void onResponse(Call<ArrayList<postac>> call, Response<ArrayList<postac>> response) {

                populateListView(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<postac>> call, Throwable t) {
                Toast.makeText(lista_postaci.this, "Nie udało się załadować postaci", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void populateListView(ArrayList<postac> pos) {
        postacAdapter postacAdapter = new postacAdapter(pos);
        recyclerView.setAdapter(postacAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_postaci);

        recyclerView = findViewById(R.id.listaPostaci);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postac postac = new postac();
        zaladujpostacie(postac);

    }


}