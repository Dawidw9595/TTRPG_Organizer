package com.example.rollapp.retrofit;

import com.example.rollapp.model.wiedzmin_zdolnosci_rozum;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface rozumApi {

    @POST("/reakcja/save")
    Call<Void> save(@Body wiedzmin_zdolnosci_rozum wiedzmin_zdolnosci_rozum);

    @POST("/reakcja/getall")
    Call<ArrayList<wiedzmin_zdolnosci_rozum>> getall(@Body wiedzmin_zdolnosci_rozum wiedzmin_zdolnosci_rozum);
}
