package com.example.rollapp.retrofit;

import com.example.rollapp.model.wiedzmin_pancerz;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface pancerzApi {

    @POST("/pancerz/save")
    Call<Void> save(@Body wiedzmin_pancerz wiedzmin_pancerz);

    @POST("/pancerz/czyjest")
    Call<ArrayList<wiedzmin_pancerz>> czyjest(@Body wiedzmin_pancerz wiedzmin_pancerz);

    @POST("/pancerz/mody")
    Call<Void> mody(@Body wiedzmin_pancerz wiedzmin_pancerz);

    @POST("/pancerz/koniec")
    Call<Void> koniec(@Body wiedzmin_pancerz wiedzmin_pancerz);

    @POST("/pancerz/usunpuste")
    Call<Void> usunpuste();

    @POST("/pancerz/updateusz")
    Call<Void> updateusz(@Body wiedzmin_pancerz wiedzmin_pancerz);

}
