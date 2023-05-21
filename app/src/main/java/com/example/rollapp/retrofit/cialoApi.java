package com.example.rollapp.retrofit;

import com.example.rollapp.model.wiedzmin_zdolnosci_ciala;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface cialoApi {

    @POST("/cialo/save")
    Call<Void> save(@Body wiedzmin_zdolnosci_ciala wiedzmin_zdolnosci_ciala);

    @POST("/cialo/getall")
    Call<ArrayList<wiedzmin_zdolnosci_ciala>> getbyid(@Body wiedzmin_zdolnosci_ciala wiedzmin_zdolnosci_ciala);
}
