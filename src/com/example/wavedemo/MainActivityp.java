package com.example.wavedemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivityp extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maino);
		String path = getFilesDir().getAbsolutePath() ;
		Log.e("abc", path);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
	

}
