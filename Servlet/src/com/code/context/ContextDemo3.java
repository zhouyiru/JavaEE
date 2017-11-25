package com.code.context;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ContextDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = 
			this.getServletContext();
		//遍历所有参数
		Enumeration<String> enums = context.getInitParameterNames();
		while(enums.hasMoreElements()){
			String paramName = enums.nextElement();
			String paramValue = context.getInitParameter(paramName);
			System.out.println(paramName+"="+paramValue);
		}
	}

}
