package com.entity;

public class Year {

	private int date;

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public boolean isLeap() {
		if (date % 4 == 0 && date % 100 != 0 || date % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}
}
