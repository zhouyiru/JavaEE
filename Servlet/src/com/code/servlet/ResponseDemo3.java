package com.code.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 案例【refresh】--定时刷新或每隔n秒跳转页面
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ResponseDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//设置refresh响应头
		//设置秒数
		//response.setHeader("refresh", "2");
		
		//每隔n秒跳转页面
		response.getWriter().write("注册成功！3秒之后会跳转到主页");
		//设置refresh
		response.setHeader("refresh", "3;/day08/adv.html");
	}

}
