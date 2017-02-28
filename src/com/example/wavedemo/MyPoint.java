package com.example.wavedemo;

import java.io.Serializable;

public class MyPoint implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyPoint() {
		// TODO Auto-generated constructor stub
	}

	private int x1;
	private int x2;
	private int x3;

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getX3() {
		return x3;
	}

	public void setX3(int x3) {
		this.x3 = x3;
	}

	public void set(int x1, int x2, int x3) {
		setX1(x1);
		setX2(x2);
		setX3(x3);
	}

	@Override
	public String toString() {
		return "MyPoint [x1=" + x1 + ", x2=" + x2 + ", x3=" + x3 + "]";
	}
	
	

}
