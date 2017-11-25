package com.code.life;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �鿴servlet����������
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class LifeDemo extends HttpServlet {

	/**
	 * 1)���췽����servlet���󴴽�ʱ���õ�
	 */
	public LifeDemo(){
		System.out.println("servlet���󱻴�����");
	}
	
	/**
	 * 2)��ʼ������
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init����������");
	}
	
	/**
	 * 3)���񷽷�
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("service����������");
	}
	
	/**
	 * 4�����ٷ�����sevlet��������ʱ���õ�
	 */
	@Override
	public void destroy() {
		System.out.println("servlet����������");
	}	
}
