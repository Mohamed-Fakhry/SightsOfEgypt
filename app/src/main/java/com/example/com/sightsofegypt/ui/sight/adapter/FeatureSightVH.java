package com.example.com.sightsofegypt.ui.sight.adapter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.com.sightsofegypt.R;
import com.example.com.sightsofegypt.data.model.Sight;
import com.example.com.sightsofegypt.ui.base.BaseViewHolder;
import com.example.com.sightsofegypt.ui.details.SightDetailsActivity;
import com.example.com.sightsofegypt.ui.details.SightDetailsFragment;
import com.example.com.sightsofegypt.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeatureSightVH extends BaseViewHolder {

    @BindView(R.id.sightIV)
    ImageView sightIV;
    @BindView(R.id.priceTV)
    TextView priceTV;

    FeatureSightVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    protected void clear() {}

    @Override
    public void onBind(final Sight sight) {
        super.onBind(sight);

        if (sight.getImageUrl() != null) {
            String url = sight.getImageUrl().replaceFirst("http", "https");
            Glide.with(itemView.getContext())
                    .load(url)
                    .asBitmap()
                    .into(sightIV);
        }

        priceTV.setText(String.format("%1$,.0f$", sight.getPrice()));

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((Activity) itemView.getContext()).findViewById(R.id.detailsContainer) != null) {
                    ActivityUtils.addFragmentToActivity(R.id.detailsContainer,
                            ((AppCompatActivity) itemView.getContext()).getSupportFragmentManager(),
                            SightDetailsFragment.newInstance(sight));
                } else {
                    itemView.getContext().startActivity(SightDetailsActivity.newInstance(itemView.getContext(), sight));
                }
            }
        });
    }
}
