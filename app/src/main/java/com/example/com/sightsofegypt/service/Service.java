package com.example.com.sightsofegypt.service;


import com.example.com.sightsofegypt.model.Sight;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("featured")
    Call<Sight> getFeatured();

    @GET("explore")
    Call<Sight> getExplore(int count, int from);
}
