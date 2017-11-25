package com.code.init;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class InitDemo extends HttpServlet {

	
	/**
	 * 开发者应该覆盖这个无参的init方法来编写初始化逻辑。而不是去覆盖有参的init方法
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("执行初始化代码");
	}
	

}