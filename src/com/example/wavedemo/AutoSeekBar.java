package com.example.wavedemo;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class AutoSeekBar extends FrameLayout {
	private ViewDragHelper helper;

	public AutoSeekBar(Context context) {
		this(context,null);
	}

	public AutoSeekBar(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}

	public AutoSeekBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	
	public void init()
	{
	}

}
