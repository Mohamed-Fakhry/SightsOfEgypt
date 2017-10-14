package com.example.com.sightsofegypt.ui.sight;

import android.os.Bundle;

import com.example.com.sightsofegypt.R;
import com.example.com.sightsofegypt.ui.base.BaseActivity;
import com.example.com.sightsofegypt.utils.ActivityUtils;

public class SightsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sights);
        setUp();
    }

    @Override
    protected void setUp() {
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), SightFragment.newInstance());
    }
}
