package com.example.rollapp.retrofit;

import com.example.rollapp.model.postac;
import com.example.rollapp.model.wiedzmin_zdolnosci_reakcji;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface reakcjaApi {

    @POST("/reakcja/save")
    Call<Void> save(@Body wiedzmin_zdolnosci_reakcji wiedzmin_zdolnosci_reakcji);

    @POST("/reakcja/getall")
    Call<ArrayList<wiedzmin_zdolnosci_reakcji>> getall(@Body wiedzmin_zdolnosci_reakcji wiedzmin_zdolnosci_reakcji);

    @POST("/reakcja/mody")
    Call<Void> modyfikuj(@Body wiedzmin_zdolnosci_reakcji wiedzmin_zdolnosci_reakcji);

    @POST("/reakcja/usunpostac")
    Call<Void> usunpuste();

    @POST("/reakcja/koniec")
    Call<Void>koniec(@Body wiedzmin_zdolnosci_reakcji wiedzmin_zdolnosci_reakcji);
}
