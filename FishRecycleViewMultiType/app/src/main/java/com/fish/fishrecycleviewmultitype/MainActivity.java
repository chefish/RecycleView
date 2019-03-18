package com.fish.fishrecycleviewmultitype;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fish.fishrecycleviewmultitype.base.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 最简单的recycleview
 * http://blog.csdn.net/litefish/article/details/51582791
 */
public class MainActivity extends AppCompatActivity {
    private List<String> mDatas;
    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        initData();
        initRecycleView();
    }

    private void initRecycleView() {
        adapter = new MyAdapter();
        //必须指定adapter
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(0,0,0,100);
            }
        });

//        recyclerView.addItemDecoration(new DividerItemDecoration(this,
//                DividerItemDecoration.VERTICAL_LIST,R.drawable.divider));


        for (int i = 'A'; i < 'g'; i++) {
            if ((i - 'A') % 2 == 1||true) {
                adapter.addData(MyAdapter.TYPE_TEXT, "" + (char) i);
            } else {
                adapter.addData(MyAdapter.TYPE_IMAGE, R.drawable.p1);
            }
        }
    }

    protected void initData() {
        mDatas = new ArrayList<String>();

    }
}
