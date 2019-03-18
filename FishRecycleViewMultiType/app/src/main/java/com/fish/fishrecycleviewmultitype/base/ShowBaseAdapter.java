package com.fish.fishrecycleviewmultitype.base;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fish.fishrecycleviewmultitype.LogUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by fish on 16/5/17.
 */
public abstract class ShowBaseAdapter extends RecyclerView.Adapter<ShowBaseViewHolder> {

    public static final int TYPE_REAL = 500;


    public long lastTimestamp = Long.MAX_VALUE;

    protected List<ShowBaseData> data = new ArrayList<ShowBaseData>();

    @Override
    public void onBindViewHolder(ShowBaseViewHolder holder, int position) {
//        LogUtil.fish("onBindViewHolder" + position);
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    @Override
    public int getItemViewType(int position) {
        return data.get(position).type;
    }


    public List<ShowBaseData> getData() {
        return data;
    }

    public ShowBaseData getData(int position) {
        if (position >= data.size() || position < 0)
            return null;

        return data.get(position);
    }

    /**
     * 数据是否为空
     * 可能有一种情况是getItemCount() > 0,
     * 但是事实上是空的,可以在子Adapter中重写
     *
     * @return true empty
     */
    public boolean isEmpty() {
        return getItemCount() == 0;
    }


    public void addData(int type, Object obj) {
        data.add(ShowBaseDataFactory.createRealData(type, obj));
    }

    protected void addData(int type) {
        data.add(ShowBaseDataFactory.createRealData(type, null));
    }

    /**
     * 一般只有一种type的时候，用这个方法，多个type的时候不建议用
     *
     * @param obj
     */
    protected void addDataSimple(Object obj) {
        data.add(ShowBaseDataFactory.createRealDataSimple(obj));
    }

    protected void addDataSimple(Object obj, int position) {
        data.add(position, ShowBaseDataFactory.createRealDataSimple(obj));
    }

    protected void addData(int type, Object obj, int position) {
        data.add(position, ShowBaseDataFactory.createRealData(type, obj));
    }

    protected boolean isTypeDataExist(int type) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).type == type) {
                return true;
            }
        }
        return false;
    }

//    protected void addHeadData(Object obj) {
//        data.add(ShowBaseDataFactory.createRealData(TYPE_HEAD, obj));
//    }
//
//    protected void addDataEmpty() {
//        data.add(ShowBaseDataFactory.createEmptyData());
//    }
//
//    protected void addDataString(String s) {
//        data.add(ShowBaseDataFactory.createStringData(s));
//    }

    //
    protected void addItemDecoration(RecyclerView recyclerView, final int spacing) {
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                ShowBaseAdapter.this.getItemOffsets(spacing, outRect, view, parent, state);
            }
        });

    }

    private void getItemOffsets(int space, Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildLayoutPosition(view);
        // Add top margin only for the first item to avoid double space between items
        if (position < 0 || position >= data.size()) {
            //删除feed，可能导致此处position越界
            LogUtil.fish("ShowBaseAdapter getItemOffsets out of range which position: " + position + " size: " + data.size());
            return;
        }
        getItemOffsets(space, outRect, position);
    }

    protected void getItemOffsets(int space, Rect outRect, int position) {

    }

    public void remove(ShowBaseData data) {
        getData().remove(data);
    }


    protected void removeByType(int type) {
        Iterator iter = data.iterator();
        while (iter.hasNext()) {
            ShowBaseData topic = (ShowBaseData) iter.next();
            if (topic.type == type) {
                iter.remove();
            }
        }
    }

    /**
     * 根据type和data来删
     */
    protected void remove(int type, Object obj) {
        Iterator iter = data.iterator();
        while (iter.hasNext()) {
            ShowBaseData topic = (ShowBaseData) iter.next();
            if (topic.type == type && topic.data.equals(obj)) {
                iter.remove();
            }
        }
    }

    protected void remove(int type, Object obj, int maxSize) {
        Iterator iter = data.iterator();
        int size = 0;
        while (iter.hasNext()) {
            ShowBaseData topic = (ShowBaseData) iter.next();
            if (topic.type == type && topic.data.equals(obj)) {
                iter.remove();
                size++;
                if (size == maxSize) {
                    return;
                }
            }
        }
    }

    /**
     * 获取某个类型的首项的position,如果找不到返回-1
     *
     * @param type
     * @return
     */
    public int getTypeStartPos(int type) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).type == type) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 查找在maxPosition之前，有多少个typeItem类型的数据
     *
     * @param maxPosition
     * @param typeItem
     * @return
     */
    protected int countTypeBefore(int maxPosition, int typeItem) {
        int count = 0;
        int limit = maxPosition > data.size() - 1 ? data.size() - 1 : maxPosition;
        for (int i = 0; i <= limit; i++) {
            int type = data.get(i).type;
            if (type == typeItem) {
                count++;
            }
        }
        return count;
    }

    protected int countType(int type) {
        int count = 0;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).type == type) {
                count++;
            }
        }
        return count;
    }

    public ShowBaseData getLastItem() {
        if (data.size() == 0) {
            return null;
        }
        return data.get(data.size() - 1);
    }

    static class ShowBaseDataFactory {

        static ShowBaseData createRealData(int type, Object o) {
            return new ShowBaseData(type, o);
        }

        static ShowBaseData createRealData(int type, Object o, int groupIndex) {
            return new ShowBaseData(type, o, groupIndex);
        }

        static ShowBaseData createRealDataSimple(Object o) {
            return new ShowBaseData(TYPE_REAL, o);
        }

    }
}
