package org.fkit.hrm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fkit.hrm.domain.User;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthorizedInterceptor implements HandlerInterceptor {
	//���岻��Ҫ���ص�����
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
		

		//Ĭ�ϣ�û�е�½
		boolean flag=false;
		//��������ServltPath
		String servletPath=request.getServletPath();
		//�ж������Ƿ�����
		for(String s:IGNORE_URI)
		{
			if(servletPath.contains(s))
			{
				flag=true;
				break;
			}
		}
		
		//���ص�����
		if(!flag)
		{
			//1����ȡsession�е�user
			User user=(User)(request.getSession().getAttribute("user"));
		    //2���ж�User�Ƿ�Ϊ��
			if(user==null)
			{
				//�û�û��½����ת����½ҳ��
				request.setAttribute("message", "���ȵ�¼�ڷ�����վ��");
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
