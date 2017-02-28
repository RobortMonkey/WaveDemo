package com.example.wavedemo;

import android.content.Context;
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
public class MyAdapter extends BaseAdapter {

    private List<Item>  list=new ArrayList<Item>();
    private Context context;


    public MyAdapter(List<Item> list,Context context) {
        this.context=context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size()*100;
    }

    @Override
    public Object getItem(int position) {
        return position%list.size();
    }

    @Override
    public long getItemId(int position) {
        return position%list.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;

        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item,null);
            holder=new ViewHolder();
            holder.right= (ImageView) convertView.findViewById(R.id.right);
            holder.textView= (TextView) convertView.findViewById(R.id.textview);
            holder.iv_left1=(ImageView) convertView.findViewById(R.id.iv_left1);
            holder.iv_left2=(ImageView) convertView.findViewById(R.id.iv_left2);
            convertView.setTag(holder);
        }
        else
        {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(list.get(position%list.size()).getString());
        holder.right.setImageResource(list.get(position%list.size()).getImageView());
        return convertView;
    }

    class  ViewHolder
    {
        public TextView textView;
        public ImageView iv_left1,iv_left2;
        public ImageView right;
    }
}
