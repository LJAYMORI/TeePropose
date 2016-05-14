package com.tee.teepropose;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_images)
public class ImagesActivity extends AppCompatActivity {

    private static final int MAXIMU_SCROLL_DISTANCE = 20;

    private int scroll = 0;

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ImageListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ImageListAdapter();
        recyclerView.setAdapter(mAdapter);

        mAdapter.addItems(0, 0, 0, 0, 0, 0, 0, 0);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                if (layoutManager.findLastCompletelyVisibleItemPosition() < mAdapter.getItemCount() - 1) {
                    recyclerView.smoothScrollBy(scroll > MAXIMU_SCROLL_DISTANCE ? MAXIMU_SCROLL_DISTANCE : scroll++, 0);
                    recyclerView.postDelayed(this, 100);
                }
            }
        };

        recyclerView.post(r);

    }
}
