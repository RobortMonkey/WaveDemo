package com.example.wavedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class LineView extends View {
	private Paint strockpaint;
	private Paint p;

	public LineView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public LineView(Context context, AttributeSet attrs) {
		this(context, attrs, -1);
	}

	public LineView(Context context) {
		this(context, null);
	}

	private void init() {
		strockpaint = new Paint();
		strockpaint.setAntiAlias(true);
		strockpaint.setStyle(Paint.Style.STROKE);
		strockpaint.setColor(Color.BLUE);
		DashPathEffect effects = new DashPathEffect(new float[] { 5, 5, 5,
				5 }, 1);
		strockpaint.setPathEffect(effects);
		p = new Paint(Paint.ANTI_ALIAS_FLAG);
		p.setStyle(Style.STROKE);
		p.setColor(Color.RED);
		p.setStrokeWidth(1);
		p.setTextSize(30);
		p.setStrokeWidth(10);
		DashPathEffect effects1 = new DashPathEffect(
				new float[] { 1, 4, 7, 8 }, 1);
		p.setPathEffect(effects1);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawLine(0, 0, 400, 400, strockpaint);
		canvas.drawCircle(0, 0, 400, strockpaint);
		canvas.drawLine(200, 140, 500, 40, p);
	}

}
