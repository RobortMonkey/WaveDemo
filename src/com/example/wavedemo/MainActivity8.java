package com.example.wavedemo;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity8 extends Activity {
	private ListView listview;
	private RelativeLayout rl_top;
	private ArrayList<String> list = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main8);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, getData());
		listview = (ListView) findViewById(R.id.listview);
		rl_top = (RelativeLayout) findViewById(R.id.rl_top);
		final View textview = new View(this);
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
				LayoutParams.MATCH_PARENT, 1000);
		textview.setLayoutParams(lp);
		textview.setBackgroundColor(Color.parseColor("#00000000"));
		listview.addHeaderView(textview);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(MainActivity8.this, "点击", Toast.LENGTH_SHORT)
						.show();
			}
		});
		listview.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				// TODO Auto-generated method stub
				int delta = 1000 - textview.getBottom();
				Log.e("abc", "delta" + delta);
				if (delta < 400) {
					rl_top.layout(0, -delta, rl_top.getMeasuredWidth(),
							1000 - delta);
					
				}

			}
		});
		
//		getResources().getDimension(id);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}

	private ArrayList<String> getData() {
		list.add("180平米的房子");
		list.add("一个勤劳漂亮的老婆");
		list.add("一辆宝马");
		list.add("一个强壮且永不生病的身体");
		list.add("一个喜欢的事业");
		list.add("一辆宝马");
		list.add("一个强壮且永不生病的身体");
		list.add("一个喜欢的事业");
		list.add("一辆宝马");
		list.add("一个强壮且永不生病的身体");
		list.add("一个喜欢的事业");
		list.add("一辆宝马");
		list.add("一个强壮且永不生病的身体");
		list.add("一个喜欢的事业");
		list.add("180平米的房子");
		list.add("一个勤劳漂亮的老婆");
		list.add("一辆宝马");
		list.add("一个强壮且永不生病的身体");
		list.add("一个喜欢的事业");
		list.add("一辆宝马");
		list.add("一个强壮且永不生病的身体");
		list.add("一个喜欢的事业");
		list.add("一辆宝马");
		list.add("一个强壮且永不生病的身体");
		list.add("一个喜欢的事业");
		list.add("一辆宝马");
		list.add("一个强壮且永不生病的身体");
		list.add("一个喜欢的事业");

		return list;
	}
	
	public void click(View view)
	{
		Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
	}

}
