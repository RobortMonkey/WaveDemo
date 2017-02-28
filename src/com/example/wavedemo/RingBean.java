package com.example.wavedemo;

import java.io.Serializable;

public class RingBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String money;
	private String proName;
	private int angles;
	private String color;
	private boolean flag;
	private int tempSum;
	

	public int getTempSum() {
		return tempSum;
	}

	public void setTempSum(int tempSum) {
		this.tempSum = tempSum;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public int getAngles() {
		return angles;
	}

	public void setAngles(int angles) {
		this.angles = angles;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public RingBean(String money, String proName, int angles, String color) {
		super();
		this.money = money;
		this.proName = proName;
		this.angles = angles;
		this.color = color;
	}
	
	

}
