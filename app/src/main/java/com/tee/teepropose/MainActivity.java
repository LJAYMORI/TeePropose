package com.tee.teepropose;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    private float edgeStartX;
    private float edgeStartY;
    private float edgeEndX;
    private float edgeEndY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovableImageView leftView = (MovableImageView) findViewById(R.id.view_left);
        MovableImageView rightView = (MovableImageView) findViewById(R.id.view_right);

//        View edge = findViewById(R.id.edge);
//        int[] location = new int[2];
//        edge.getLocationInWindow(location);
//        edgeStartX = location[0];
//        edgeStartY = location[1];
//        edgeEndX = edgeStartX + edge.getWidth();
//        edgeEndY = edgeStartY + edge.getHeight();

//        ImageView edge = (ImageView) findViewById(R.id.edge);
//        Rect rect = new Rect();
//        edge.getLocalVisibleRect(rect);
//        edgeStartX = rect.left;
//        edgeStartY = rect.top;
//        edgeEndX = rect.right;
//        edgeEndY = rect.bottom;

        Log.d("mainactivity__edge", "sx:" + this.edgeStartX + ", sy:" + edgeStartY + ", dx:" + edgeEndX + ", dy:" + edgeEndY);

        MovableImageView.OnMoveListener listener = new MovableImageView.OnMoveListener() {
            @Override
            public void onMoving(int viewID, int sx, int sy, int dx, int dy) {
                Log.d("mainactivity__moving", "sx:" + sx + ", sy:" + sy + ", dx:" + dx + ", dy:" + dy);
            }
        };

        leftView.setOnMoveListener(listener);
        rightView.setOnMoveListener(listener);
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

    }

}