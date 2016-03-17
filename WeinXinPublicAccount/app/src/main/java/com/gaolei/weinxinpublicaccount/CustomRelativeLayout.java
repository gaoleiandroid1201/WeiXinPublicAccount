package com.gaolei.weinxinpublicaccount;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import com.gaolei.weinxinpublicaccount.jiekou.MyInterface.FinishActivityListener;

/**
 * Created by Administrator on 2015/12/15.
 */
public class CustomRelativeLayout extends RelativeLayout {

    private FinishActivityListener finishActivityListener;
    private int downX;
    private int tempX;

    public void setFinishActivityListener(FinishActivityListener finishActivityListener) {
        this.finishActivityListener = finishActivityListener;
    }

    private GestureDetector mGestureDetector;

    public CustomRelativeLayout(Context context) {
        super(context);
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        //说明将onTouch拦截在此控件，进而执行此控件的onTouchEvent
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX =(int) event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveX = (int) event.getRawX();
                Log.d("gaolei", "moveX-----------------" + moveX);
                Log.d("gaolei", "downX-----------------" + downX);
                if (moveX - downX > 5 && downX < 50) {
                    finishActivityListener.onFinishActivity();
                }
                break;
        }
        return super.onInterceptTouchEvent(event);
    }
}
