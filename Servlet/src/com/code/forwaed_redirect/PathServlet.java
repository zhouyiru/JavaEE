package com.code.forwaed_redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 路径问题
 *   服务器行为         /    代表从当前项目的根目标开始
 *   浏览器行为        /    代表从当前站点的根目录开始
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class PathServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//目标地址： hello.html
		/**
		 * 转发
		 */
		//request.getRequestDispatcher("/hello.html").forward(request, response);
		
		/**
		 * 重定向
		 */
		//response.sendRedirect("/day09/hello.html");
		
		/**
		 * html页面的超链接
		 */
		response.getWriter().write("<a href='/day09/hello.html'>link</a>");
		
		/** 
		 * html页面的表单的action
		 */
		response.getWriter().write("<form action='/day09/hello.html'><input type='submit'/></form>");
		
	}

}
