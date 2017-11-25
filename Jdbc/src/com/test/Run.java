package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {


	public static void main(String[] args) {
		
		ApplicationContext aContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("OK");
	}

}
