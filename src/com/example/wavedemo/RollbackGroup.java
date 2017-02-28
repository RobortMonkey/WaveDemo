package com.example.wavedemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class RollbackGroup extends LinearLayout {

	private ViewDragHelper viewDragHelper;
	private float sensitivity = 1.0f;
	private int width;
	private int height;
	private int childCount;
	private int perChildHeight;
	private int range;// 拖动的最大范围
	private int deltaTop;
	private MyScrollChangedListener listener;// 为了控制RotaationView
	private MyRollbackListener rollbackListener;// 为了回滚RotationView
	private boolean isRollback;// 定义标记是否回滚

	@SuppressLint("NewApi")
	public RollbackGroup(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public RollbackGroup(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RollbackGroup(Context context) {
		this(context, null);
	}

	public void init() {
		setOrientation(LinearLayout.VERTICAL);
		if (viewDragHelper == null) {
			viewDragHelper = ViewDragHelper.create(this, sensitivity,
					new ViewDragHelper.Callback() {

						@Override
						public boolean tryCaptureView(View arg0, int arg1) {
							return true;
						}

						@Override
						public int clampViewPositionHorizontal(View child,
								int left, int dx) {
							return super.clampViewPositionHorizontal(child,
									left, dx);
						}

						int num = 0;

						@Override
						public int clampViewPositionVertical(View child,
								int top, int dy) {
							isRollback = false;
							int oldtop = top;
							if (top > 0) {
								top = 0;
							} else if (top < -range) {
								top = -range;
							}
							if (listener != null) {

								if (-oldtop < range && oldtop < 0) {// 滑到只剩一条，不让滑动了
									listener.onScroll(-dy, -top, perChildHeight);
									isRollback = true;
									num += -dy;

								}
							}
							deltaTop = top;
							return top;
						}

						@Override
						public void onViewReleased(View releasedChild,
								float xvel, float yvel) {
							super.onViewReleased(releasedChild, xvel, yvel);
							// 向最近的View回滚
							int currentIndex = 0;
							int finalTop = 0;

							if (-deltaTop % perChildHeight != 0) {

								currentIndex = -deltaTop / perChildHeight;
								if (-deltaTop % perChildHeight < perChildHeight / 2) {
									finalTop = -currentIndex * perChildHeight;
								} else {
									finalTop = -(currentIndex + 1)
											* perChildHeight;
								}
								// 回滚RotationView
								if (rollbackListener != null && isRollback) {
									rollbackListener.onRollback(deltaTop
											- finalTop, deltaTop,
											perChildHeight);
								}
								if (viewDragHelper.smoothSlideViewTo(
										getChildAt(0), 0, finalTop)) {
									// 返回true， 说明还没有移动到指定位置。需要重绘界面
									ViewCompat
											.postInvalidateOnAnimation(RollbackGroup.this);
								}

							}

						}

					});
		}
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		width = w;
		height = h;
		childCount = ((ViewGroup) getChildAt(0)).getChildCount();
		if (childCount >= 1) {
			perChildHeight = (int) (height * 1.0f / childCount);
			range = (height - perChildHeight);
		}

	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if (viewDragHelper != null) {
			return viewDragHelper.shouldInterceptTouchEvent(ev);
		}
		return super.onInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (viewDragHelper != null) {
			viewDragHelper.processTouchEvent(event);
			return true;
		}
		return super.onTouchEvent(event);
	}

	@Override
	public void computeScroll() {
		super.computeScroll();
		// 2. 维持动画的继续
		if (viewDragHelper.continueSettling(true)) {
			// 返回true， 说明还没有移动到指定位置。需要重绘界面
			ViewCompat.postInvalidateOnAnimation(this);
		}
		else
		{
			// 为了确保无误差,如果RotationView不在指定位置，再次滚动
			
		}
	}

	/**
	 * 为了与RotationView联动
	 * 
	 * @author huozhenpeng
	 * 
	 */
	interface MyScrollChangedListener {
		void onScroll(int delta, int top, int perChildHeight);
	}

	public void setMyScrollChangedListener(MyScrollChangedListener listener) {
		this.listener = listener;
	}

	/**
	 * 为了使RotationView回滚
	 * 
	 * @author huozhenpeng
	 * 
	 */
	interface MyRollbackListener {
		void onRollback(int degrees, int index, int perChildHeight);
	}

	public void setMyRollbackListener(MyRollbackListener rollListener) {
		this.rollbackListener = rollListener;
	}

}
