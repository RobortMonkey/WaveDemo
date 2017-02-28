package com.example.wavedemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Gallery;

@SuppressWarnings("deprecation")
public class MyGallery extends Gallery {

	public MyGallery(Context context) {
		this(context,null);
	}

	public MyGallery(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}

	public MyGallery(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
	}
	
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
 
    	return false;
    }
	
}
