package com.code.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RequestDemo2 extends HttpServlet {

	/**
         ��rerfer��ͷ������ֹ�Ƿ�����
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
	   String rerfer = request.getHeader("rerfer");
	   System.out.println(rerfer);
	   if(rerfer==null||!rerfer.contains("/adv.html")){
		   response.getWriter().write("�Ƿ�����,�ص���ҳ<a href='/Servlet/adv.html'>��ҳ</a>");
	   }else{
		response.getWriter().write("�������ء�����");
	   }

}
}
