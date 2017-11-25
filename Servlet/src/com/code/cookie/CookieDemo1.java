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
 * 使用cookie技术
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1)创建Cookie对象，保存会话数据
		//如果要发送中文，必须先使用URLEncoder进行加密
		String n = URLEncoder.encode("张三", "utf-8");
		Cookie c = new Cookie("name",n);
		Cookie c2 = new Cookie("email","jacky@qq.com");	
		
		/**
		 * 1)设置有效路径。默认情况下，设置当前项目的根目录下
		 *    什么是有效路径？ 如果把该cookie设置到某个有效路径下，然后当浏览器访问这个有效路径的时候，才会携带这个cookie数据给服务器。
		 */
		//c.setPath("/day11");
		
		/**
		 * 2)设置有效时间
		 * 		 正整数： 表示超过了正整数的数值的时间，cookie就会丢失！！（cookie保存浏览器的缓存																				目录）单位：秒
				负整数： 表示如果浏览器关闭了，cookie就会丢失！（cookie保存浏览器内存） （默认情况)
					  0    ：  表示删除同名的cookie	

		 */
		//c.setMaxAge(20); //20秒之后cookie丢失！！！
		c.setMaxAge(-1); //浏览器关闭cookie丢失！！！（默认情况下）
		
		//2)把cookie发送给浏览器.通过响应头携带cookie数据给浏览器(set-cookie)
		//response.setHeader("set-cookie", "name=jacky");
		/**
		 *简化版本
		 */
		response.addCookie(c);
		response.addCookie(c2);
		
		//3)浏览器在下次访问的时候携带了cookie数据，通过请求头发送给服务器（cookie）
		
		
		//4)服务器获取浏览器发送的cookie数据
		//String name = request.getHeader("cookie");
		/**
		 * 简化版本
		 */
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				//cookie的名称
				String name = cookie.getName();
				//对加密之后的name进行解密
				String value = cookie.getValue();
				value = URLDecoder.decode(value, "utf-8");
				System.out.println(name+"="+value);
			}
		}else{
			System.out.println("没有cookie信息");
		}
	}

}
