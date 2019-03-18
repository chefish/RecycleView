package test;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.fish.recycleviewtest.LogUtil;

/**
 * Created by fish on 17/3/20.
 */

public class ATextView extends TextView {

    public ATextView(Context context) {
        super(context);
    }

    public ATextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ATextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ATextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtil.fish("onDetachedFromWindow");
    }
}
