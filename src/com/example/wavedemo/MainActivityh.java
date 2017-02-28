package com.example.wavedemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class MainActivityh extends Activity {

	private DragGridView  draggridview;
	private int w_screen;
	private List<DragGridViewBean> lists;
	private GridViewAdapter adapter;
	private Random random;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_maini);
		draggridview=(DragGridView) this.findViewById(R.id.draggridview);
		DisplayMetrics dm =getResources().getDisplayMetrics();  
        w_screen = dm.widthPixels;  
		draggridview.setColumnWidth(w_screen/3);
		lists=new ArrayList<DragGridViewBean>();
		random=new Random();
		for(int i=0;i<16;i++)
		{
			lists.add(new DragGridViewBean("item"+i,random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		}
		adapter=new GridViewAdapter(this, lists,w_screen/3);
		draggridview.setAdapter(adapter);
		
			
		
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