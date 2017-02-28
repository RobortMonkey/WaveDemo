package com.example.wavedemo;

import android.content.Context;
import android.widget.Toast;

/**
 * 
 * Toast替换
 * 
 * @author 王宇
 * 
 */
public class MToast {
	private static Toast mToast;

	public static void showToast(Context context, String text) {
		if (mToast == null) {
			mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		} else {
			mToast.setText(text);
			mToast.setDuration(Toast.LENGTH_SHORT);
		}
		mToast.show();
	}

	public static void cancelToast() {
		if (mToast != null) {
			mToast.cancel();
		}
	}

}
