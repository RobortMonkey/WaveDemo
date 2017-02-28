package com.example.wavedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;

/**
 * 
 * @author huozhenpeng
 * 
 */
public class IndicatorView3 extends View {

	private ViewPager viewPager;
	private int width;// 控件宽度
	private int radius;// 小圆半径
	private float margin;
	private Paint paint;
	private Paint paint1;
	private Paint paint2;
	private int index;
	private int innerMargin;// 两个小圆之间的间隔
	private OvalShape circle1;
	private OvalShape circle2;
	private OvalShape circle3;
	private ShapeDrawable drawable3;
	private ShapeDrawable drawable;
	private ShapeDrawable drawable2;

	public IndicatorView3(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public IndicatorView3(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public IndicatorView3(Context context) {
		this(context, null);
	}

	public void setViewPager(ViewPager viewPager) {
		this.viewPager = viewPager;
		this.viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {

			}

			@Override
			public void onPageScrolled(int position, float positionOffset,// 当前页面偏移的百分比
					int positionOffsetPixels) {// 当前页面偏移的像素位置
				index = position;
				margin = positionOffset;
				invalidate();
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
	}

	private void init() {
		radius = (int) getContext().getResources().getDimension(
				R.dimen.px2dp_40);
		circle1 = new OvalShape();
		drawable = new ShapeDrawable(circle1);
		paint=drawable.getPaint();
		paint.setColor(Color.WHITE);
		drawable.getShape().resize(radius * 2, radius * 2);
		
		
		
		circle2 = new OvalShape();
		drawable2 = new ShapeDrawable(circle2);
		drawable2.getShape().resize(radius * 2, radius * 2);
		paint1=drawable2.getPaint();
		paint1.setColor(Color.WHITE);
		
		
		
		circle3 = new OvalShape();
		drawable3 = new ShapeDrawable(circle3);
		paint2=drawable3.getPaint();
		paint2.setColor(Color.RED);
		paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		drawable3.getShape().resize(radius * 2, radius * 2);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		// 根据项目实际要求，传过来的mode应该都是EXACTLY,不处理测量逻辑了
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		width = w;
		innerMargin = w - 4 * radius;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		int sc = canvas.saveLayer(0, 0, getWidth(), getHeight(), null,
                Canvas.MATRIX_SAVE_FLAG |
                        Canvas.CLIP_SAVE_FLAG |
                        Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                        Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                        Canvas.CLIP_TO_LAYER_SAVE_FLAG);
		drawable.draw(canvas);
		canvas.save();
		canvas.translate(width - 2 * radius, 0);
		drawable2.draw(canvas);
		canvas.restore();
		canvas.save();
		canvas.translate((innerMargin + 2 * radius) * (margin + index), 0);
		drawable3.draw(canvas);
		canvas.restore();
		 canvas.restoreToCount(sc);
	}

}
