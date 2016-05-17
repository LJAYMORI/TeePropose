package com.tee.teepropose;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
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

    boolean isAnim = false;
    private float edgeStartX;
    private float edgeStartY;
    private float edgeEndX;
    private float edgeEndY;
    private boolean isWait;
    private long saveTime;
    private long currTime;

    @Override
    protected void onResume() {
        super.onResume();
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

    Animation getAnimation() {
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        Random random = new Random();
        int rand = random.nextInt() % 200;
        rand = Math.abs(rand);
        if (rand < 100) {
            rand = 100 + rand;
        }
        anim.setDuration(500);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        return anim;

    }

    @AfterViews
    void initView() {

        final ImageView[] imageViews = new ImageView[6];

        for (int i = 0; i < 6; i++) {
            ImageView imageView = getImageView();
//            imageView.startAnimation(getAnimation());
            imageViews[i] = imageView;
            imageView.setVisibility(View.INVISIBLE);
        }


        MovableImageView.OnMoveListener moveListener = new MovableImageView.OnMoveListener() {
            @Override
            public void onMoving(int viewID, int sx, int sy, int dx, int dy) {
                Log.d("mainactivity__moving", "sx:" + sx + ", sy:" + sy + ", dx:" + dx + ", dy:" + dy);

                final int fDx = dx;
                final int fDy = dy;

                for (int i = 0; i < 3; i++) {
                    imageViews[i].setVisibility(View.VISIBLE);
                    final int index = i;
                    Random random = new Random();
                    final int rand = Math.abs(random.nextInt() % 500);

                    imageViews[index].setTranslationX(fDx - rand);
                    final int rand1 = Math.abs(random.nextInt() % 700);
                    imageViews[index].setTranslationY(fDy - rand1);
                }
            }
        };

        MovableImageView.OnMoveListener moveListener2 = new MovableImageView.OnMoveListener() {
            @Override
            public void onMoving(int viewID, int sx, int sy, int dx, int dy) {
                Log.d("mainactivity__moving2", "sx:" + sx + ", sy:" + sy + ", dx:" + dx + ", dy:" + dy);

                final int fDx = dx;
                final int fDy = dy;

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
            public void onStop() {
                for (int i = 0; i < 3; i++) {
                    imageViews[i].setVisibility(View.INVISIBLE);
                }
            }
        };

        MovableImageView.OnStopListener stopListener2 = new MovableImageView.OnStopListener() {
            @Override
            public void onStop() {
                for (int i = 3; i < 6; i++) {
                    imageViews[i].setVisibility(View.INVISIBLE);
                }
            }
        };

        leftView.setOnMoveListener(moveListener);
        rightView.setOnMoveListener(moveListener2);
        leftView.setOnStopListener(stopListener);
        rightView.setOnStopListener(stopListener2);
    }

}