package com.example.wavedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by ${huozhenpeng} on 15/9/21.
 * Company : www.miduo.com
 */
public class CurveView2 extends View implements Runnable{

    private Paint paint;
    private float width;
    private float height;
    private float[] xarray;
    private float[] yarray;
    private Path path;

    public CurveView2(Context context) {
        this(context, null);
    }

    public CurveView2(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public CurveView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {

        paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        paint.setColor(Color.parseColor("#17425d"));
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.FILL);
//        paint.setPathEffect(new CornerPathEffect(20));
        path=new Path();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width=MeasureSpec.getSize(widthMeasureSpec);
        height=MeasureSpec.getSize(heightMeasureSpec);
        Log.e("haha","haha"+height);
//        setMeasuredDimension(widthMeasureSpec,MeasureSpec.makeMeasureSpec((int)height,MeasureSpec.EXACTLY));

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width=w;
        height=h;
        xarray=new float[5];
        yarray=new float[5];
        xarray[0]=0f;
        xarray[1]=w*3.0f/8;
        xarray[2]=w*5.0f/8;
        xarray[3]=w;

        yarray[0]=h*3.0f/4;
        yarray[1]=h*1.0f/4;
        yarray[2]=h*3.0f/4;
        yarray[3]=h*1.0f/4;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.reset();
        path.moveTo(xarray[0],yarray[0]);
        path.cubicTo(xarray[1], yarray[1], xarray[2], yarray[2], xarray[3], yarray[3]);
        path.lineTo(xarray[3],height);
        path.lineTo(0,height);
        path.close();
        canvas.drawPath(path,paint);
    }


    private boolean flag=true;
    private boolean flag2=false;
    @Override
    public void run() {
    	
        while(true) {
        	
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(height==0)
        		break;
            while (flag2) {
                if (yarray[1] >= 3.0 * height / 4 || yarray[2] <= 1.0f * width / 4) {
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    yarray[2] += 5;
                    yarray[1] -= 5;
                    postInvalidate();
                } else {
                    flag2 = false;
                    flag = true;
                }


            }
            while (flag) {

                if (yarray[1] <= 3.0 * height / 4 || yarray[2] >= 1.0f * width / 4) {
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    yarray[1] += 5;
                    yarray[2] -= 5;
                    postInvalidate();
                } else {
                    flag = false;
                    flag2 = true;
                }


            }
        }


    }
}
