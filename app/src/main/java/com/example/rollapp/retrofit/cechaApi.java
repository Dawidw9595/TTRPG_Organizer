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

    @POST("/cechy/getbyid")
    Call<ArrayList<wiedzmin_cechy>> getallbyid(@Body wiedzmin_cechy wiedzmin_cechy);

    @POST("/cechy/mody")
    Call<Void> modyfikuj(@Body wiedzmin_cechy wiedzmin_cechy);

    @POST("/cechy/usunpostac")
    Call<Void> usunpuste();

    @POST("/cechy/koniec")
    Call<Void>koniec(@Body wiedzmin_cechy wiedzmin_cechy);
}
