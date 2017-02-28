package com.example.wavedemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class MainActivitym extends Activity {

	private ViewPager viewpager;
	private List<View> viewList;
	private IndicatorView3 indicatorview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainn);
		viewpager=(ViewPager) this.findViewById(R.id.viewpager);
		indicatorview=(IndicatorView3) this.findViewById(R.id.indicatorview);
		initData();
		viewpager.setAdapter(pagerAdapter);
		indicatorview.setViewPager(viewpager);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
	
	private void initData(){
        viewList = new ArrayList<View>();
        Random random = new Random();
        for(int i=0;i<2;i++){
            View view = new View(this);
            view.setBackgroundColor(0xff000000| random.nextInt(0x00ffffff));
            viewList.add(view);
        }
    }
	
	PagerAdapter pagerAdapter = new PagerAdapter() {

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {

            return arg0 == arg1;
        }

        @Override
        public int getCount() {

            return viewList.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object) {
            container.removeView(viewList.get(position));

        }

        @Override
        public int getItemPosition(Object object) {

            return super.getItemPosition(object);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return "title";
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));

            return viewList.get(position);
        }

    };

}
