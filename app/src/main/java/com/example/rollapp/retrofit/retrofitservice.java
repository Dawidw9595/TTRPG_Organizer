package com.example.rollapp.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitservice {

    private static Retrofit retrofit;

    public retrofitservice(){
        initializeRetrofit();
    }

    private void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.112:8080/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public static Retrofit getRetrofit()
    {
        return retrofit;
    }
}
