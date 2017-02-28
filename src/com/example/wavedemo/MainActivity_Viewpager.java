package com.example.wavedemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.Toast;

import com.example.wavedemo.MyAdapter.ViewHolder;

@SuppressWarnings("deprecation")
public class MainActivity_Viewpager extends Activity {

	private ViewPager viewpager;
	private List<Item> list;
	private MyAdapter adapter;
	private View temp_view;
	private View currentView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewpager);
		viewpager = (ViewPager) this.findViewById(R.id.v_viewpager);
		list = new ArrayList<Item>();
		for (int i = 0; i < 4; i++) {
			list.add(new Item(R.drawable.gdsy_icon1, "米多热销"));
			list.add(new Item(R.drawable.gldx_icon1, "浮动收益"));
			list.add(new Item(R.drawable.hand_icon, "高流动性"));
			list.add(new Item(R.drawable.gdsy_icon1, "固定收益"));
		}
		adapter = new MyAdapter(list, this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	

}
