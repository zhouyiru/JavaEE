package com.code.init;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class InitDemo extends HttpServlet {

	
	/**
	 * ������Ӧ�ø�������޲ε�init��������д��ʼ���߼���������ȥ�����вε�init����
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("ִ�г�ʼ������");
	}
	

}