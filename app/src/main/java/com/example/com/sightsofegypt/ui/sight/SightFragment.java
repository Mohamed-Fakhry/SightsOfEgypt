package com.example.com.sightsofegypt.ui.sight;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.sightsofegypt.R;
import com.example.com.sightsofegypt.data.model.Sight;
import com.example.com.sightsofegypt.ui.base.BaseFragment;
import com.example.com.sightsofegypt.ui.custom.InteractiveScrollView;
import com.example.com.sightsofegypt.ui.sight.adapter.SightAdapter;
import com.example.com.sightsofegypt.utils.ActivityUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SightFragment extends BaseFragment implements SightContract.View,
        InteractiveScrollView.OnBottomReachedListener {

    @BindView(R.id.featuredRV)
    RecyclerView featureRV;
    @BindView(R.id.exploreRV)
    RecyclerView exploreRV;
    @BindView(R.id.scrollView)
    InteractiveScrollView scrollView;

    SightContract.Presenter<SightFragment> sightPresenter;
    SightAdapter featureSightAdapter;
    SightAdapter exploreSightAdapter;
    ArrayList<Sight> featureSights = new ArrayList<>();
    ArrayList<Sight> exploreSights = new ArrayList<>();

    public SightFragment() {}

    public static SightFragment newInstance() {
        SightFragment fragment = new SightFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sights, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        return view;
    }

    @Override
    protected void setUp(View view) {
        featureSightAdapter = new SightAdapter(featureSights, SightAdapter.VIEW_TYPE_FEATURE);
        featureRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        featureRV.setAdapter(featureSightAdapter);

        exploreSightAdapter = new SightAdapter(exploreSights, SightAdapter.VIEW_TYPE_EXPLORE);
        exploreRV.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        exploreRV.setAdapter(exploreSightAdapter);

        sightPresenter = new SightPresenter<>();
        sightPresenter.onAttach(this);
        sightPresenter.getFeatureSights();
        sightPresenter.getExploreSights();

        scrollView.setOnBottomReachedListener(this);
    }

    @Override
    public void showFeatureSights(ArrayList<Sight> sights) {
        featureSightAdapter.addItems(sights);
    }

    @Override
    public void showExploreSights(ArrayList<Sight> sights) {
        exploreSightAdapter.addItems(sights);
    }

    @Override
    public void updateExploreSights(ArrayList<Sight> sights) {
        exploreSightAdapter.addItems(sights);
    }

    @Override
    public void onBottomReached() {
        sightPresenter.getMoreExploreSights();
    }
}
