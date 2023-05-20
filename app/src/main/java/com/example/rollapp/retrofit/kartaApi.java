package com.example.rollapp.retrofit;

import com.example.rollapp.model.mg;
import com.example.rollapp.model.wiedzmin_karta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface kartaApi {

    @POST("/karta/save")
    Call<Void> save(@Body wiedzmin_karta wiedzmin_karta);

    @POST("/karta/czyjest")
    Call<ArrayList<String>> czyjest(@Body wiedzmin_karta wiedzmin_karta);
}
