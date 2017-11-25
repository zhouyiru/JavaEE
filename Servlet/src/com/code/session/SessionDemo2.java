package com.code.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class SessionDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * ��HttpSession�����л�ȡ����
		 */
		//1)�õ�session����
		HttpSession session = 
					request.getSession(false);
		
		if(session==null){
			System.out.println("û��session����");
		}else{
			//2����ȡ�Ự����
			String name = 
					(String)session.getAttribute("name");
			System.out.println("name="+name);
		}
		
	}

}
