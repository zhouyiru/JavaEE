package com.code.forwaed_redirect;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 【context对象作用4】--请求转发
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ForwardDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 转发：服务器行为
		 */
		/*
		ServletContext context = this.getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/hello.html");
		rd.forward(request, response);
		*/
		/**
		 * 注意：转发只能转发都当前项目的资源
		 */
		//this.getServletContext().getRequestDispatcher("../day08/adv.html")
			//	.forward(request, response);
		
		/**
		 * 把数据保存到request域对象
		 */
		request.setAttribute("name", "jacky");
		
		
		//this.getServletContext().getRequestDispatcher("/GetDataServlet")
			//	.forward(request, response);
		
		/**
		 * 简写方式
		 */
		request.getRequestDispatcher("/GetDateServlet").forward(request, response);
	}

}
