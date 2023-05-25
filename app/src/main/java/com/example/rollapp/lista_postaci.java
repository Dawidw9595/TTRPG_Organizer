package com.example.rollapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.rollapp.adapter.postacAdapter;
import com.example.rollapp.model.postac;
import com.example.rollapp.retrofit.postacApi;
import com.example.rollapp.retrofit.retrofitservice;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class lista_postaci extends AppCompatActivity implements postacAdapter.OnItemClickListener {

    private RecyclerView recyclerView;

    private static final String SHERED_PREFS = "daneuzyt";

    private void zaladujpostacie(postac postac) {
        retrofitservice rts = new retrofitservice();
        postacApi postacApi = rts.getRetrofit().create(com.example.rollapp.retrofit.postacApi.class);
        postacApi.getallpostac(postac).enqueue(new Callback<ArrayList<postac>>() {
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
        postacAdapter postacAdapter = new postacAdapter(pos, this);
        recyclerView.setAdapter(postacAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_postaci);
        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        recyclerView = findViewById(R.id.listaPostaci);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        postac postac = new postac();
        postac.setId_user(sessionstorage.getInt("id",0));
        zaladujpostacie(postac);

    }

    @Override
    public void onItemClick(postac postac) {
        Intent intent = new Intent(this,postacmenu.class);
        SharedPreferences sessionstorage = getApplicationContext().getSharedPreferences(SHERED_PREFS,0);
        SharedPreferences.Editor editor = sessionstorage.edit();
        editor.putInt("id_karty",postac.getId_karty());
        editor.putString("nazwapostaci",postac.getNazwa_postaci());
        editor.commit();
        startActivity(intent);
    }
}