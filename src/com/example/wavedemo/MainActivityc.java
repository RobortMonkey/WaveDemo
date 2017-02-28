package com.example.wavedemo;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.ListView;

public class MainActivityc extends Activity {

	private ListView listview;
	private MyAdapter1 adapter;
	private List<WaveBean> lists;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mainc);
		View view=new View(this);
		view.setBackgroundColor(Color.parseColor("#abcdef"));
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
				LayoutParams.MATCH_PARENT, 200);
		view.setLayoutParams(lp);
		listview=(ListView) this.findViewById(R.id.listview);
		AbsListView.LayoutParams params=new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT, 500);
		View headerView=new View(this);
		headerView.setBackgroundColor(Color.parseColor("#abcdef"));
		headerView.setLayoutParams(params);
		listview.addHeaderView(headerView);
//		listview.addHeaderView(view);
		lists=new ArrayList<WaveBean>();
		lists.add(new WaveBean("aaaaaaaaaaaa",90));
		lists.add(new WaveBean("bbbbbbbbbbbbb",80));
		lists.add(new WaveBean("ccccccccccc",70));
		lists.add(new WaveBean("dddddddddddddd",10));
		lists.add(new WaveBean("eeeeeeeeeeee",20));
		lists.add(new WaveBean("fffffffff",30));
		lists.add(new WaveBean("hhhhhhhhhh",40));
		lists.add(new WaveBean("iiiiiiiii",60));
		lists.add(new WaveBean("ggggggggggg",13));
		lists.add(new WaveBean("kkkkkkkkkkk",15));
		lists.add(new WaveBean("llllllllllll",24));
		lists.add(new WaveBean("mmmmmmmmmmm",27));
//		lists.add(new WaveBean("nnnnnnnnnnnnnn",56));
//		lists.add(new WaveBean("ooooooooooo",78));
//		lists.add(new WaveBean("ppppppppppp",98));
//		lists.add(new WaveBean("qqqqqqqqqqq",100));
//		lists.add(new WaveBean("rrrrrrrrrrrr",0));
//		lists.add(new WaveBean("ssssssssssssss",54));
//		lists.add(new WaveBean("tttttttttttt",87));
//		lists.add(new WaveBean("uuuuuuuuuuuu",54));
//		lists.add(new WaveBean("vvvvvvvvvvvvv",3));
//		lists.add(new WaveBean("wwwwwwwwwwwwww",67));
//		lists.add(new WaveBean("xxxxxxxxxxxxxx",97));
//		lists.add(new WaveBean("yyyyyyyyyyyyyyyy",4));
//		lists.add(new WaveBean("zzzzzzzzzzzzzzz",50));
		adapter=new MyAdapter1(lists, this);
		listview.setAdapter(adapter);
		listview.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() {
				Log.e("abc", "height"+listview.getChildCount());
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
//		Log.e("abc", "click");
		listview.smoothScrollBy(200, 500);
//		listview.smoothScrollByOffset(2);
//		listview.smoothScrollToPosition(9);//移动到第9个可见
//		Log.e("abc", "height"+listview.getMeasuredHeight());
		Log.e("abc", "height"+listview.getChildCount());//返回在viewgroup中的View个数
	}

}