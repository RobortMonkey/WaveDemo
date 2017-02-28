package com.example.wavedemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

public class WelcomeActivity extends Activity {
	// 首次使用程序的显示的欢迎图片
	private ArrayList<View> guides = new ArrayList<View>();
	private ViewPager pager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViews();
		initEvents();
	}

	protected void initViews() {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏 
		setContentView(R.layout.activity_welcome);
		LayoutInflater inflater = getLayoutInflater();
		guides = new ArrayList<View>();
		guides.add(inflater.inflate(R.layout.item01, null));
		guides.add(inflater.inflate(R.layout.item02, null));
		guides.add(inflater.inflate(R.layout.item03, null));
		guides.add(inflater.inflate(R.layout.activity_login, null));

		WecommPagerAdapter adapter = new WecommPagerAdapter(guides);
		pager = (ViewPager) findViewById(R.id.showwelom_page);
		pager.setAdapter(adapter);
		pager.setPageTransformer(true, new ParallaxTransformer(this));
	}

	protected void initEvents() {
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			public void onPageSelected(int arg0) {
				if (arg0 == 3) {// 到最后一张了
					Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
					startActivity(intent);
					WelcomeActivity.this.finish();
				}
			}

			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			public void onPageScrollStateChanged(int arg0) {
			}

		});
	}


	public class WecommPagerAdapter extends PagerAdapter {

		private List<View> views;

		public WecommPagerAdapter(List<View> views) {
			this.views = views;
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(views.get(arg1));
		}

		@Override
		public void finishUpdate(View arg0) {
		}

		@Override
		public int getCount() {
			return views.size();
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(views.get(arg1), 0);
			return views.get(arg1);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == (arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {

		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {

		}

	}

}
