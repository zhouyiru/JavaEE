package org.fkit.hrm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fkit.hrm.domain.User;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthorizedInterceptor implements HandlerInterceptor {
	//定义不需要拦截的请求
    private static final String[] IGNORE_URI={"/loginForm","/login"};
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response,
			Object handler) throws Exception {
		

		//默认，没有登陆
		boolean flag=false;
		//获得请求的ServltPath
		String servletPath=request.getServletPath();
		//判断请求是否被拦截
		for(String s:IGNORE_URI)
		{
			if(servletPath.contains(s))
			{
				flag=true;
				break;
			}
		}
		
		//拦截的请求
		if(!flag)
		{
			//1，获取session中的user
			User user=(User)(request.getSession().getAttribute("user"));
		    //2，判断User是否为空
			if(user==null)
			{
				//用户没登陆，跳转到登陆页面
				request.setAttribute("message", "请先登录在访问网站！");
				request.getRequestDispatcher("/loginForm").forward(request, response);
				return flag;
			}
			else {
				return true;
			}
		}
		return flag;
	}

}
