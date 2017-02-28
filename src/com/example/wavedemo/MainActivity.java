package com.example.wavedemo;

import java.util.ArrayList;
import java.util.List;

import com.example.wavedemo.MyAdapter.ViewHolder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends Activity {

	private Gallery gallery;
	private List<Item> list;
	private MyAdapter adapter;
	private View temp_view;
	private View currentView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gallery = (Gallery) this.findViewById(R.id.g_gallery);
		list = new ArrayList<Item>();
		for (int i = 0; i < 4; i++) {
			list.add(new Item(R.drawable.gdsy_icon1, "米多热销"));
			list.add(new Item(R.drawable.gldx_icon1, "浮动收益"));
			list.add(new Item(R.drawable.hand_icon, "高流动性"));
			list.add(new Item(R.drawable.gdsy_icon1, "固定收益"));
		}
		adapter = new MyAdapter(list, this);
		gallery.setAdapter(adapter);
		gallery.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(MainActivity.this,
						list.get(position % list.size()).getString(),
						Toast.LENGTH_SHORT).show();
				ViewHolder holder=(ViewHolder) view.getTag();
				if(currentView!=null&&currentView!=view)
				{
					((ViewHolder) currentView.getTag()).iv_left1.setVisibility(View.VISIBLE);
					((ViewHolder) currentView.getTag()).iv_left2.setVisibility(View.VISIBLE);
				}
				currentView = view;
				holder.iv_left1.setVisibility(View.INVISIBLE);
				holder.iv_left2.setVisibility(View.INVISIBLE);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}

		});
		
//		gallery.setOnTouchListener(new OnTouchListener() {
//			
//			@SuppressLint("NewApi")
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				switch (event.getAction()) {
//				case MotionEvent.ACTION_DOWN:
//					temp_view=currentView;
//					break;
//				case MotionEvent.ACTION_MOVE:
//					temp_view.findViewById(R.id.right).setTranslationX(-temp_view.getLeft());
//					Log.e("abc", ""+temp_view.getLeft());
//					break;
//				case MotionEvent.ACTION_UP:
//					break;
//
//				default:
//					break;
//				}
//				return false;
//				
//			}
//		});
		gallery.setSelection(list.size() * 10);
		

	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
