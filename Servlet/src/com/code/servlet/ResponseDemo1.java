package com.code.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ResponseDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
       //相应行
		response.setStatus(404);
		response.sendError(404);
      //响应头
		response.setHeader("serve", "webLogic");
      //实体内容
		response.getWriter().write("hello");//字符流
		response.getOutputStream().write("hello".getBytes());//字节流
	}
}
