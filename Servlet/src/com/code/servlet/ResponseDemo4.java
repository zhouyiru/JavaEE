package com.code.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ������content-type��--���������͸���������������ͺ����ݱ����ʽ
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ResponseDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����content-type��Ӧ
		//response.setHeader("content-type", "text/html;charset=utf-8");
		//response.setContentType("text/html;charset=utf-8");//�ȼ�������Ĵ���
		
		
		/**
		 * 1)������������
		 */
		//response.setContentType("text/html");//�����������ʲô���ĸ�ʽ������ʵ������
		//response.setContentType("image/jpg");//�����������ʲô���ĸ�ʽ������ʵ������
		/**
		 * ע�⣺ һ��Ҫд������֧�ֵ��������ͣ����д�˷�������֧�ֵ����ͣ��ͻᱨ��
		 */
		/**
		 * 2���������ݱ����ʽ
		 */
		/**
		 *    �������ã�
		 *    		1������������ݵı���
		 *          2������������Զ���Ӧ������ݵı���
		 */
		response.setContentType("text/html;charset=gbk"); //������Ĵ�����Ч����һ���ġ�
		//response.setCharacterEncoding("utf-8"); //�������������Զ���ת�������� 
		
		response.getWriter().write("<html><head><title>this is tille</title></head><body>����</body></html>");
		
		
	}

}

