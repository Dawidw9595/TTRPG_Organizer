package com.example.rollapp.retrofit;

import com.example.rollapp.model.wiedzmin_uszkodzenia_pancerz;

import java.util.ArrayList;

import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.Call;
public interface uszkodzeniapancerzApi {

    @POST("/uszkodzeniapancerz/save")
    Call<Void> save(@Body wiedzmin_uszkodzenia_pancerz wiedzmin_uszkodzenia_pancerz);
    @POST("/uszkodzeniapancerz/getall")
    Call<ArrayList<wiedzmin_uszkodzenia_pancerz>> getall(@Body wiedzmin_uszkodzenia_pancerz wiedzmin_uszkodzenia_pancerz);

    @POST("/uszkodzeniapancerz/mody")
    Call<Void> mody(@Body wiedzmin_uszkodzenia_pancerz wiedzmin_uszkodzenia_pancerz);

    @POST("/uszkodzeniapancerz/koniec")
    Call<Void> koniec(@Body wiedzmin_uszkodzenia_pancerz wiedzmin_uszkodzenia_pancerz);

    @POST("/uszkodzeniapancerz/usunpuste")
    Call<Void> usunpuste();

}
