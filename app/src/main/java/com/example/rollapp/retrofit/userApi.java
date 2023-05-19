package com.example.rollapp.retrofit;

import com.example.rollapp.model.user;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface userApi {

    @GET("/user/get-all")
    Call<List<user>> getallusers();

    @POST("/user/nick")
    Call<ArrayList<user>> nick(@Body user user);

    @POST("/user/email")
    Call<ArrayList<user>> email(@Body user user);

    @POST("/user/save")
    Call<user> save(@Body user user);

    @POST("/user/password")
    Call<ArrayList<String>> haslo(@Body user user);
<<<<<<< Updated upstream
=======
<<<<<<< HEAD

    @POST("/user/get-info")
    Call<ArrayList<user>> allinfo(@Body user user);
=======
>>>>>>> 81568e8100a3d23a5a36b7788c085541bdc1a7df
>>>>>>> Stashed changes
}
