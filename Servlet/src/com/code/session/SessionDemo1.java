package com.code.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class SessionDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * �����ݱ��浽HttpSession������
		 */
		//1)����HttpSession����
		HttpSession session = 
				request.getSession(true);
		/**
		 * ����session����Чʱ��
		 */
		//session.setMaxInactiveInterval(20);
		
		/**
		 * ����JSESSIONID��ʱ�䣬��������������رն���ʧ��
		 */
		Cookie c = new Cookie("JSESSIONID",session.getId());
		c.setMaxAge(1*30*24*60*60);//1����
		response.addCookie(c);
		
		//2)����Ự����
		session.setAttribute("name", "jacky");
	}

}
