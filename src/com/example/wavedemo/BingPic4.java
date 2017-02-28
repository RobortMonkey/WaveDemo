package com.example.wavedemo;

import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
/**
 * 
 * @author huozhenpeng
 *
 */
public class BingPic4 extends View {
	private Paint paint;
	private int height;// 控件的高度
	private int width;// 空间的宽度
	private int w;
	private int h;
	private TextPaint textpaint;// 绘制文字的画笔
	private int radius;// 饼图的半径
	private RectF rectf1;
	private List<Integer> lists;// 存放四个角度
	private List<Integer>  datas;//存放描述数据
	public BingPic4(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public BingPic4(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public BingPic4(Context context) {
		super(context);
		init();
	}

	private void init() {
		paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		paint.setAntiAlias(true);
		textpaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
		textpaint.setAntiAlias(true);
		textpaint.setColor(Color.parseColor("#123435"));
		textpaint.setTextSize(20);
		textpaint.setTextAlign(Align.CENTER);
		invalidate();

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(heightMeasureSpec, heightMeasureSpec);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		this.w = w;
		this.h = h;
		height = h - 100;
		width = w - 100;
		radius = (w - 200) / 2 + 50;
		rectf1 = new RectF(100, 100, width, height);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		paint.setColor(Color.parseColor("#4476b6"));
		canvas.drawArc(rectf1, 0+1, lists.get(0)-1, true, paint);
		canvas.save();
		canvas.translate(w / 2, h / 2);
		canvas.drawText(datas.get(0)+"",
				(float) (radius * Math.cos(lists.get(0) / 2 * Math.PI / 180)),
				(float) (radius * Math.sin(lists.get(0) / 2 * Math.PI / 180)),
				textpaint);
		canvas.restore();
		paint.setColor(Color.parseColor("#b94542"));
		canvas.drawArc(rectf1, lists.get(0) + 1, lists.get(1)-1, true, paint);
		canvas.save();
		canvas.translate(w / 2, h / 2);
		canvas.drawText(
				datas.get(1)+"",
				(float) (radius * Math.cos((lists.get(0) + lists.get(1) / 2)
						* Math.PI / 180)),
				(float) (radius * Math.sin((lists.get(0) + lists.get(1) / 2)
						* Math.PI / 180)), textpaint);
		canvas.restore();
		paint.setColor(Color.parseColor("#92b44e"));
		canvas.drawArc(rectf1, lists.get(0) + lists.get(1) + 1, lists.get(2)-1,
				true, paint);
		canvas.save();
		canvas.translate(w / 2, h / 2);
		canvas.drawText(
				datas.get(2)+"",
				(float) (radius * Math.cos((lists.get(0) + lists.get(1) + lists
						.get(2) / 2) * Math.PI / 180)),
				(float) (radius * Math.sin((lists.get(0) + lists.get(1) + lists
						.get(2) / 2) * Math.PI / 180)), textpaint);
		canvas.restore();
		paint.setColor(Color.parseColor("#755999"));
		canvas.drawArc(rectf1, lists.get(0) + lists.get(1) + lists.get(2) + 1,
				lists.get(3)-1, true, paint);
		canvas.save();
		canvas.translate(w / 2, h / 2);
		canvas.drawText(
				datas.get(3)+"",
				(float) (radius * Math.cos((lists.get(0) + lists.get(1)
						+ lists.get(2) + lists.get(3) / 2)
						* Math.PI / 180)),
				(float) (radius * Math.sin((lists.get(0) + lists.get(1)
						+ lists.get(2) + lists.get(3) / 2)
						* Math.PI / 180)), textpaint);
		canvas.restore();

	}

	public void setData(List<Integer> lists,List<Integer> datas) {
		if (lists.size()!= 4) {
			throw new IllegalArgumentException("参数长度应为4"); 
		}
		this.lists = lists;
		this.datas=datas;
		init();
	}

}
