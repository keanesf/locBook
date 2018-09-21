package com.keanesf.locbook.services;

import com.keanesf.locbook.models.GooglePlaceResponse;
import com.keanesf.locbook.models.Place;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceService {

    @GET("maps/api/place/nearbysearch/json")
    Call<GooglePlaceResponse<Place>> listPlaces(
            @Query("location") String location,
            @Query("radius") String radius,
            @Query("key") String apiKey
    );

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
