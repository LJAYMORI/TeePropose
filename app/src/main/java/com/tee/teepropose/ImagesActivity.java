package com.tee.teepropose;

import android.media.MediaPlayer;
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
                new ImageListData(R.mipmap.p1, "티 프로포즈"),
                new ImageListData(R.mipmap.p2, "티 프로포즈"),
                new ImageListData(R.mipmap.p3, "티 프로포즈"),
                new ImageListData(R.mipmap.p4, "티 프로포즈"),
                new ImageListData(R.mipmap.p5, "티 프로포즈"),
                new ImageListData(R.mipmap.p6, "티 프로포즈"),
                new ImageListData(R.mipmap.p7, "티 프로포즈"),
                new ImageListData(R.mipmap.p8, "티 프로포즈"),
                new ImageListData(R.mipmap.p9, "티 프로포즈"),
                new ImageListData(R.mipmap.p10, "티 프로포즈"),
                new ImageListData(R.mipmap.p11, "티 프로포즈")
        );

        Runnable r = new Runnable() {
            @Override
            public void run() {
                if (layoutManager.findLastCompletelyVisibleItemPosition() < mAdapter.getItemCount() - 1) {
                    recyclerView.smoothScrollBy(scroll > MAXIMU_SCROLL_DISTANCE ? MAXIMU_SCROLL_DISTANCE : scroll++, 0);
                    recyclerView.postDelayed(this, 100);
                } else {
                    LetterActivity_.intent(ImagesActivity.this).start();
                }
            }
        };

        recyclerView.post(r);
        playMusic();
    }


    @Background
    void playMusic() {
        MediaPlayer mediaPlayer
                = MediaPlayer.create(this, R.raw.bgm);
        mediaPlayer.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
