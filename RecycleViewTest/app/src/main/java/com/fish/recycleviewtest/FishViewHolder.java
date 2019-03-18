package com.fish.recycleviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FishViewHolder extends RecyclerView.ViewHolder {

    TextView tv;

    public FishViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
        tv = (TextView) itemView.findViewById(R.id.id_num);
    }

    public void bind(String s){
        tv.setText(s);
    }
}