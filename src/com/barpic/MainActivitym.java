package com.barpic;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;

import com.example.wavedemo.R;

public class MainActivitym extends Activity {
	private BarPictrue barPicture;
	private BarBean barBean;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mainm);
		barPicture=(BarPictrue) this.findViewById(R.id.barPicture);
			
		barBean = new BarBean();
		barBean.setTotal(100);
		List<PerBarBean> lists = new ArrayList<PerBarBean>();
		lists.add(new PerBarBean(40, 60, "意外险"));
		lists.add(new PerBarBean(100, 50, "寿险"));
		lists.add(new PerBarBean(60, 40, "医疗险"));
		lists.add(new PerBarBean(70, 90, "重疾险"));
		barBean.setDatas(lists);
		new Thread(barPicture).start();
		barPicture.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() {
				barPicture.setDatas(barBean);
				
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