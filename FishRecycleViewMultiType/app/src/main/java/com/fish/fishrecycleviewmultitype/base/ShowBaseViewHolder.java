package com.fish.fishrecycleviewmultitype.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fish on 16/5/17.
 */
public class ShowBaseViewHolder<T extends Object> extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    protected Context context;
    protected T data;

    protected T getData() {
        return data;
    }

    public ShowBaseViewHolder(ViewGroup parent, int layoutId) {
        this(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    }

    public ShowBaseViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    protected void bind(ShowBaseData object) {
        data = (T) object.data;
    }

    public Context getContext() {
        return context;
    }

    protected void addOnClickListener(View... views) {
        for (int i = 0; i < views.length; i++) {
            views[i].setOnClickListener(this);
        }
    }

    protected void addOnLongClickListener(View... views) {
        for (int i = 0; i < views.length; i++) {
            views[i].setOnLongClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
