package com.example.wavedemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends Activity {
	private List<RotateBean> lists;
	private RotationView rotationView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main6);
		rotationView=(RotationView) this.findViewById(R.id.rotateView);
		lists=new ArrayList<RotateBean>();
		lists.add(new RotateBean("+0.75", 20,"#7eb445"));
		lists.add(new RotateBean("+0.35", 160,"#819d87"));
		lists.add(new RotateBean("+0.25", 20,"#e61a5f"));
		lists.add(new RotateBean("+0.25", 160,"#000000"));
		rotationView.setData(lists);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}

}
