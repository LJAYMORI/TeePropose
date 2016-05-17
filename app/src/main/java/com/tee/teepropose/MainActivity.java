package com.tee.teepropose;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.Random;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.view_left)
    MovableImageView leftView;
    @ViewById(R.id.view_right)
    MovableImageView rightView;
    @ViewById(R.id.vg_main)
    RelativeLayout vgMain;
    @ViewById(R.id.edge)
    ImageView emptyHeart;
    @ViewById(R.id.iv_full_heart)
    ImageView fullHeart;
    @ViewById(R.id.edge_left)
    ImageView edgeLeft;
    @ViewById(R.id.edge_right)
    ImageView edgeRight;

    boolean isAnim = false;
    SoundPool soundPool;
    int dalkak;
    int heartbeat;
    private boolean isMakeHalf = false;


    @Click(R.id.iv_full_heart)
    void clickHeart() {
        ImagesActivity_.intent(this).start();
    }

    public ImageView getImageView() {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.heart);
        Random random = new Random();
        int rand = random.nextInt() % 30;
        rand = Math.abs(rand);
        if (rand < 10) {
            rand = 10 + rand;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(rand, rand);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        vgMain.addView(imageView);
        return imageView;
    }

    private boolean isInBoundary(int viewID, int sx, int sy, int dx, int dy) {
        switch (viewID) {
            case R.id.view_left: {

            }
            case R.id.view_right: {

            }
        }
        return false;
    }

    @AfterInject
    void initObject() {

    }

    @AfterViews
    void initView() {

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        dalkak = soundPool.load(this, R.raw.dalkak, 1);
        heartbeat = soundPool.load(this, R.raw.heartbeat, 1);
        final ImageView[] imageViews = new ImageView[6];

        for (int i = 0; i < 6; i++) {
            ImageView imageView = getImageView();
            imageViews[i] = imageView;
            imageView.setVisibility(View.INVISIBLE);
        }


        MovableImageView.OnMoveListener moveListener = new MovableImageView.OnMoveListener() {
            @Override
            public void onMoving(int viewID, int sx, int sy, int dx, int dy) {
                Log.d("mainactivity__moving", "sx:" + sx + ", sy:" + sy + ", dx:" + dx + ", dy:" + dy);

                final int fDx = dx;
                final int fDy = dy;

                Log.e("sx", sx + "");
                Log.e("sy", sy + "");

                for (int i = 0; i < 3; i++) {
                    imageViews[i].setVisibility(View.VISIBLE);
                    final int index = i;
                    Random random = new Random();
                    final int rand = Math.abs(random.nextInt() % 500);

                    imageViews[index].setTranslationX(fDx - rand);
                    final int rand1 = Math.abs(random.nextInt() % 700);
                    imageViews[index].setTranslationY(fDy - rand1);
                }

                Log.e("edgeLeft", edgeLeft.getX() + "");
                Log.e("edgeRight", edgeLeft.getY() + "");
            }
        };

        MovableImageView.OnMoveListener moveListener2 = new MovableImageView.OnMoveListener() {
            @Override
            public void onMoving(int viewID, int sx, int sy, int dx, int dy) {
                Log.d("mainactivity__moving2", "sx:" + sx + ", sy:" + sy + ", dx:" + dx + ", dy:" + dy);

                final int fDx = dx;
                final int fDy = dy;

                Log.e("sx", sx + "");
                Log.e("sy", sy + "");

                for (int i = 3; i < 6; i++) {
                    imageViews[i].setVisibility(View.VISIBLE);
                    final int index = i;
                    Random random = new Random();
                    final int rand = Math.abs(random.nextInt() % 500) * -1;

                    imageViews[index].setTranslationX(fDx - rand);
                    final int rand1 = Math.abs(random.nextInt() % 700);
                    imageViews[index].setTranslationY(fDy - rand1);
                }

            }
        };

        MovableImageView.OnStopListener stopListener = new MovableImageView.OnStopListener() {
            @Override
            public void onStop(int x, int y) {
                for (int i = 0; i < 3; i++) {
                    imageViews[i].setVisibility(View.INVISIBLE);
                }
                if ((x > 480 && x < 570) && (y > 450 && y < 550)) {
                    if (!isMakeHalf) {
                        showLeftHeart();
                        isMakeHalf = true;
                        soundPool.play(dalkak, 1, 1, 0, 0, 1);
                    } else {
                        showHeart();
                        soundPool.play(heartbeat, 1, 1, 0, 0, 1);
                    }
                }

            }
        };

        MovableImageView.OnStopListener stopListener2 = new MovableImageView.OnStopListener() {
            @Override
            public void onStop(int x, int y) {
                for (int i = 3; i < 6; i++) {
                    imageViews[i].setVisibility(View.INVISIBLE);
                }

                if ((x > 630 && x < 720) && (y > 480 && y < 570)) {
                    if (!isMakeHalf) {
                        showRightHeart();
                        isMakeHalf = true;
                        soundPool.play(dalkak, 1, 1, 0, 0, 1);
                    } else {
                        showHeart();
                        soundPool.play(heartbeat, 1, 1, 0, 0, 1);
                    }
                }
            }
        };

        leftView.setOnMoveListener(moveListener);
        rightView.setOnMoveListener(moveListener2);
        leftView.setOnStopListener(stopListener);
        rightView.setOnStopListener(stopListener2);

        initHeart();
    }

    void initHeart() {
        emptyHeart.setVisibility(View.VISIBLE);
        fullHeart.setVisibility(View.INVISIBLE);
        edgeLeft.setVisibility(View.INVISIBLE);
        edgeRight.setVisibility(View.INVISIBLE);
    }

    void showLeftHeart() {
        fullHeart.setVisibility(View.INVISIBLE);
        edgeLeft.setVisibility(View.VISIBLE);
        edgeRight.setVisibility(View.INVISIBLE);
        leftView.setVisibility(View.INVISIBLE);
    }

    void showRightHeart() {
        fullHeart.setVisibility(View.INVISIBLE);
        edgeRight.setVisibility(View.VISIBLE);
        edgeLeft.setVisibility(View.INVISIBLE);
        rightView.setVisibility(View.INVISIBLE);
    }

    void showHeart() {
        edgeLeft.setVisibility(View.INVISIBLE);
        edgeRight.setVisibility(View.INVISIBLE);
        fullHeart.setVisibility(View.VISIBLE);
        edgeRight.setVisibility(View.INVISIBLE);
        emptyHeart.setVisibility(View.INVISIBLE);
        leftView.setVisibility(View.INVISIBLE);
        rightView.setVisibility(View.INVISIBLE);
        Animation scale = new ScaleAnimation(1, 1.5f, 1f, 1.5f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setRepeatCount(-1);
        scale.setDuration(1000);
        AnimationSet animSet = new AnimationSet(true);
        animSet.setFillEnabled(true);
        animSet.addAnimation(scale);
        fullHeart.startAnimation(animSet);
    }

}