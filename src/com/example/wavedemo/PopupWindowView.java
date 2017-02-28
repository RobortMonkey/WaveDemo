package com.example.wavedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class PopupWindowView extends View {
	private TextPaint paint;
	private Rect rect;
	private RectF rectf;
	private int leftPadding;
	private int topPadding;
	private FontMetrics metrics;
	private int baseline;
	private String text;
	private int radius;

	public PopupWindowView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	public PopupWindowView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}

	public PopupWindowView(Context context) {
		this(context,null);
	}
	private void init() {
		paint=new TextPaint(Paint.ANTI_ALIAS_FLAG|Paint.DITHER_FLAG);
		rect=new Rect();
		rectf=new RectF();
		leftPadding=(int) getContext().getResources().getDimension(R.dimen.px2dp_10);
		topPadding=(int) getContext().getResources().getDimension(R.dimen.px2dp_4);
		radius=(int) getContext().getResources().getDimension(R.dimen.px2dp_1);
		metrics=paint.getFontMetrics();
		baseline=(int) (-(metrics.ascent+metrics.descent)/2);
	}

	public void setText(String text)
	{
		this.text=text;
		paint.getTextBounds(text, 0, text.length(), rect);
		rectf.left=rect.left;
		rectf.right=rect.right;
		rectf.top=rect.top;
		rectf.bottom=rect.bottom;
		setMeasuredDimension(2*leftPadding+rect.right, 2*topPadding+rect.bottom);
		invalidate();
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		paint.setColor(Color.RED);
		canvas.drawRoundRect(rectf, radius, radius, paint);
		canvas.drawText(text, leftPadding, baseline, paint);
	}

}
