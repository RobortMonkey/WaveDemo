package com.example.wavedemo;

import java.util.ArrayList;

import com.example.wavedemo.ScrollBarPic.OnClickListener;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;

public class MainActivityf extends Activity {

	private ScrollBarPic scrollBarPic ;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mainh);
		scrollBarPic=(ScrollBarPic) this.findViewById(R.id.scrollBarPic);
		final ScrollBarBean scrollBarBean=new ScrollBarBean();
		scrollBarBean.setTotal(100);
		ArrayList<ScrollPerBarBean> lists=new ArrayList<ScrollPerBarBean>();
//		for(int i=0;i<30;i++)
//		{
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",70,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",80,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",10,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",20,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",30,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",90,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",80,"08-11"));
			
			lists.add(new ScrollPerBarBean("￥3,000.00",56,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",55,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",50,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",100,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",10,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",90,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",80,"08-11"));
			lists.add(new ScrollPerBarBean("￥3,000.00",0,"08-11"));
//		}
		scrollBarBean.setLists(lists);
		scrollBarPic.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() {
				scrollBarPic.setDatas(scrollBarBean);
			}
		});
		scrollBarPic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onclick(int i) {
				Log.e("abc", "-------------------"+i);
			}
		});
			
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}
	
	@SuppressLint("NewApi")
	public void click(View view)
	{
	}

}