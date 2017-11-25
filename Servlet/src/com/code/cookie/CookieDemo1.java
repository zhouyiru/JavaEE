package com.code.cookie;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ʹ��cookie����
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1)����Cookie���󣬱���Ự����
		//���Ҫ�������ģ�������ʹ��URLEncoder���м���
		String n = URLEncoder.encode("����", "utf-8");
		Cookie c = new Cookie("name",n);
		Cookie c2 = new Cookie("email","jacky@qq.com");	
		
		/**
		 * 1)������Ч·����Ĭ������£����õ�ǰ��Ŀ�ĸ�Ŀ¼��
		 *    ʲô����Ч·���� ����Ѹ�cookie���õ�ĳ����Ч·���£�Ȼ����������������Ч·����ʱ�򣬲Ż�Я�����cookie���ݸ���������
		 */
		//c.setPath("/day11");
		
		/**
		 * 2)������Чʱ��
		 * 		 �������� ��ʾ����������������ֵ��ʱ�䣬cookie�ͻᶪʧ������cookie����������Ļ���																				Ŀ¼����λ����
				�������� ��ʾ���������ر��ˣ�cookie�ͻᶪʧ����cookie����������ڴ棩 ��Ĭ�����)
					  0    ��  ��ʾɾ��ͬ����cookie	

		 */
		//c.setMaxAge(20); //20��֮��cookie��ʧ������
		c.setMaxAge(-1); //������ر�cookie��ʧ��������Ĭ������£�
		
		//2)��cookie���͸������.ͨ����ӦͷЯ��cookie���ݸ������(set-cookie)
		//response.setHeader("set-cookie", "name=jacky");
		/**
		 *�򻯰汾
		 */
		response.addCookie(c);
		response.addCookie(c2);
		
		//3)��������´η��ʵ�ʱ��Я����cookie���ݣ�ͨ������ͷ���͸���������cookie��
		
		
		//4)��������ȡ��������͵�cookie����
		//String name = request.getHeader("cookie");
		/**
		 * �򻯰汾
		 */
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				//cookie������
				String name = cookie.getName();
				//�Լ���֮���name���н���
				String value = cookie.getValue();
				value = URLDecoder.decode(value, "utf-8");
				System.out.println(name+"="+value);
			}
		}else{
			System.out.println("û��cookie��Ϣ");
		}
	}

}
