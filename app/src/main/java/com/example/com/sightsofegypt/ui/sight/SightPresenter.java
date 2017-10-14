package com.example.com.sightsofegypt.ui.sight;

import com.example.com.sightsofegypt.data.api.model.SightModel;
import com.example.com.sightsofegypt.data.api.model.SightModelImpl;
import com.example.com.sightsofegypt.data.db.AppDbHelper;
import com.example.com.sightsofegypt.data.db.DbHelper;
import com.example.com.sightsofegypt.data.model.Sight;
import com.example.com.sightsofegypt.ui.base.BasePresenter;

import java.util.ArrayList;

public class SightPresenter<V extends SightContract.View> extends BasePresenter<V>
        implements SightContract.Presenter<V>, SightModel.OnRespond {

    private SightModel sightModel = new SightModelImpl();
    private DbHelper dbHelper = new AppDbHelper();

    private final int LIMIT = 20;
    private int offset = 0;

    @Override
    public void getFeatureSights() {
        if (getMvpView().isNetworkConnected()) {
            getMvpView().showLoading();
            sightModel.getFeatureSights(this);
        } else  {
            ArrayList<Sight> sights = dbHelper.getSightsFeature();
            getMvpView().showFeatureSights(sights);
        }
    }

    @Override
    public void getExploreSights() {
        if (getMvpView().isNetworkConnected()) {
            getMvpView().showLoading();
            sightModel.getExploreSights(LIMIT, offset,this);
        } else  {
            ArrayList<Sight> sights = dbHelper.getSightsExplore(LIMIT, offset);
            getMvpView().showExploreSights(sights);
            offset += LIMIT;
        }
    }

    @Override
    public void getMoreExploreSights() {
        if (getMvpView().isNetworkConnected()) {
            sightModel.getMoreExplore(LIMIT, offset, this);
        } else  {
            ArrayList<Sight> sights = dbHelper.getSightsExplore(LIMIT, offset);
            getMvpView().updateExploreSights(sights);
            offset += LIMIT;
        }
    }

    @Override
    public void successFeature(ArrayList<Sight> sights) {
        if (isViewAttached()) {
            getMvpView().hideLoading();
            getMvpView().showFeatureSights(sights);
            dbHelper.saveSightsFeature(sights);
        }
    }

    @Override
    public void successExplore(ArrayList<Sight> sights) {
        offset += LIMIT;
        if (isViewAttached()) {
            getMvpView().hideLoading();
            getMvpView().showExploreSights(sights);
        }
    }

    @Override
    public void successLoadMore(ArrayList<Sight> sights) {
        offset += LIMIT;
        if (isViewAttached()) {
            getMvpView().updateExploreSights(sights);
            dbHelper.saveSightsExplore(sights);
        }
    }

    @Override
    public void fail() {
        if (isViewAttached()) {
            getMvpView().hideLoading();
        }
    }
}
