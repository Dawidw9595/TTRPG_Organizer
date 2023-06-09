package com.example.rollapp.retrofit;

import com.example.rollapp.model.user;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface userApi {

    @GET("/user/get-all")
    Call<List<user>> getallusers();

    @POST("/user/nick")
    Call<ArrayList<user>> nick(@Body user user);

    @POST("/user/email")
    Call<ArrayList<user>> email(@Body user user);

    @POST("/user/save")
    Call<user> save(@Body user user);

    @GET("users/{userId}")
    Call<user> getuserInfo(@Path("userId") int userId);

    @GET("users/{userId}/characters")
    Call<List<String>> getuserCharacters(@Path("userId") int userId);

    @POST("/user/password")
    Call<ArrayList<String>> haslo(@Body user user);

    @POST("/user/get-info")
    Call<ArrayList<user>> allinfo(@Body user user);

    @POST("/user/zmienimie")
    Call<Void> changename(@Body user user);

    @POST("/user/zmiennazwisko")
    Call<Void> changesurname(@Body user user);

    @POST("/user/zmiennick")
    Call<Void> changenick(@Body user user);

    @POST("/user/zmienhaslo")
    Call<Void> changepass(@Body user user);

    @POST("/user/zmienemail")
    Call<Void> changeemail(@Body user user);

    @POST("/user/czynick")
    Call<ArrayList<String>> czyjest(@Body user user);

    @POST("/user/czyemail")
    Call<ArrayList<String>> czyjestemail(@Body user user);

}
