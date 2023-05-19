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
<<<<<<< Updated upstream
                .baseUrl("http://192.168.1.192:8080/")
=======
<<<<<<< HEAD
                .baseUrl("http://192.168.0.4:8080/")
=======
                .baseUrl("http://192.168.1.192:8080/")
>>>>>>> 81568e8100a3d23a5a36b7788c085541bdc1a7df
>>>>>>> Stashed changes
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public static Retrofit getRetrofit()
    {
        return retrofit;
    }
}
