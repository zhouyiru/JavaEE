package com.code.forwaed_redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ·������
 *   ��������Ϊ         /    ����ӵ�ǰ��Ŀ�ĸ�Ŀ�꿪ʼ
 *   �������Ϊ        /    ����ӵ�ǰվ��ĸ�Ŀ¼��ʼ
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class PathServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Ŀ���ַ�� hello.html
		/**
		 * ת��
		 */
		//request.getRequestDispatcher("/hello.html").forward(request, response);
		
		/**
		 * �ض���
		 */
		//response.sendRedirect("/day09/hello.html");
		
		/**
		 * htmlҳ��ĳ�����
		 */
		response.getWriter().write("<a href='/day09/hello.html'>link</a>");
		
		/** 
		 * htmlҳ��ı���action
		 */
		response.getWriter().write("<form action='/day09/hello.html'><input type='submit'/></form>");
		
	}

}
