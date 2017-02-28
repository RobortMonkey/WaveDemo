package com.example.wavedemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;

public class MainActivityq extends Activity {

	private RingView ringview;
	private List<RingBean> lists;
	private int i=0;
	private ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainq);
		ringview=(RingView) this.findViewById(R.id.ringview);
		lists=new ArrayList<RingBean>();
		lists.add(new RingBean("354,90", "宝宝1", 70, "#e67817"));
		lists.add(new RingBean("355,90", "宝宝2", 100, "#dbb953"));
		lists.add(new RingBean("356,90", "宝宝3", 10, "#7fc76e"));
		lists.add(new RingBean("357,90", "宝宝4", 100, "#48b15f"));
		lists.add(new RingBean("357,90", "宝宝5", 80, "#df3f5b"));
		ringview.setDatas(lists);
		
		listview.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				
			}
		});
		listview.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
	
	public void click(View view)
	{
		for(int j=0;j<lists.size();j++)
		{
			lists.get(j).setFlag(false);
		}
		i=i%lists.size();
		lists.get(i).setFlag(true);
		i++;
		ringview.invalidate();
	}
	
	
	
	

}
