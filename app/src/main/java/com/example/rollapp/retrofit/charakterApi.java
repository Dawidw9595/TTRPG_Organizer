package com.example.rollapp.retrofit;

import com.example.rollapp.model.charakter;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface charakterApi {

    @POST("/charakter/save")
    Call<Void> save(@Body charakter charakter);
    @POST("/charakter/save")
    Call<Void> update(@Body charakter charakter);
    @POST("/charakter/save")
    Call<Void> usunpuste(@Body charakter charakter);
    @POST("/charakter/save")
    Call<Void> koniec(@Body charakter charakter);
}
