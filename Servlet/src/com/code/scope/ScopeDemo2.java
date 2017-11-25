package com.code.scope;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ScopeDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 从ServletContext域对象中取出数据
		 */
		ServletContext context = 
				this.getServletContext();
		//String name = (String)context.getAttribute("name");
		@SuppressWarnings("rawtypes")
		List list = (List)context.getAttribute("list");
		
		System.out.println(list);
	}

}
