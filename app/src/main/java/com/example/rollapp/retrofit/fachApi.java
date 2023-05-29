package com.example.rollapp.retrofit;

import com.example.rollapp.model.wiedzmin_zdolnosc_fachu;
import com.example.rollapp.model.wiedzmin_zdolnosci_ciala;
import com.example.rollapp.model.wiedzmin_zdolnosci_emocji;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface fachApi {

    @POST("/fach/save")
    Call<Void> save(@Body wiedzmin_zdolnosc_fachu wiedzmin_zdolnosc_fachu);

    @POST("/fach/getall")
    Call<ArrayList<wiedzmin_zdolnosc_fachu>> getall(@Body wiedzmin_zdolnosc_fachu wiedzmin_zdolnosc_fachu);

    @POST("/fach/mody")
    Call<Void> modyfikuj(@Body wiedzmin_zdolnosc_fachu wiedzmin_zdolnosc_fachu);

    @POST("/fach/usunpostac")
    Call<Void> usunpuste();

    @POST("/fach/koniec")
    Call<Void>koniec(@Body wiedzmin_zdolnosc_fachu wiedzmin_zdolnosc_fachu);
}
