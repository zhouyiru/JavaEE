package com.code.servlet;

import java.io.IOException;
//【user-agent】头——获取浏览器类型

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RequestDemo1 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
	    String userAgent = request.getHeader("user-agent");//浏览器类型
	    System.out.println(userAgent);
	    if(userAgent.contains("Firefox")){
	    	response.getWriter().write("火狐");
	    }else if(userAgent.contains("Chrome")){
	    	response.getWriter().write("谷歌");
	}else if(userAgent.contains("Trident")){
    	response.getWriter().write("IE");
	}else{
    	response.getWriter().write("不能识别");
        }
	}
}
