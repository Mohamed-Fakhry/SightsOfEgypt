package com.example.com.sightsofegypt.data.api.model;

import com.example.com.sightsofegypt.App;
import com.example.com.sightsofegypt.data.model.Sight;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SightModelImpl implements SightModel {

    @Override
    public void getFeatureSights(final OnRespond listener) {
        App.service.getFeatured().enqueue(new Callback<ArrayList<Sight>>() {
            @Override
            public void onResponse(Call<ArrayList<Sight>> call, Response<ArrayList<Sight>> response) {
                if (response.isSuccessful())
                    listener.successFeature(response.body());
                else
                    listener.fail();
            }

            @Override
            public void onFailure(Call<ArrayList<Sight>> call, Throwable t) {
                listener.fail();
            }
        });
    }

    @Override
    public void getExploreSights(int limit, int offset, final OnRespond listener) {
        App.service.getExplore(limit, offset).enqueue(new Callback<ArrayList<Sight>>() {
            @Override
            public void onResponse(Call<ArrayList<Sight>> call, Response<ArrayList<Sight>> response) {
                if (response.isSuccessful()) {
                    listener.successExplore(response.body());
                } else
                    listener.fail();
            }

            @Override
            public void onFailure(Call<ArrayList<Sight>> call, Throwable t) {
                listener.fail();
            }
        });
    }

    @Override
    public void getMoreExplore(int limit, int offset, final OnRespond listener) {
        App.service.getExplore(limit, offset).enqueue(new Callback<ArrayList<Sight>>() {
            @Override
            public void onResponse(Call<ArrayList<Sight>> call, Response<ArrayList<Sight>> response) {
                if (response.isSuccessful()) {
                    listener.successLoadMore(response.body());
                } else
                    listener.fail();
            }

            @Override
            public void onFailure(Call<ArrayList<Sight>> call, Throwable t) {
                listener.fail();
            }
        });
    }
}
