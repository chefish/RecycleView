package com.fish.fishrecycleviewmultitype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fish.fishrecycleviewmultitype.base.ShowBaseData;
import com.fish.fishrecycleviewmultitype.base.ShowBaseViewHolder;

public class ImageViewHolder extends ShowBaseViewHolder<Integer> {

    ImageView iv;
    Context context;

    public ImageViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
        context = parent.getContext();
        iv = (ImageView) itemView.findViewById(R.id.image);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.fish("" + data);

            }
        });

    }


    @Override
    protected void bind(ShowBaseData object) {
        super.bind(object);
        iv.setImageDrawable(context.getDrawable(data));
    }
}