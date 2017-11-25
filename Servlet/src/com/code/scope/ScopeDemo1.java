package com.code.scope;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ScopeDemo1 extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 把数据存储到ServletContext域对象
		 */
		ServletContext context = 
					this.getServletContext();
		//context.setAttribute("name", "eric");
		@SuppressWarnings("rawtypes")
		List list = new ArrayList();
		list.add("eric");
		list.add("jacky");
		list.add("rose");
		context.setAttribute("list", list);
		System.out.println("保存成功");
	   
	}

}