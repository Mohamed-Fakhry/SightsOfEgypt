package com.example.com.sightsofegypt.data.db;

import com.example.com.sightsofegypt.data.model.Sight;

import java.util.ArrayList;

public interface DbHelper {

    boolean saveSightsFeature(ArrayList<Sight> sights);

    boolean saveSightsExplore(ArrayList<Sight> sights);

    ArrayList<Sight> getSightsFeature();

    ArrayList<Sight> getSightsExplore(int limit, int offset);
}
