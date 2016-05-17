package com.tee.teepropose;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by Jonguk on 2016. 5. 5..
 */
public class MovableImageView extends ImageView {
    long saveTime;
    long currTime;
    long delayTime = 500;
    private float mFirstEventX;
    private float mFirstEventY;
    private OnMoveListener mMoveListener;

    private boolean isWait = false;
    private OnStopListener mStopListener;

    public MovableImageView(Context context) {

        this(context, null, 0);

    }

    public MovableImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MovableImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                mFirstEventX = event.getRawX();
                mFirstEventY = event.getRawY();

                break;
            }
            case MotionEvent.ACTION_MOVE: {
                final float dx = event.getRawX() - mFirstEventX;
                final float dy = event.getRawY() - mFirstEventY;


                setTranslationX(dx);
                setTranslationY(dy);


                if (mMoveListener != null) {
//                    int x = (int) getX();
//                    int y = (int) getY();
//                    mMoveListener.onMoving(getId(), x, y, x + getWidth(), y + getHeight());

                    Log.d("dx:", String.valueOf(dx));
                    Log.d("dy:", String.valueOf(dy));

                    mMoveListener.onMoving(getId(), (int) event.getRawX(), (int) event.getRawY(), (int) event.getRawX(), (int) event.getRawY());


                }

                break;
            }
            case MotionEvent.ACTION_UP: {
                final float x = getX();
                final float y = getY();

                setTranslationX(0);
                setTranslationY(0);

                layout((int) x, (int) y, (int) (x + getWidth()), (int) (y + getHeight()));
                mStopListener.onStop();
                break;
            }
        }
        return true;
    }


    public void setOnMoveListener(OnMoveListener listener) {
        mMoveListener = listener;
    }

    public void setOnStopListener(OnStopListener listener) {
        mStopListener = listener;
    }

    public interface OnMoveListener {
        void onMoving(int viewID, int sx, int sy, int dx, int dy);
    }

    public interface OnStopListener {
        void onStop();
    }

}