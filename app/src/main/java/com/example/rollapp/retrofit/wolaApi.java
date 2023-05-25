package com.example.rollapp.retrofit;

import com.example.rollapp.model.wiedzmin_zdolnosci_ciala;
import com.example.rollapp.model.wiedzmin_zdolnosci_woli;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface wolaApi {

    @POST("/wola/save")
    Call<Void> save(@Body wiedzmin_zdolnosci_woli wiedzmin_zdolnosci_woli);

    @POST("/wola/getall")
    Call<ArrayList<wiedzmin_zdolnosci_woli>> getall(@Body wiedzmin_zdolnosci_woli wiedzmin_zdolnosci_woli);

    @POST("/wola/mody")
    Call<Void> modyfikuj(@Body wiedzmin_zdolnosci_woli wiedzmin_zdolnosci_woli);
}
