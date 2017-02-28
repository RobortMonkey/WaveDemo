package com.example.wavedemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;

public class FenBianlvActivity extends Activity{

	private TextView textview1;
	private DisplayMetrics dm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);  
        
        // 获取布局中TextView  
        textview1 = (TextView)findViewById(R.id.hello);  
  
        // 方法1 Android获得屏幕的宽和高   
        int screenWidth;   
        int screenHeight;   
  
        WindowManager windowManager = getWindowManager();   
        Display display = windowManager.getDefaultDisplay();   
        screenWidth = display.getWidth();   
        screenHeight = display.getHeight();   
  
        Log.d("abc", "screenWidth:" + screenWidth);  
        Log.d("abc", "screenHeight:" + screenHeight);  
          
        // 方法2  
        dm = new DisplayMetrics();  
        getWindowManager().getDefaultDisplay().getMetrics(dm);  
  
        //获得手机的宽带和高度像素单位为px  
        String str = "方法1 手机屏幕分辨率为:" + screenWidth  
            +" * "+ screenHeight +  
            "/n方法2  手机屏幕分辨率为:" + dm.widthPixels  
            +" * "+ dm.heightPixels;  
        textview1.setText(str);  
	}
}
