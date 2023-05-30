package com.example.rollapp.retrofit;

import com.example.rollapp.model.mg;
import com.example.rollapp.model.wiedzmin_karta;
import com.example.rollapp.model.wiedzmin_zdolnosci_gracji;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface kartaApi {

    @POST("/karta/save")
    Call<Void> save(@Body wiedzmin_karta wiedzmin_karta);

    @POST("/karta/czyjest")
    Call<ArrayList<wiedzmin_karta>> czyjest(@Body wiedzmin_karta wiedzmin_karta);

    @POST("/karta/updatececha")
    Call<Void> updatecehca(@Body wiedzmin_karta wiedzmin_karta);

    @POST("/karta/updatefach")
    Call<Void> updatefach(@Body wiedzmin_karta wiedzmin_karta);

    @POST("/karta/updatecialo")
    Call<Void> updatecialo(@Body wiedzmin_karta wiedzmin_karta);

    @POST("/karta/updateemocji")
    Call<Void> updateemocji(@Body wiedzmin_karta wiedzmin_karta);

    @POST("/karta/updaterozum")
    Call<Void> updaterozum(@Body wiedzmin_karta wiedzmin_karta);

    @POST("/karta/updatewola")
    Call<Void> updatewola(@Body wiedzmin_karta wiedzmin_karta);

    @POST("/karta/updategracja")
    Call<Void> updategracja(@Body wiedzmin_karta wiedzmin_karta);

    @POST("/karta/updatereakcja")
    Call<Void> updatereakcja(@Body wiedzmin_karta wiedzmin_karta);

    @POST("/karta/updatebron")
    Call<Void> updatebron(@Body wiedzmin_karta wiedzmin_karta);

    @POST("/karta/updatepancerz")
    Call<Void> updatepancerz(@Body wiedzmin_karta wiedzmin_karta);

    @POST("/karta/usunpuste")
    Call<Void> usunpuste();

    @POST("/karta/koniec")
    Call<Void>koniec(@Body wiedzmin_karta wiedzmin_karta);
}
