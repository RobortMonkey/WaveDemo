package com.example.wavedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 
 * @author huozhenpeng
 * 
 */
public class IndicatorView2 extends View {

	private ViewPager viewPager;
	private int width;//控件宽度
	private int height;//控件高度
	private int radius;//小圆半径
	private float margin;
	private Paint paint;
	private int index;
	private int innerMargin;//两个小圆之间的间隔
	private Bitmap bitmap;
	private Canvas mCanvas;

	public IndicatorView2(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public IndicatorView2(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public IndicatorView2(Context context) {
		this(context, null);
	}

	public void setViewPager(ViewPager viewPager) {
		this.viewPager = viewPager;
		this.viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				
			}
			
			@Override
			public void onPageScrolled(int position, float positionOffset,//当前页面偏移的百分比
					int positionOffsetPixels) {//当前页面偏移的像素位置
				index=position;
				margin= positionOffset;
				invalidate();
			}
			
			@Override
			public void onPageScrollStateChanged(int state) {
				
			}
		});
	}

	private void init() {
		paint=new Paint(Paint.ANTI_ALIAS_FLAG|Paint.DITHER_FLAG);
		paint.setColor(Color.BLUE);
		radius=(int) getContext().getResources().getDimension(R.dimen.px2dp_40);
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		//根据项目实际要求，传过来的mode应该都是EXACTLY,不处理测量逻辑了
	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		width=w;
		height=h;
		innerMargin=w-4*radius;
		bitmap=Bitmap.createBitmap(2*radius, 2*radius, Config.ARGB_8888);
		paint.setColor(Color.RED);
		mCanvas=new Canvas();
		mCanvas.setBitmap(bitmap);
		mCanvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.point_red), 0, 0, paint);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		paint.setColor(Color.WHITE);
		paint.setXfermode(null);
		canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.point_blue), 0, 0, paint);
		canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.point_blue), width-radius, 0, paint);
//		mCanvas.drawCircle(radius+(innerMargin+2*radius)*(margin+index), height/2, radius, paint);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
		canvas.drawBitmap(bitmap, (innerMargin+2*radius)*(margin+index), 0, paint);
	}

}
