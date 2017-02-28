package com.example.wavedemo;

import java.util.ArrayList;
import java.util.List;

import com.example.wavedemo.BarPic.OnClickListener;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3 extends Activity implements android.view.View.OnClickListener{
	
	private BarPic barPic;
	private List<BarBean> lists;
	private Button b_add;
	private Button b_less;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);
		barPic=(BarPic) findViewById(R.id.barpic);
		lists=new ArrayList<BarBean>();
		lists.add(new BarBean("高流动性","5%",100,5));
		lists.add(new BarBean("固定收益","1%",100,1));
		lists.add(new BarBean("浮动收益","50%",100,50));
		lists.add(new BarBean("另类投资","100%",100,100));
		barPic.setData(lists);
		new Thread(barPic).start();
		barPic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onclick(int i) {
				Toast.makeText(MainActivity3.this, lists.get(i).getDescription()+(lists.get(i).isFlag()?"选中":"取消选中"), Toast.LENGTH_SHORT).show();
			}
		});
		b_add=(Button) this.findViewById(R.id.b_add);
		b_less=(Button) this.findViewById(R.id.b_less);
		b_add.setOnClickListener(this);
		b_less.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b_add:
			
			break;
		case R.id.b_less:
			for(int i=0;i<lists.size();i++)
			{
				BarBean barbean=lists.get(i);
				barbean.setActualHeight(barbean.getActualHeight()-10<0?0:barbean.getActualHeight());
			}
			barPic.setData(lists);
			break;

		default:
			break;
		}
	}
	
	

}
