package com.example.wavedemo;

import java.io.Serializable;

public class BarBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String description;// 描述字体
	private String data;// 柱状图上面的数据
	private int totalHeight;// 控件height所对应的data
	private int actualHeight;// 柱状图height所对应的data
	private int height;//柱状图实际height
	private boolean flag;//记录是不是点击状态
	private int leftX,rightX,topY;//记录左右上边距

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getTotalHeight() {
		return totalHeight;
	}

	public void setTotalHeight(int totalHeight) {
		this.totalHeight = totalHeight;
	}

	public int getActualHeight() {
		return actualHeight;
	}

	public void setActualHeight(int actualHeight) {
		this.actualHeight = actualHeight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	


	public int getLeftX() {
		return leftX;
	}

	public void setLeftX(int leftX) {
		this.leftX = leftX;
	}

	public int getRightX() {
		return rightX;
	}

	public void setRightX(int rightX) {
		this.rightX = rightX;
	}

	public int getTopY() {
		return topY;
	}

	public void setTopY(int topY) {
		this.topY = topY;
	}


	@Override
	public String toString() {
		return "BarBean [description=" + description + ", data=" + data
				+ ", totalHeight=" + totalHeight + ", actualHeight="
				+ actualHeight + ", height=" + height + ", flag=" + flag
				+ ", leftX=" + leftX + ", rightX=" + rightX + ", topY=" + topY
				+ "]";
	}

	public BarBean(String description, String data, int totalHeight,
			int actualHeight) {
		super();
		this.description = description;
		this.data = data;
		this.totalHeight = totalHeight;
		this.actualHeight = actualHeight;
	}
	
	
	

}
