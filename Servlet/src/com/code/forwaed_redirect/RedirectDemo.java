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
		 * �����ض����������Ϊ��
		 */
		//response.sendRedirect("/day09/hello.html");
		
		/**
		 * ע�⣺
		 * 		������ת����ǰ��Ŀ����Դ��Ҳ������ת��������Ŀ����Դ
		 */
		//response.sendRedirect("/day08/adv.html");
		
		/**
		 * �����ݱ��浽request�����
		 */
		request.setAttribute("name", "jacky");
		
		response.sendRedirect("/day09/GetDataServlet");
		
	}

}
