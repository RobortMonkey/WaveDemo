package com.example.wavedemo;

import android.widget.ImageView;

/**
 * Created by ${huozhenpeng} on 15/9/23.
 * Company : www.miduo.com
 */
public class Item {
    private int imageView;
    private String  string;

    public Item(int imageView, String string) {
        this.imageView = imageView;
        this.string = string;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

}
