package com.code.context;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��context��������2��-��ȡȫ�ֲ���
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ContextDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * �õ�ȫ�ֲ���
		 */
		ServletContext context = 
				this.getServletContext();
		
		System.out.println(context.getInitParameter("AAA"));
		
		//�������в���
		Enumeration<String> enums = context.getInitParameterNames();
		while(enums.hasMoreElements()){
			String paramName = enums.nextElement();
			String paramValue = context.getInitParameter(paramName);
			System.out.println(paramName+"="+paramValue);
		}
			
	}

}
