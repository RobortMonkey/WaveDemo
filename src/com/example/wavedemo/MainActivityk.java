package com.example.wavedemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivityk extends Activity {

	private ProTopView protopview;
	private SeekBar seekbar;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_maink);
//		protopview=(ProTopView) this.findViewById(R.id.protopview);
		seekbar=(SeekBar) this.findViewById(R.id.seekbar);
		protopview.setProductSelectChangeListener(new ProductSelectChangeListener() {
			
			@Override
			public void onIndexChange(int index) {
				MToast.showToast(MainActivityk.this, "index"+index);
			}
		});
		seekbar.setMax(100);
		seekbar.setProgress(50);
		seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				
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