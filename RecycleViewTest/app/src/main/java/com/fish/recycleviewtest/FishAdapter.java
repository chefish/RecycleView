package com.fish.recycleviewtest;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by fish on 16/6/4.
 */
public class FishAdapter extends RecyclerView.Adapter<FishViewHolder> {
    private List<String> data;

    public FishAdapter() {

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        //必须指定layoutmanager
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }

    @Override
    public FishViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LogUtil.fish("onCreateViewHolder");
        FishViewHolder holder = new FishViewHolder(parent);
        return holder;
    }

    @Override
    public void onBindViewHolder(FishViewHolder holder, int position) {
        LogUtil.fish("onBindViewHolder " + position);
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<String> pDatas) {
        data = pDatas;
    }
}

