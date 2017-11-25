package com.code.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 案例【location+302】请求重定向
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ResponseDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 请求重定向（  跳转到其他页面 ）
		 */
		/*//设置302状态码
		response.setStatus(302);
		//设置location响应头
		response.setHeader("location", "/Servlet/adv.html");*/
		
		/**
		 * 简化版本
		 */
		response.sendRedirect("/Servlet/adv.html");
	}

}
