package com.example.wavedemo;

import java.io.Serializable;


public class RotateBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String showData;
	private int degrees;
	private boolean isSelected;
	private String color;// 十六进制颜色值
	private MyPoint point;//只是记录两个点（并非x和y）

	public String getShowData() {
		return showData;
	}

	public void setShowData(String showData) {
		this.showData = showData;
	}

	public int getDegrees() {
		return degrees;
	}

	public void setDegrees(int degrees) {
		this.degrees = degrees;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public RotateBean(String showData, int degrees) {
		super();
		this.showData = showData;
		this.degrees = degrees;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	

	public MyPoint getPoint() {
		return point;
	}

	public void setPoint(MyPoint point) {
		this.point = point;
	}


	@Override
	public String toString() {
		return "RotateBean [showData=" + showData + ", degrees=" + degrees
				+ ", isSelected=" + isSelected + ", color=" + color
				+ ", point=" + point + "]";
	}

	public RotateBean(String showData, int degrees, String color) {
		super();
		this.showData = showData;
		this.degrees = degrees;
		this.color = color;
	}
	
		

}
