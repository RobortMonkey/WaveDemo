package com.example.wavedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

public class ArrowView extends View {
	private Paint paint;
	private int paintWidth = 2;
	private int width;
	private int height;
	private int delta = 20;
	private String color;

	public ArrowView(Context context) {
		this(context, null);
	}

	public ArrowView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ArrowView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public void init() {

		paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		paint.setStrokeWidth(paintWidth);

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (TextUtils.isEmpty(color)) {
			paint.setColor(Color.parseColor("#87b953"));
		} else {
			paint.setColor(Color.parseColor(color));
		}
		canvas.drawLine(0, height * 1.0f / 3, width * 1.0f / 2 - delta,
				height * 1.0f / 3, paint);
		canvas.drawLine(width * 1.0f / 2 - delta, height * 1.0f / 3,
				width * 1.0f / 2, 0, paint);
		canvas.drawLine(width * 1.0f / 2, 0, width * 1.0f / 2 + delta,
				height * 1.0f / 3, paint);
		canvas.drawLine(width * 1.0f / 2 + delta, height * 1.0f / 3, width,
				height * 1.0f / 3, paint);
		canvas.drawLine(width, height * 1.0f / 3, width, height, paint);
		canvas.drawLine(width, height, 0, height, paint);
		canvas.drawLine(0, height, 0, height * 1.0f / 3, paint);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		width = w;
		height = h;
	}

	public void setColor(String color) {
		this.color=color;
		invalidate();

	}

}
