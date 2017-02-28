package com.example.wavedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * 孙群 http://blog.csdn.net/iispring
 */
public class MyView1 extends View {

	Paint paint;
	float cellSize = 0;
	float cellHorizontalOffset = 0;
	float cellVerticalOffset = 0;
	float circleRadius = 0;
	float rectSize = 0;
	int circleColor = 0xffffcc44;// 黄色
	int rectColor = 0xff66aaff;// 蓝色
	float textSize; //= getResources().getDimensionPixelSize(R.dimen.textSize);

	private static final Xfermode[] sModes = {
			new PorterDuffXfermode(PorterDuff.Mode.CLEAR),
			new PorterDuffXfermode(PorterDuff.Mode.SRC),
			new PorterDuffXfermode(PorterDuff.Mode.DST),
			new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER),
			new PorterDuffXfermode(PorterDuff.Mode.DST_OVER),
			new PorterDuffXfermode(PorterDuff.Mode.SRC_IN),
			new PorterDuffXfermode(PorterDuff.Mode.DST_IN),
			new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT),
			new PorterDuffXfermode(PorterDuff.Mode.DST_OUT),
			new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP),
			new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP),
			new PorterDuffXfermode(PorterDuff.Mode.XOR),
			new PorterDuffXfermode(PorterDuff.Mode.DARKEN),
			new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN),
			new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY),
			new PorterDuffXfermode(PorterDuff.Mode.SCREEN) };

	private static final String[] sLabels = { "Clear", "Src", "Dst", "SrcOver",
			"DstOver", "SrcIn", "DstIn", "SrcOut", "DstOut", "SrcATop",
			"DstATop", "Xor", "Darken", "Lighten", "Multiply", "Screen" };

	public MyView1(Context context) {
		super(context);
		init(null, 0);
	}

	public MyView1(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs, 0);
	}

	public MyView1(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs, defStyle);
	}

	private void init(AttributeSet attrs, int defStyle) {
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setTextSize(textSize);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setStrokeWidth(2);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// 设置背景色
		canvas.drawARGB(0, 0, 0, 0);

		int canvasWidth = canvas.getWidth();
		int canvasHeight = canvas.getHeight();
		int layerId = canvas.saveLayer(0, 0, canvasWidth, canvasHeight, null,
				Canvas.ALL_SAVE_FLAG);
		int r = canvasWidth / 3;
		// 正常绘制黄色的圆形
		paint.setColor(0xFFFFCC44);
		canvas.drawCircle(r, r, r, paint);
		// 使用CLEAR作为PorterDuffXfermode绘制蓝色的矩形
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
		paint.setColor(0xFF66AAFF);
		canvas.drawRect(r, r, r * 2.7f, r * 2.7f, paint);
		// 最后将画笔去除Xfermode
		paint.setXfermode(null);
		canvas.restoreToCount(layerId);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		cellSize = w / 4.5f;
		cellHorizontalOffset = cellSize / 6;
		cellVerticalOffset = cellSize * 0.426f;
		circleRadius = cellSize / 3;
		rectSize = cellSize * 0.6f;
	}
}