package com.code.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��context���������1��-��ȡweb������·��
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ContextDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * ��ȡweb����·��
		 */
		//1.1.��ȡServletContext����
		//ServletContext context = this.getServletConfig().getServletContext();
		/**
		 * �Ƽ�ʹ�ü�д
		 */
		ServletContext context = this.getServletContext();
		
		//1.2 ��ȡ
		String path = context.getContextPath();
		System.out.println(path); // /day09
		/**
		 * web������·��������Ŀ��tomcat�����������е�·����ע�ⲻ�ǿ���Ŀ¼����Ŀ���ơ�
		 */
		//�����ض���
		//response.sendRedirect("/day09/hello.html");
		
		//���ã������������ȡ�ļ���·���������
		response.sendRedirect(context.getContextPath()+"/hello.html");
	}

}
