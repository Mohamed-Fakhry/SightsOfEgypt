package com.example.com.sightsofegypt.data.api;



import com.example.com.sightsofegypt.data.model.Sight;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    @GET("featured")
    Call<ArrayList<Sight>> getFeatured();

    @GET("explore")
    Call<ArrayList<Sight>> getExplore(@Query("count") int count, @Query("from") int from);
}
