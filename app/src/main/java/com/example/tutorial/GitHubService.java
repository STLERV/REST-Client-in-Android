package com.example.tutorial;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import java.util.List;



interface GitHubService {


    @GET("tracks")

    Call<List<Tracks>> mistracks();


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://147.83.7.203:8080/dsaApp/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();



    @GET("tracks/{id}")

    Call<Tracks> Hola( @Path("id") String id );







}





