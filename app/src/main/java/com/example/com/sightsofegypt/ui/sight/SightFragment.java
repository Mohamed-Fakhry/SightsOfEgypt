package com.example.com.sightsofegypt.ui.sight;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.sightsofegypt.R;
import com.example.com.sightsofegypt.ui.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SightFragment extends BaseFragment {


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
        View view = inflater.inflate(R.layout.fragment_sight, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        return view;
    }

    @Override
    protected void setUp(View view) {

    }
}
