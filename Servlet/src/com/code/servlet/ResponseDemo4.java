package com.code.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 案例【content-type】--服务器发送给浏览器的数据类型和数据编码格式
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ResponseDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置content-type响应
		//response.setHeader("content-type", "text/html;charset=utf-8");
		//response.setContentType("text/html;charset=utf-8");//等价于上面的代码
		
		
		/**
		 * 1)设置数据类型
		 */
		//response.setContentType("text/html");//告诉浏览器以什么样的格式来解析实体内容
		//response.setContentType("image/jpg");//告诉浏览器以什么样的格式来解析实体内容
		/**
		 * 注意： 一定要写服务器支持的数据类型，如果写了服务器不支持的类型，就会报错
		 */
		/**
		 * 2）设置数据编码格式
		 */
		/**
		 *    两个作用：
		 *    		1）设置输出数据的编码
		 *          2）告诉浏览器自动适应输出数据的编码
		 */
		response.setContentType("text/html;charset=gbk"); //和下面的代码是效果是一样的。
		//response.setCharacterEncoding("utf-8"); //不会告诉浏览器自动跳转解码的码表 
		
		response.getWriter().write("<html><head><title>this is tille</title></head><body>主题</body></html>");
		
		
	}

}

