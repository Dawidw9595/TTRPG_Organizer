package com.example.rollapp.retrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface emocjaApi {

    @POST("/emocje/save")
    Call<Void> save(@Body wiedzmin_zdolnosci_emocji wiedzmin_zdolnosci_emocji);

    @POST("/emocje/getall")
    Call<ArrayList<wiedzmin_zdolnosci_emocji>> getall(@Body wiedzmin_zdolnosci_emocji wiedzmin_zdolnosci_emocji);
}
