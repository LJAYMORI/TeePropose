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
    private float mFirstEventX;
    private float mFirstEventY;

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

                Log.d("action__move", "ev.getRawX : " + event.getRawX() + ", ev.getRawY : " + event.getRawY());

                break;
            }
            case MotionEvent.ACTION_UP: {
                final float x = getX();
                final float y = getY();

                setTranslationX(0);
                setTranslationY(0);

                layout((int) x, (int) y, (int) (x + getWidth()), (int) (y + getHeight()));
                break;
            }
        }
        return true;
    }

    public interface OnMoveListener {
        void onMoving(int sx, int sy, int dx, int dy);
    }
    private OnMoveListener mMoveListener;
    public void setOnMoveListener(OnMoveListener listener) {
        mMoveListener = listener;
    }
}