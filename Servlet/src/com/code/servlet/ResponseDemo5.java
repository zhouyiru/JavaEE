package com.code.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 案例【Content-Disposition】 -- attachment; filename=aaa.zip   -- 以下载方式打开资源
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ResponseDemo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File file = new File("e:/mm.jpg");
		/**
		 * 告诉浏览器以下载的方法打开
		 */
		response.setHeader("content-disposition", "attachment;filename="+file.getName());
		
		/**
		 * 文件下载
		 */
		//1)读取本地文件
		FileInputStream in = new FileInputStream(file);
		
		//2)写出给浏览器(字节内容)
		OutputStream out = response.getOutputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		//边读边写
		while( (len=in.read(buf))!=-1  ){
			out.write(buf, 0, len);
		}
		
		//关闭
		in.close();
		out.close();
		
		
	}

}
