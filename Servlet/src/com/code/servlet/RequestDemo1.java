package com.code.servlet;

import java.io.IOException;
//��user-agent��ͷ������ȡ���������

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RequestDemo1 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
	    String userAgent = request.getHeader("user-agent");//���������
	    System.out.println(userAgent);
	    if(userAgent.contains("Firefox")){
	    	response.getWriter().write("���");
	    }else if(userAgent.contains("Chrome")){
	    	response.getWriter().write("�ȸ�");
	}else if(userAgent.contains("Trident")){
    	response.getWriter().write("IE");
	}else{
    	response.getWriter().write("����ʶ��");
        }
	}
}
