package com.code.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ������location+302�������ض���
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ResponseDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * �����ض���  ��ת������ҳ�� ��
		 */
		/*//����302״̬��
		response.setStatus(302);
		//����location��Ӧͷ
		response.setHeader("location", "/Servlet/adv.html");*/
		
		/**
		 * �򻯰汾
		 */
		response.sendRedirect("/Servlet/adv.html");
	}

}
