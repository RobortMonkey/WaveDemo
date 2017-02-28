package com.example.wavedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class LineWidthDemo extends View {

	private Paint paint;
	public LineWidthDemo(Context context) {
		this(context,null);
	}

	public LineWidthDemo(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}

	public LineWidthDemo(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
		
	}
	private void init()
	{
		paint=new Paint(Paint.ANTI_ALIAS_FLAG|Paint.DITHER_FLAG);
		paint.setStrokeWidth(100);
		paint.setColor(Color.parseColor("#2da8df"));
	}
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawLine(500, 500, 500, 510, paint);
		super.onDraw(canvas);
	}

}
