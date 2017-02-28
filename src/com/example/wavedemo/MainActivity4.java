package com.example.wavedemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity4 extends Activity {
	private ListView listview;
	private ArrayList<String> list = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main1);
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(
	                this,
	                android.R.layout.simple_expandable_list_item_1,
	                getData());
		listview=(ListView) findViewById(R.id.listview);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity4.this, "点击", Toast.LENGTH_SHORT).show();
			}
		});

	}
	private ArrayList<String> getData()
    {
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


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}

	public void click(View view) {
		Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
	}

}
