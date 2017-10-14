
package com.example.com.sightsofegypt.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.com.sightsofegypt.data.model.Sight;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    protected abstract void clear();

    public void onBind(Sight sight) {
        clear();
    }
}
