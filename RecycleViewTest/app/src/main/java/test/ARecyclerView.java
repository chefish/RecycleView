package test;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.fish.recycleviewtest.LogUtil;

/**
 * Created by fish on 17/3/17.
 */

public class ARecyclerView extends RecyclerView {
    public ARecyclerView(Context context) {
        super(context);
    }

    public ARecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ARecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        LogUtil.fish("ARecyclerView -> onMeasure");
        super.onMeasure(widthSpec, heightSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        LogUtil.fish("ARecyclerView -> onLayout");
        super.onLayout(changed, l, t, r, b);
    }
}
