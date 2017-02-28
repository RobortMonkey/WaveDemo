package com.example.wavedemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.Toast;

public class CopyOfMainActivityw extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_mainw);  
        // 这里你可以进行一些等待时的操作，我这里用8秒后显示Toast代理等待操作  
        new Handler().postDelayed(new Runnable(){  
            @Override  
            public void run(){  
                  
                CopyOfMainActivityw.this.finish();  
                Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();  
            }  
        }, 8000);  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
