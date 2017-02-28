package com.example.wavedemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class MainActivityb extends Activity {

	private TextView textview1;
	private WaveTextView waveTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mainb);
		waveTextView=(WaveTextView) this.findViewById(R.id.waveTextView);
		waveTextView.setText(50);
		new Thread(waveTextView).start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}
	
	public void click(View view)
	{
	}

}