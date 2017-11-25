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
       //��Ӧ��
		response.setStatus(404);
		response.sendError(404);
      //��Ӧͷ
		response.setHeader("serve", "webLogic");
      //ʵ������
		response.getWriter().write("hello");//�ַ���
		response.getOutputStream().write("hello".getBytes());//�ֽ���
	}
}
