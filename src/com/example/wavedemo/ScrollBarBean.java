package com.example.wavedemo;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author huozhenpeng
 *
 */
public class ScrollBarBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ScrollPerBarBean> lists;
	private int total;

	public List<ScrollPerBarBean> getLists() {
		return lists;
	}

	public void setLists(List<ScrollPerBarBean> lists) {
		this.lists = lists;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	
}

