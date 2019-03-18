package com.fish.fishrecycleviewmultitype.base;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fish.fishrecycleviewmultitype.LogUtil;


/**
 * list间距，
 * 以横向为例，第一个离左边2*halfSpace,相邻2个之间间距halfSpace*2，最后一个离右边间距2*halfSpace
 */
public class ListSpacesItemDecoration extends RecyclerView.ItemDecoration {
    /**
     * 间距的一半
     */
    private int halfSpace;

    //是否是水平
    private boolean isHori;

    public ListSpacesItemDecoration(int space) {
        this.halfSpace = space / 2;
    }

    public ListSpacesItemDecoration(int space, boolean isHori) {
        this.halfSpace = space / 2;
        this.isHori = isHori;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        if (isHori) {
            outRect.left = halfSpace;
            outRect.right = halfSpace;
            int position = parent.getChildLayoutPosition(view);
            LogUtil.fish("ListSpacesItemDecoration position " + position);
            if (position == 0) {
                outRect.left = 2 * halfSpace;
            } else if (position == parent.getAdapter().getItemCount() - 1) {
                outRect.right = 2 * halfSpace;
            }
        } else {
            outRect.top = halfSpace;
            outRect.bottom = halfSpace;
            int position = parent.getChildLayoutPosition(view);
            if (position == 0) {
                outRect.top = 2 * halfSpace;
            } else if (position == parent.getAdapter().getItemCount() - 1) {
                outRect.bottom = 2 * halfSpace;
            }
        }
    }
}