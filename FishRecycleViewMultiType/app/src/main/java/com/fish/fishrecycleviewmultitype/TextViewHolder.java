package com.fish.fishrecycleviewmultitype;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fish.fishrecycleviewmultitype.base.ShowBaseData;
import com.fish.fishrecycleviewmultitype.base.ShowBaseViewHolder;

public class TextViewHolder extends ShowBaseViewHolder<String> {

    TextView tv;

    public TextViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false));
        tv = (TextView) itemView.findViewById(R.id.id_num);
    }


    @Override
    protected void bind(ShowBaseData object) {
        super.bind(object);
        tv.setText(getData());
    }
}