package com.example.rollapp.retrofit;

import com.example.rollapp.model.wiedzmin_zdolnosc_fachu;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface gracjaApi {

    @POST("/gracja/save")
    Call<Void> save(@Body wiedzmin_zdolnosc_fachu wiedzmin_zdolnosc_fachu);

    @POST("/gracja/getall")
    Call<ArrayList<wiedzmin_zdolnosc_fachu>> getall(@Body wiedzmin_zdolnosc_fachu wiedzmin_zdolnosc_fachu);
}
