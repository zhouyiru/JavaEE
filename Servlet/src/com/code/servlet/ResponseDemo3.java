package com.code.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ������refresh��--��ʱˢ�»�ÿ��n����תҳ��
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ResponseDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//����refresh��Ӧͷ
		//��������
		//response.setHeader("refresh", "2");
		
		//ÿ��n����תҳ��
		response.getWriter().write("ע��ɹ���3��֮�����ת����ҳ");
		//����refresh
		response.setHeader("refresh", "3;/day08/adv.html");
	}

}
