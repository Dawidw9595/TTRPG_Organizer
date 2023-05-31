package com.example.rollapp.retrofit;



import com.example.rollapp.model.wyglad;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface wygladApi {

    @POST("/wyglad/save")
    Call<Void> save(@Body wyglad wyglad);

    @POST("/wyglad/update")
    Call<Void> update(@Body wyglad wyglad);

    @POST("/wyglad/usunpuste")
    Call<Void> usunpuste(@Body wyglad wyglad);

    @POST("/wyglad/koniec")
    Call<Void> koniec(@Body wyglad wyglad);
}
