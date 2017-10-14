package com.example.com.sightsofegypt.ui.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.com.sightsofegypt.R;
import com.example.com.sightsofegypt.data.model.Sight;
import com.example.com.sightsofegypt.ui.base.BaseActivity;
import com.example.com.sightsofegypt.utils.ActivityUtils;

public class SightDetailsActivity extends BaseActivity {

    final static String SIGHT_KEY = "sight";

    public static Intent newInstance(Context context, Sight sight) {
        Intent intent = new Intent(context, SightDetailsActivity.class);
        intent.putExtra(SIGHT_KEY, sight);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sight_details);
        setUp();
    }

    @Override
    protected void setUp() {
        Sight sight = new Sight();

        if (getIntent() != null)
            sight = getIntent().getParcelableExtra(SIGHT_KEY);

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), SightDetailsFragment.newInstance(sight));
    }
}
