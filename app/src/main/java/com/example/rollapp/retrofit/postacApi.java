package com.example.rollapp.retrofit;

import com.example.rollapp.model.gra;
import com.example.rollapp.model.postac;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface postacApi {

    @POST("/postac/save")
    Call<Void> save(@Body postac postac);

    @POST("/gra/getpostac")
    Call<ArrayList<String>> getpostac(@Body postac postac);
}
