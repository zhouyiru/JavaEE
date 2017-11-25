package com.code.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 【context对象的作用1】-获取web上下文路径
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ContextDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * 获取web上下路径
		 */
		//1.1.获取ServletContext对象
		//ServletContext context = this.getServletConfig().getServletContext();
		/**
		 * 推荐使用简写
		 */
		ServletContext context = this.getServletContext();
		
		//1.2 获取
		String path = context.getContextPath();
		System.out.println(path); // /day09
		/**
		 * web上下文路径就是项目在tomcat服务器中运行的路径。注意不是开发目录的项目名称。
		 */
		//请求重定向
		//response.sendRedirect("/day09/hello.html");
		
		//作用：可以让这个获取文件的路径更加灵活
		response.sendRedirect(context.getContextPath()+"/hello.html");
	}

}
