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
		 * 从HttpSession对象中获取数据
		 */
		//1)得到session对象
		HttpSession session = 
					request.getSession(false);
		
		if(session==null){
			System.out.println("没有session对象");
		}else{
			//2）获取会话数据
			String name = 
					(String)session.getAttribute("name");
			System.out.println("name="+name);
		}
		
	}

}
