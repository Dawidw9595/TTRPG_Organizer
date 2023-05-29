package com.example.rollapp.retrofit;


import com.example.rollapp.model.wiedzmin_bron;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface bronApi {

    @POST("/bron/save")
    Call<Void>save(@Body wiedzmin_bron wiedzmin_bron);

    @POST("/bron/mody")
    Call<Void> mody(@Body wiedzmin_bron wiedzmin_bron);

    @POST("/bron/czyjest")
    Call<ArrayList<wiedzmin_bron>> czyjest(@Body wiedzmin_bron wiedzmin_bron);
}
