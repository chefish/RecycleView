package com.fish.recycleviewtest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 最简单的recycleview
 * http://blog.csdn.net/litefish/article/details/51582791
 */
public class MainActivity extends AppCompatActivity {
    private List<String> mDatas;
    private RecyclerView recyclerView;
    private FishAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        initData();
        initRecycleView();
    }

    private void initRecycleView() {
        adapter = new FishAdapter();
        //必须指定adapter
        recyclerView.setAdapter(adapter);

        adapter.setData(mDatas);


//        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
//            @Override
//            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//                super.onDraw(c, parent, state);
//                Paint paint = new Paint();
//                paint.setColor(Color.RED);
//
//                for (int i = 0; i < parent.getLayoutManager().getChildCount(); i++) {
//                    final View child = parent.getChildAt(i);
//
//                    float left = child.getLeft() + (child.getRight() - child.getLeft()) / 4;
//                    float top = child.getTop();
//                    float right = left + (child.getRight() - child.getLeft()) / 2;
//                    float bottom = top + 5;
//
//                    c.drawRect(left, top, right, bottom, paint);
//                }
//            }
//        });

    }


    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }
}
