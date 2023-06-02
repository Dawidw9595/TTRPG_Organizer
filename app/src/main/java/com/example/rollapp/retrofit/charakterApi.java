package com.example.rollapp.retrofit;

import com.example.rollapp.model.charakter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface charakterApi {

    @POST("/charakter/save")
    Call<Void> save(@Body charakter charakter);
    @POST("/charakter/update")
    Call<Void> update(@Body charakter charakter);
    @POST("/charakter/usunpuste")
    Call<Void> usunpuste();
    @POST("/charakter/koniec")
    Call<Void> koniec(@Body charakter charakter);
    @POST("/charakter/czyjest")
    Call<ArrayList<charakter>> czyjest(@Body charakter charakter);
}
