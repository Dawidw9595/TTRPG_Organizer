package com.example.rollapp.retrofit;

import com.example.rollapp.model.gra;
import com.example.rollapp.model.postac;
import com.example.rollapp.model.wiedzmin_karta;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface postacApi {

    @POST("/postac/save")
    Call<Void> save(@Body postac postac);

    @POST("/postac/getpostac")
    Call<ArrayList<postac>> getpostac(@Body postac postac);

    @POST("/postac/getallpostac")
    Call<ArrayList<postac>> getallpostac(@Body postac postac);

    @POST("/postac/setall")
    Call<Void> setall(@Body postac postac);

    @POST("/postac/usunpostac")
    Call<Void> usunpostac();

    @POST("/postac/koniec")
    Call<Void>koniec(@Body postac postac);
    @GET("postacie/{userId}")
    Call<List<postac>> getPostacieForUser(@Path("userId") int userId);

}
