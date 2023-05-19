package com.example.rollapp.retrofit;

import com.example.rollapp.model.mg;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface mgApi {

    @GET("/mg/get-all")
    Call<List<mg>> getallusers();

    @POST("/mg/nick")
    Call<ArrayList<mg>> nick(@Body mg mg);

    @POST("/mg/email")
    Call<ArrayList<mg>> email(@Body mg mg);

    @POST("/mg/save")
    Call<mg> save(@Body mg mg);

    @POST("/mg/password")
    Call<ArrayList<String>> haslo(@Body mg mg);

    @POST("/mg/get-info")
    Call<ArrayList<mg>> allinfo(@Body mg mg);
}
