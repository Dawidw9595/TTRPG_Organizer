package com.example.rollapp.retrofit;

import com.example.rollapp.model.wydarzenia;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface wydarzeniaApi {

    @POST("/wydarzenia/save")
    Call<Void> save(@Body wydarzenia wydarzenia);
    @POST("/wydarzenia/update")
    Call<Void> update(@Body wydarzenia wydarzenia);
    @POST("/wydarzenia/usunpuste")
    Call<Void> usunpuste(@Body wydarzenia wydarzenia);
    @POST("/wydarzenia/koniec")
    Call<Void> koniec(@Body wydarzenia wydarzenia);
}
