package com.example.wavedemo;

import java.util.List;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class TranslateView extends View {

	private List<Integer> images;
	private int direction;
	private int index;
	private float width;
	private float height;
	private Rect leftRect;
	private Rect rightRect;
	private Rect centerRect;

	public TranslateView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public TranslateView(Context context, AttributeSet attrs) {
		this(context, attrs, -1);
	}

	public TranslateView(Context context) {
		this(context, null);
	}

	private void init() {
		leftRect = new Rect((int) -width, 0, 0, (int) height);
		rightRect = new Rect(0, (int) height, (int) width, (int) height);
		centerRect = new Rect((int) width, (int) height, (int) (2 * width),
				(int) height);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		width = w;
		height = h;
	}

	private boolean flag = true;
	private int translate;

	@Override
	protected void onDraw(Canvas canvas) {
		if (direction == 1)// 向左平移
		{
			if (flag) {
				canvas.drawBitmap(
						BitmapFactory.decodeResource(getResources(),
								images.get(index % images.size())), null,
						rightRect, null);
				canvas.drawBitmap(
						BitmapFactory.decodeResource(getResources(),
								images.get(index % images.size())), null,
						centerRect, null);
				flag=false;
			} else {
				canvas.translate(2, 0);
				translate+=2;
				if(translate>=width)
				{
					
				}

			}
		} else if (direction == 2) {

		}
		super.onDraw(canvas);
	}

	public void setResources(List<Integer> lists, int direction) {
		this.images = lists;
		this.direction = direction;
		init();
	}

}
