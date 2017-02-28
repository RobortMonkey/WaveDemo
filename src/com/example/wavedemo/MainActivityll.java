package com.example.wavedemo;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnDrawListener;
import com.joanzapata.pdfview.listener.OnLoadCompleteListener;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Menu;

@SuppressWarnings("deprecation")
public class MainActivityll extends Activity {

	private PDFView pdfview;

	@SuppressLint("WrongCall")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainll);
		pdfview=(PDFView) this.findViewById(R.id.pdfview);
		pdfview.fromAsset("abc.pdf")//.load();
	    .pages(0, 2, 1, 3, 3, 3)
	    .defaultPage(1)
	    .showMinimap(false)
	    .enableSwipe(true)
	    .onDraw(new OnDrawListener() {
			
			@Override
			public void onLayerDrawn(Canvas arg0, float arg1, float arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}
		})
	    .onLoad(new OnLoadCompleteListener() {
			
			@Override
			public void loadComplete(int arg0) {
				// TODO Auto-generated method stub
				
			}
		})
	    .onPageChange(new OnPageChangeListener() {
			
			@Override
			public void onPageChanged(int arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
		})
	    .load();
 
		

	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
