package cn.itcast.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.utils.HibernateUtils;


public class SessionFilter implements Filter{

	// 拦截 *.action的请求
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Transaction tx = null;
		try {
			//1. 创建Session
			Session session = HibernateUtils.getSession();
			//2. 开启事务
			tx = session.beginTransaction();
			//3. 放行 (action/servlet, jsp)
			// filter放行---> action-->Service-->dao
			chain.doFilter(request, response);
			
			// .... 后续操作
			System.out.println("......");
			
		} catch (Exception e) {
			tx.rollback();// 出现异常，回滚
			e.printStackTrace();
		} finally {
			//4. 提交事务
			tx.commit();  // 提交后自动关闭session
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
