package com.dao;

public interface BankDao {

	public void outMoney(int money,int userid);
	public void inMoney(int money,int userid);
}
