package com.example.wavedemo;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdaptera extends BaseAdapter {

	private Context context;
	private List<Integer> lists;

	public ListAdaptera(Context context, List<Integer> lists) {
		this.context = context;
		this.lists = lists;
	}

	@Override
	public int getCount() {
		return lists.size();
	}

	@Override
	public Object getItem(int position) {
		return lists.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(position==0||position%10==0)
		{
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_list, null);
			((TextView)convertView.findViewById(R.id.tv_left)).setText(lists.get(position)+"万");
			((TextView)convertView.findViewById(R.id.tv_right)).setText(lists.get(position)+"万");
			
		}
		else if(position%5==0)
		{
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_list3, null);
		}
		else
		{
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_list2, null);
		}
		return convertView;
	}

	

}
