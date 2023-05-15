package com.example.rollapp.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitservice {

    private static Retrofit retrofit;

    public retrofitservice(){
        initializeRetrofit();
    }

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.4:8080/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static Retrofit getRetrofit()
    {
        return retrofit;
    }
}
