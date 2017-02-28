package com.example.wavedemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class ScrollItem extends LinearLayout{

	@SuppressLint("NewApi")
	public ScrollItem(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public ScrollItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public ScrollItem(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	private float oldX;
	private float oldY;
	private float currentX;
	private float currentY;
	private int delX;//差值
	private int delY;
	private boolean flag;
	private int oldDelX;
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			flag=false;
			oldX=event.getX();
			oldY=event.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			currentX=event.getX();
			currentY=event.getY();
			delX=(int)(oldX-currentX);
			delY=(int)(oldY-currentY);
			if(delX>=10||delX<=-10)
			{
				this.setPadding(-delX-oldDelX, 0, 0, 0);
//				Log.e("padding","delX:"+delX+"del"+(-delX-oldDelX));
				Log.e("padding", this.getMeasuredWidth()+"");
				this.requestLayout();
				this.invalidate();
				flag=true;
				oldDelX=delX;
			}
			return true;
		case MotionEvent.ACTION_UP:
			oldX=currentX;
			oldY=currentY;
//			if(delX>0)
//			{
//				oldDelX=delX;
//			}
//			else
//			{
//				oldDelX=-delX;
//			}
			break;

		default:
			break;
		}
		if(flag)
			return true;
		return super.onTouchEvent(event);
	}
	
	

}
