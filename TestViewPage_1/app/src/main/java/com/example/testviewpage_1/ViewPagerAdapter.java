package com.example.testviewpage_1;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fish on 16/6/7.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private List<ViewWrapper> viewList = new ArrayList<ViewWrapper>();//view数组
    private Context context;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    public void init() {
        for (int i = 0; i < 10; i++) {
            View view1 = LayoutInflater.from(context).inflate(R.layout.layout1, null);
            TextView tv = (TextView) view1.findViewById(R.id.text);
            tv.setText("" + i);
            ViewWrapper wrapper = new ViewWrapper();
            wrapper.view = view1;
            wrapper.s = "" + i;

            viewList.add(wrapper);
        }
    }

    public class ViewWrapper {
        View view;
        String s;
        boolean used;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        ViewWrapper wrapper = (ViewWrapper) arg1;
        return arg0 == wrapper.view;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
        LogUtil.fish("destroyItem");
        ViewWrapper wrapper = (ViewWrapper) object;
        wrapper.used = false;
        container.removeView(wrapper.view);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LogUtil.fish("instantiateItem");
        ViewWrapper wrapper = getUnusedWraper();
        TextView tv = (TextView) wrapper.view.findViewById(R.id.text);
        tv.setText("" + position);
        container.addView(wrapper.view);
        return wrapper;
    }

    private ViewWrapper getUnusedWraper() {
        for (ViewWrapper wrapper : viewList) {
            if (!wrapper.used) {
                wrapper.used = true;
                return wrapper;
            }
        }
        throw new RuntimeException("dff");
    }

}
