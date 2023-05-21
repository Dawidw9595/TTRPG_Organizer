package com.example.rollapp.retrofit;

import com.example.rollapp.model.wiedzmin_cechy;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface cechaApi {

    @POST("/cechy/save")
    Call<Void> save(@Body wiedzmin_cechy wiedzmin_cechy);

    @POST("/cechy/getall")
    Call<ArrayList<wiedzmin_cechy>> getall(@Body wiedzmin_cechy wiedzmin_cechy);
}
