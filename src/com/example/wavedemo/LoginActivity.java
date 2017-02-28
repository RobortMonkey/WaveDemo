package com.example.wavedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class LoginActivity extends Activity implements OnClickListener {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViews();
	}

	protected void initViews() {
		setContentView(R.layout.activity_login);
		
	}

	@Override
	public void onClick(View v) {
		
	}

	

}
