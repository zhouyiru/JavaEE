package com.code.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ConfigDemo extends HttpServlet {
	
	/*private ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}*/
	
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = null;
		
		/**
		 * 读取到servlet的初始化参数（init-param）
		 */
		path = this.getServletConfig().getInitParameter("path");
		
		/**
		 * 读取文件内容
		 */
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(path));
		String str = null;
		while( (str=br.readLine())!=null){
			System.out.println(str);
		}
		
	}

}
