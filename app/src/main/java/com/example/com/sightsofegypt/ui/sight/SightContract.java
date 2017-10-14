package com.example.com.sightsofegypt.ui.sight;


import com.example.com.sightsofegypt.data.model.Sight;
import com.example.com.sightsofegypt.ui.base.MvpPresenter;
import com.example.com.sightsofegypt.ui.base.MvpView;

import java.util.ArrayList;

public interface SightContract {

    interface View extends MvpView {
        void showFeatureSights(ArrayList<Sight> sights);

        void showExploreSights(ArrayList<Sight> sights);

        void updateExploreSights(ArrayList<Sight> sights);
    }

    interface Presenter<V extends View> extends MvpPresenter<V> {
        void getFeatureSights();

        void getExploreSights();

        void getMoreExploreSights();
    }
}
