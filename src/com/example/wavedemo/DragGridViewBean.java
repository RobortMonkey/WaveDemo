package com.example.wavedemo;
import java.io.Serializable;

public class DragGridViewBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String string;
	private int red;
	private int green;
	private int blue;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	@Override
	public String toString() {
		return "DragGridViewBean [string=" + string + ", red=" + red
				+ ", green=" + green + ", blue=" + blue + "]";
	}

	public DragGridViewBean(String string, int red, int green, int blue) {
		super();
		this.string = string;
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

}
