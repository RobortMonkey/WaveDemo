package com.example.wavedemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ${huozhenpeng} on 15/9/23.
 * Company : www.miduo.com
 */
public class MyViewpagerAdapter extends PagerAdapter {

    private List<Item>  list=new ArrayList<Item>();
    private Context context;


    public MyViewpagerAdapter(List<Item> list,Context context) {
        this.context=context;
        this.list = list;
    }


	@Override
	public int getCount() {
		return list.size();
	}


	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view==object;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		return super.instantiateItem(container, position);
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		super.destroyItem(container, position, object);
	}

}
