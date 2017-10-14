package com.example.com.sightsofegypt.data.api.model;

import com.example.com.sightsofegypt.data.model.Sight;

import java.util.ArrayList;

public interface SightModel {

    interface OnRespond {

        void successFeature(ArrayList<Sight> sights);

        void successExplore(ArrayList<Sight> sights);

        void successLoadMore(ArrayList<Sight> sights);

        void fail();
    }

    void getFeatureSights(OnRespond listener);

    void getExploreSights(int limit, int offset, OnRespond listener);

    void getMoreExplore(int limit, int offset, OnRespond listener);
}
