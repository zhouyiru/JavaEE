package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.BankDao;
import com.dao.impl.BankDaoImpl;
import com.service.BankService;

public class Run {

	public static void main(String[] args) {

		ApplicationContext aContext = new ClassPathXmlApplicationContext("applicationContext.xml");
   //   BankDao bankDao = (BankDao) aContext.getBean("bankDaoImpl");
//      bankDao.inMoney(100, 1);
//       bankDao.outMoney(100, 1);
//       System.out.println("bankDaoImpl------------------------------OK");
		BankService bankService =  (BankService) aContext.getBean("bankServiceImpl");
		bankService.Transfer(20, 1, 2);
		
      System.out.println("bankServiceImpl------------------------------OK");
	}

}
