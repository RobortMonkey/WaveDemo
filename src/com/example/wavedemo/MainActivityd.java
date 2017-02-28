package com.example.wavedemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class MainActivityd extends Activity {

	private EditText et_text;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_maine);
		et_text=(EditText) this.findViewById(R.id.et_text);
		et_text.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				et_text.setText("aa");
//				Log.e("abc", "s"+s+"start"+start+"count"+count+"length"+s.length());
//				if(s.length()>20)
//				{
//					et_text.setText(s.subSequence(0,
//							s.length() - 1));
//					et_text.setSelection(20);
//					return;
//				}
//				if (count == 1) {
//					if (s.length() == 4) {
//						et_text.setText(s + " ");
//						et_text.setSelection(5);
//					}
//					if (s.length() == 9) {
//						et_text.setText(s + " ");
//						et_text.setSelection(10);
//					}
//					if (s.length() == 14) {
//						et_text.setText(s + " ");
//						et_text.setSelection(15);
//					}
//					if (s.length() == 19) {
//						et_text.setText(s + " ");
//						et_text.setSelection(20);
//					}
//				} else if (count == 0) {
//					if (s.length() == 4) {
//						et_text.setText(s.subSequence(0,
//								s.length() - 1));
//						et_text.setSelection(3);
//					}
//					if (s.length() == 9) {
//						et_text.setText(s.subSequence(0,
//								s.length() - 1));
//						et_text.setSelection(8);
//					}
//					if (s.length() == 14) {
//						et_text.setText(s.subSequence(0,
//								s.length() - 1));
//						et_text.setSelection(13);
//					}
//					if (s.length() == 19) {
//						et_text.setText(s.subSequence(0,
//								s.length() - 1));
//						et_text.setSelection(18);
//					}
//				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
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