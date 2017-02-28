package com.example.wavedemo;

import java.io.Serializable;

public class LinePicBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LinePicBean(float actualData) {
		this.actualData=actualData;
	}
	private float actualData;
	private float actualHeight;

	public float getActualData() {
		return actualData;
	}
	public void setActualData(float actualData) {
		this.actualData = actualData;
	}
	public float getActualHeight() {
		return actualHeight;
	}
	public void setActualHeight(float actualHeight) {
		this.actualHeight = actualHeight;
	}
	@Override
	public String toString() {
		return "LinePicBean [actualData=" + actualData + ", actualHeight="
				+ actualHeight + "]";
	}
	
	
	

}
