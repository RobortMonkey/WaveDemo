package com.example.wavedemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by ${huozhenpeng} on 15/9/29.
 * Company : www.miduo.com
 */
public class CustomerView extends LinearLayout {

    private ViewDragHelper dragHelper;

    public CustomerView(Context context) {
        super(context);
        init();
    }

    public CustomerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @SuppressLint("NewApi")
	public CustomerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init()
    {
        dragHelper=ViewDragHelper.create(this,new ViewDragHelper.Callback(){


            @Override
            public boolean tryCaptureView(View child, int pointerId) {
//                return child==findViewById(R.id.textview);
                return true;
            }

            /**
             * 经测试left是child距离其父容器左边的距离（父容器的padding也算）,dx是距离其初始位置的相对值，偏左为负
             * 偏右为正
             * 返回值是child距离父容器左边的距离范围(不能写死)
             */
            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
//                Log.e("aaaaaa",left+"aa"+dx);
//                return 0;
            	final int leftBound = getPaddingLeft();
                final int rightBound = getWidth() - child.getWidth() - leftBound;

                final int newLeft = Math.min(Math.max(left, leftBound), rightBound);
                Log.e("aaaaaa", leftBound+"aaaaaa"+rightBound+"aaaaaa"+left+"aaaaaa"+newLeft);

                return newLeft;

            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return dragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        dragHelper.processTouchEvent(event);
        return true;
    }
}
