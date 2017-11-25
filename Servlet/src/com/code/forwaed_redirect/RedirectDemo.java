package com.code.forwaed_redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RedirectDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 请求重定向（浏览器行为）
		 */
		//response.sendRedirect("/day09/hello.html");
		
		/**
		 * 注意：
		 * 		可以跳转到当前项目的资源，也可以跳转到其他项目的资源
		 */
		//response.sendRedirect("/day08/adv.html");
		
		/**
		 * 把数据保存到request域对象
		 */
		request.setAttribute("name", "jacky");
		
		response.sendRedirect("/day09/GetDataServlet");
		
	}

}
