package com.code.forwaed_redirect;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��context��������4��--����ת��
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ForwardDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * ת������������Ϊ
		 */
		/*
		ServletContext context = this.getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/hello.html");
		rd.forward(request, response);
		*/
		/**
		 * ע�⣺ת��ֻ��ת������ǰ��Ŀ����Դ
		 */
		//this.getServletContext().getRequestDispatcher("../day08/adv.html")
			//	.forward(request, response);
		
		/**
		 * �����ݱ��浽request�����
		 */
		request.setAttribute("name", "jacky");
		
		
		//this.getServletContext().getRequestDispatcher("/GetDataServlet")
			//	.forward(request, response);
		
		/**
		 * ��д��ʽ
		 */
		request.getRequestDispatcher("/GetDateServlet").forward(request, response);
	}

}
