package com.example.wavedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class BingPic2 extends View{
	private Paint paint;
	private int height;//控件的高度
	private int width;//空间的宽度
	private int w;
	private int h;
	private TextPaint textpaint;//绘制文字的画笔
	private int radius;//饼图的半径
	private RectF rectf1;

	public BingPic2(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public BingPic2(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public BingPic2(Context context) {
		super(context);
		init();
	}

	private void init() {
		paint=new Paint(Paint.ANTI_ALIAS_FLAG|Paint.DITHER_FLAG);
		paint.setAntiAlias(true);
		textpaint=new TextPaint(Paint.ANTI_ALIAS_FLAG|Paint.DITHER_FLAG);
		textpaint.setAntiAlias(true);
		textpaint.setColor(Color.parseColor("#123435"));
		textpaint.setTextSize(20);
		
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(heightMeasureSpec, heightMeasureSpec);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		this.w=w;
		this.h=h;
		height=h-100;
		width=w-100;
		radius=(width-200)/2+50;
		rectf1=new RectF(100, 100, width, height);
		
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		paint.setColor(Color.parseColor("#4476b6"));
		canvas.drawArc(rectf1, 0, 30, true, paint);
		canvas.save();
		canvas.translate(w/2, h/2);
		canvas.rotate(15);
		canvas.drawText("1000", radius, 0, textpaint);
		canvas.restore();
		paint.setColor(Color.parseColor("#b94542"));
		canvas.drawArc(rectf1, 31, 140, true, paint);
		canvas.save();
		canvas.translate(w/2, h/2);
		canvas.rotate(30+140/2);
		canvas.drawText("1000", radius, 0, textpaint);
		canvas.restore();
		paint.setColor(Color.parseColor("#92b44e"));
		canvas.drawArc(rectf1, 172, 70, true, paint);
		canvas.save();
		canvas.translate(w/2, h/2);
		canvas.rotate(172+70/2);
		canvas.drawText("1000", radius, 0, textpaint);
		canvas.restore();
		paint.setColor(Color.parseColor("#755999"));
		canvas.drawArc(rectf1, 243, 116, true, paint);
		canvas.save();
		canvas.translate(w/2, h/2);
		canvas.rotate(243+116/2);
		canvas.drawText("1000", radius, 0, textpaint);
		canvas.restore();
	}
	

}
