package com.code.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ɾ��ͬ����cookie
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class CookieDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie c = new Cookie("name","abc");
		c.setMaxAge(0);
		
		//����cookie
		response.addCookie(c);
		
		System.out.println("ɾ���ɹ���");
	}

}

