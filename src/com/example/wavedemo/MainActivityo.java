package com.example.wavedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivityo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maino);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
	

}
