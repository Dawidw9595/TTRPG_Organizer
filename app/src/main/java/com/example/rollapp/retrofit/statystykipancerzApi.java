package com.example.rollapp.retrofit;

import com.example.rollapp.model.wiedzmin_statystyki_pancerz;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface statystykipancerzApi {

    @POST("/statystykipancerz/save")
    Call<Void> save(@Body wiedzmin_statystyki_pancerz wiedzmin_statystyki_pancerz);

    @POST("/statystykipancerz/getall")
    Call<ArrayList<wiedzmin_statystyki_pancerz>> getall(@Body wiedzmin_statystyki_pancerz wiedzmin_statystyki_pancerz);
}
