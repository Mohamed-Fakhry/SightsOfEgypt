package com.example.com.sightsofegypt.ui.sight.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.com.sightsofegypt.R;
import com.example.com.sightsofegypt.data.model.Sight;
import com.example.com.sightsofegypt.ui.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class SightAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_FEATURE = 0;
    public static final int VIEW_TYPE_EXPLORE = 1;

    private ArrayList<Sight> sights = new ArrayList<>();
    private int currentViewType = 0;

    public SightAdapter(ArrayList<Sight> sights, int currentViewType) {
        this.sights = sights;
        this.currentViewType = currentViewType;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (currentViewType) {
            case VIEW_TYPE_EXPLORE:
                return new ExploreSightVH(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_explore, parent, false));
            case VIEW_TYPE_FEATURE:
            default:
                return new FeatureSightVH(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feature, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(sights.get(position));
    }

    public void addItems(ArrayList<Sight> sights) {
        this.sights.addAll(sights);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return sights.size();
    }
}
