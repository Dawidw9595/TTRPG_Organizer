package com.example.rollapp.retrofit;

import com.example.rollapp.model.gra;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface graApi {

    @POST("/gra/save")
    Call<Void> save(@Body gra gra);

    @POST("/gra/czyjest")
    Call<ArrayList<String>> czyjest(@Body gra gra);

}
