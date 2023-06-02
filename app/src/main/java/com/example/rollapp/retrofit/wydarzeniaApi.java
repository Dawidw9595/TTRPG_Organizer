package com.example.rollapp.retrofit;

import com.example.rollapp.model.wydarzenia;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface wydarzeniaApi {

    @POST("/wydarzenia/save")
    Call<Void> save(@Body wydarzenia wydarzenia);
    @POST("/wydarzenia/update")
    Call<Void> update(@Body wydarzenia wydarzenia);
    @POST("/wydarzenia/usunpuste")
    Call<Void> usunpuste();
    @POST("/wydarzenia/koniec")
    Call<Void> koniec(@Body wydarzenia wydarzenia);

    @POST("/wydarzenia/czyjest")
    Call<ArrayList<wydarzenia>> getallw(@Body wydarzenia wydarzenia);
}
