package com.fish.fishrecycleviewmultitype;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.fish.fishrecycleviewmultitype.base.ShowBaseAdapter;
import com.fish.fishrecycleviewmultitype.base.ShowBaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fish on 16/6/4.
 */
public class MyAdapter extends ShowBaseAdapter {

    public static final int TYPE_TEXT = 1;
    public static final int TYPE_IMAGE = 2;


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        //必须指定layoutmanager
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }

    @Override
    public ShowBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LogUtil.fish("onCreateViewHolder");
        switch (viewType) {
            case TYPE_TEXT:
                return new TextViewHolder(parent);
            case TYPE_IMAGE:
                return new ImageViewHolder(parent);
        }
        return null;
    }


}

