package com.example.wavedemo;

import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter {

	private Context context;
	private List<DragGridViewBean> lists;
	private DragGridViewBean bean;
	private int width;
	private int hidePosition = AdapterView.INVALID_POSITION;
	

	public GridViewAdapter(Context context, List<DragGridViewBean> lists, int width) {
		this.context = context;
		this.lists = lists;
		this.width = width;
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
		bean=lists.get(position);
		AbsListView.LayoutParams params = new AbsListView.LayoutParams(width,
				width);
		TextView textview = new TextView(context);
		textview.setLayoutParams(params);
		textview.setBackgroundColor(Color.rgb(bean.getRed(), bean.getGreen(), bean.getBlue()));
		textview.setGravity(Gravity.CENTER);
		textview.setText(lists.get(position).getString());
		return textview;
	}

	// 更新拖动时的gridView
	public void swapView(int draggedPos, int destPos) {
		// 从前向后拖动，其他item依次前移
		if (draggedPos < destPos) {
			lists.add(destPos + 1, (DragGridViewBean) getItem(draggedPos));
			lists.remove(draggedPos);
		}
		// 从后向前拖动，其他item依次后移
		else if (draggedPos >= destPos) {
			lists.add(destPos, (DragGridViewBean) getItem(draggedPos));
			lists.remove(draggedPos + 1);
		}
		hidePosition = destPos;
		notifyDataSetChanged();
	}

	public void hideView(int pos) {
		hidePosition = pos;
		notifyDataSetChanged();
	}

	public void showHideView() {
		hidePosition = AdapterView.INVALID_POSITION;
		notifyDataSetChanged();
	}

}
