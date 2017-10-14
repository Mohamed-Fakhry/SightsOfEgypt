package com.example.com.sightsofegypt.data.db;

import com.example.com.sightsofegypt.App;
import com.example.com.sightsofegypt.data.model.Sight;
import com.example.com.sightsofegypt.data.model.SightDao;
import com.example.com.sightsofegypt.data.model.SightImage;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;

public class AppDbHelper implements DbHelper {

    @Override
    public boolean saveSightsFeature(ArrayList<Sight> sights) {
        for (int i = 0; i < sights.size(); i++) {
            Sight sight = sights.get(i);
            sight.setType("feature");
            sight.setUrl(sight.getImageUrl());
            App.mDaoSession.getSightDao().insertOrReplace(sight);
        }
        return true;
    }

    @Override
    public boolean saveSightsExplore(ArrayList<Sight> sights) {
        for (int i = 0; i < sights.size(); i++) {
            Sight sight = sights.get(i);
            sight.setUrl(sight.getImageUrl());
            App.mDaoSession.getSightDao().insertOrReplace(sight);
        }
        return true;
    }

    @Override
    public ArrayList<Sight> getSightsFeature() {
        Query query = App.mDaoSession.getSightDao().queryBuilder().where(
                SightDao.Properties.Type.eq("feature")
        ).build();
        return (ArrayList<Sight>) query.list();
    }

    @Override
    public ArrayList<Sight> getSightsExplore(int limit, int offset) {
        Query query = App.mDaoSession.getSightDao().queryBuilder()
                .limit(limit)
                .offset(offset)
                .where(
                        SightDao.Properties.Type.eq("explore")
                ).build();
        return (ArrayList<Sight>) query.list();
    }
}
