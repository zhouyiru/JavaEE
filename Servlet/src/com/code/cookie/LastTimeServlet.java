package com.code.cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����[�ϴη���ʱ��]
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class LastTimeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//�����˵�ǰʱ���ַ���
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
		String curDate = sdf.format(new Date());
	
		//��ȡcookie
		Cookie[] cookies = request.getCookies();
		String lastTime = null;
		if(cookies!=null){
			//����cookie�����м������Ƿ�nameΪlastTime��cookie
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("lastTime")){
					lastTime = cookie.getValue();
					//�ҵ��ˣ���n�η���
					//lastTime�������ϴη��ʵ�ʱ��
					//�������ַ������н���
					lastTime = URLDecoder.decode(lastTime, "utf-8");
					//��ʾ���ݸ������ 
					response.getWriter().write("��ӭ�ٴι��ٱ���վ�����ϴη��ʵ�ʱ��Ϊ��"+lastTime+"<br/>��ǰ��ʱ��Ϊ��"+curDate);
					
					//����cookie�ϴη��ʵ�ʱ��
					curDate = URLEncoder.encode(curDate, "utf-8");
					cookie.setValue(curDate);
					response.addCookie(cookie);
					
					break;
				}
			}
			
		}
		//��һ�η���
		if(cookies==null || lastTime==null){
			
			//2)��ʾ�������
			response.getWriter().write("��ӭ�״ι��ٱ���վ����ǰʱ��Ϊ��"+curDate);
			
			//3)�ѵ�ǰʱ�䱣�浽cookie��
			//�����ĸ�ʽ�������ַ������м���
			curDate = URLEncoder.encode(curDate, "utf-8");
			Cookie c = new Cookie("lastTime",curDate);
			
			//4)��cookie���͸������
			response.addCookie(c);
		}
	}

}
