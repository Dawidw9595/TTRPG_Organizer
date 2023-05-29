package com.example.rollapp.retrofit;

import com.example.rollapp.model.wiedzmin_zdolnosc_fachu;
import com.example.rollapp.model.wiedzmin_zdolnosci_gracji;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface gracjaApi {

    @POST("/gracja/save")
    Call<Void> save(@Body wiedzmin_zdolnosci_gracji wiedzmin_zdolnosci_gracji);

    @POST("/gracja/getall")
    Call<ArrayList<wiedzmin_zdolnosci_gracji>> getall(@Body wiedzmin_zdolnosci_gracji wiedzmin_zdolnosci_gracji);

    @POST("/gracja/mody")
    Call<Void> modyfikuj(@Body wiedzmin_zdolnosci_gracji wiedzmin_zdolnosci_gracji);

    @POST("/gracja/usunpostac")
    Call<Void> usunpuste();

    @POST("/gracja/koniec")
    Call<Void>koniec(@Body wiedzmin_zdolnosci_gracji wiedzmin_zdolnosci_gracji);
}
