package com.example.rollapp.retrofit;

import com.example.rollapp.model.wiedzmin_statystyki_postaci;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface statystykipostaciApi {

    @POST("statystykipostaci/save")
    Call<Void> save(@Body wiedzmin_statystyki_postaci wiedzmin_statystyki_postaci);
    @POST("/statystykipostaci/getall")
    Call<ArrayList<wiedzmin_statystyki_postaci>> getall(@Body wiedzmin_statystyki_postaci wiedzmin_statystyki_postaci);
}
