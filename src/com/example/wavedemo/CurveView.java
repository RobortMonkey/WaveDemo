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
 * Created by ${huozhenpeng} on 15/9/21. Company : www.miduo.com
 */
public class CurveView extends View implements Runnable {

	private Paint paint;
	private float width;
	private float height;
	private float[] xarray;
	private float[] yarray;
	private Path path;

	public CurveView(Context context) {
		this(context, null);
	}

	public CurveView(Context context, AttributeSet attrs) {
		this(context, attrs, -1);
	}

	public CurveView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public void init() {

		paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		paint.setColor(Color.parseColor("#17425d"));
		paint.setStrokeWidth(3);
		paint.setStyle(Paint.Style.FILL);
		// paint.setPathEffect(new CornerPathEffect(20));
		path = new Path();

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		width = MeasureSpec.getSize(widthMeasureSpec);
		height = MeasureSpec.getSize(heightMeasureSpec);
		Log.e("haha", "haha" + height);
		// setMeasuredDimension(widthMeasureSpec,MeasureSpec.makeMeasureSpec((int)height,MeasureSpec.EXACTLY));

	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		width = w;
		height = h;
		xarray = new float[3];
		yarray = new float[3];
		xarray[0] = 0f;
		xarray[1] = w * 3.0f / 8;
		xarray[2] = w;

		yarray[0] = h;
		yarray[1] = 0;
		yarray[2] = h;

	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		path.reset();
		path.moveTo(xarray[0], yarray[0]);
		path.quadTo(xarray[1], yarray[1], xarray[2], yarray[2]);
		canvas.drawPath(path, paint);
		path.close();
	}

	private boolean flag = true;
	private boolean flag1;

	@Override
	public void run() {
		while (true) {

			while (flag) {
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (height == 0)
					break;

				if (yarray != null) {
					if (yarray[1] <= height) {

						yarray[1] += 10;
						xarray[1] += 5;
						postInvalidate();
					} else {
						flag = false;
						flag1 = true;

					}
				}

			}
			while (flag1) {
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (yarray[1] > 0) {
					yarray[1] -= 10;
					xarray[1] -= 5;
					postInvalidate();
				} else {
					flag = true;
					flag1 = false;
				}

			}
		}

	}
}
