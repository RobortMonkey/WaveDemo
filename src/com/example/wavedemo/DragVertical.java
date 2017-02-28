package com.example.wavedemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 
 * @author huozhenpeng
 * 
 */
public class DragVertical extends RelativeLayout {
	private int totalHeight;// 控件总高度
	private int surplusHeight;// 控件预留高度
	private float rangeHeight;// 变换范围
	private float fraction;// 缩放因子
	private int currenttop;// 控件目前的高度
	private RelativeLayout rl_move;
	private ListView listview;

	private ViewDragHelper viewDragHelper;

	public DragVertical(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		TypedArray types = context.obtainStyledAttributes(attrs,
				R.styleable.dragVertical);
		final int count = types.getIndexCount();
		for (int i = 0; i < count; ++i) {
			int attr = types.getIndex(i);
			switch (attr) {
			case R.styleable.dragVertical_surplusHeight:
				surplusHeight = (int) types.getDimension(attr, 100);
				break;
			case R.styleable.dragVertical_totalHeight:
				totalHeight = (int) types.getDimension(attr, 500);
				break;
			}
		}
		types.recycle();
		rangeHeight = totalHeight - surplusHeight;
		init();
	}

	public DragVertical(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public DragVertical(Context context) {
		this(context, null);
	}

	public void init() {

		if (viewDragHelper == null) {
			viewDragHelper = ViewDragHelper.create(this, 1.0f,
					new ViewDragHelper.Callback() {

						@Override
						public boolean tryCaptureView(View arg0, int arg1) {
							return true;
						}

						@SuppressLint("NewApi")
						@Override
						public int clampViewPositionVertical(View child,
								int top, int dy) {
							if (top <= -rangeHeight) {
								top = (int) -rangeHeight;
							} else if (top > 0) {
								top = 0;
							}
							// if (imageview != null) {
							// // 头像缩放，避免缩放太小，设置缩放因子（拖动范围在rangeHeight内范围从1到0.7）
							// fraction=(top+rangeHeight)/rangeHeight*0.3f+0.7f;
							// imageview.setScaleX(fraction);
							// imageview.setScaleY(fraction);
							// }
							// if (textview != null) {
							// //设置透明度渐变，渐变因子（拖动范围在rangeHeight/3内范围从1.0到0）
							// fraction=(top+rangeHeight/3)/(rangeHeight/3);
							// textview.setAlpha(fraction);
							// //设置透明度渐变，渐变因子（拖动范围在rangeHeight/2内范围从1.0到0）
							// fraction=(top+rangeHeight/2)/(rangeHeight/2);
							// ll_linear.setAlpha(fraction);
							// }
							currenttop = top;
							return top;
						}

						@Override
						public void onViewPositionChanged(View changedView,
								int left, int top, int dx, int dy) {
							super.onViewPositionChanged(changedView, left, top,
									dx, dy);
						}

						@Override
						public int getViewVerticalDragRange(View child) {
							return (int) rangeHeight;
						}

					});
		}
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if (viewDragHelper != null && currenttop > -rangeHeight) {
			return viewDragHelper.shouldInterceptTouchEvent(ev);
		}
		return super.onInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (viewDragHelper != null) {
			if (currenttop > -rangeHeight) {
				viewDragHelper.processTouchEvent(event);
			}
			else
			{
				Log.e("abc", "mmmmmmmmmmmmmmmmmmmmmm");
				listview.onTouchEvent(event);
			}
			return true;
		}
		return super.onTouchEvent(event);
	}

	@Override
	protected void onFinishInflate() {
		rl_move = (RelativeLayout) findViewById(R.id.rl_move);
		listview = (ListView) findViewById(R.id.listview);
		super.onFinishInflate();
	}

}
