package com.example.rollapp.retrofit;

import com.example.rollapp.model.wiedzmin_cechy;
import com.example.rollapp.model.wiedzmin_zdolnosci_ciala;
import com.example.rollapp.model.wiedzmin_zdolnosci_emocji;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface emocjaApi {

    @POST("/emocje/save")
    Call<Void> save(@Body wiedzmin_zdolnosci_emocji wiedzmin_zdolnosci_emocji);

    @POST("/emocje/getall")
    Call<ArrayList<wiedzmin_zdolnosci_emocji>> getall(@Body wiedzmin_zdolnosci_emocji wiedzmin_zdolnosci_emocji);

    @POST("/emocje/mody")
    Call<Void> modyfikuj(@Body wiedzmin_zdolnosci_emocji wiedzmin_zdolnosci_emocji);

    @POST("/emocje/usunpostac")
    Call<Void> usunpuste();

    @POST("/emocje/koniec")
    Call<Void>koniec(@Body wiedzmin_zdolnosci_emocji wiedzmin_zdolnosci_emocji);
}
