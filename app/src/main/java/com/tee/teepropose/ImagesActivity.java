package com.tee.teepropose;

import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_images)
public class ImagesActivity extends AppCompatActivity {

    private static final int MAXIMU_SCROLL_DISTANCE = 20;
    public boolean loaded;
    private int scroll = 0;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ImageListAdapter mAdapter;
    private int bgm;
    private SoundPool soundPool;

    @AfterViews
    void initViews() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ImageListAdapter();
        recyclerView.setAdapter(mAdapter);

        mAdapter.addItems(
                new ImageListData(R.mipmap.p1, "10년간"),
                new ImageListData(R.mipmap.p2, "지켜온"),
                new ImageListData(R.mipmap.p3, "우리의"),
                new ImageListData(R.mipmap.p4, "사랑을"),
                new ImageListData(R.mipmap.p5, "자축하고"),
                new ImageListData(R.mipmap.p6, "기억하고"),
                new ImageListData(R.mipmap.p7, "추억하며"),
                new ImageListData(R.mipmap.p8, "우리가"),
                new ImageListData(R.mipmap.p9, "하나되기 전"),
                new ImageListData(R.mipmap.p10, "마지막"),
                new ImageListData(R.mipmap.p11, "편지")
        );

        Runnable r = new Runnable() {
            @Override
            public void run() {
                if (layoutManager.findLastCompletelyVisibleItemPosition() < mAdapter.getItemCount() - 1) {
                    recyclerView.smoothScrollBy(scroll > MAXIMU_SCROLL_DISTANCE ? MAXIMU_SCROLL_DISTANCE : scroll++, 0);
                    recyclerView.postDelayed(this, 100);
                } else {
                    LetterActivity_.intent(ImagesActivity.this).start();
                    finish();
                }
            }
        };

        recyclerView.post(r);
        playMusic();
    }


    @Background
    void playMusic() {
        Intent bgmService = new Intent(this, BGMService.class);
        startService(bgmService);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
