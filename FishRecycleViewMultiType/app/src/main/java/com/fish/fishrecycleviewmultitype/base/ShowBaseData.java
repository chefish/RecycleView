package com.fish.fishrecycleviewmultitype.base;

/**
 * Created by fish on 16/5/17.
 */
public class ShowBaseData {
    public int type;
    public Object data;
    public boolean hiddenLine;

    //如果用到了，那增删数据的时候，记得修改
    public int groupIndex; // 组内的index

    public ShowBaseData(int type, Object o) {
        this.type = type;
        data = o;
    }

    public ShowBaseData(int type, Object obj,int groupIndex) {
        this.type = type;
        data = obj;
        this.groupIndex=groupIndex;
    }
}
