package cn.itcast.d_session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.junit.Test;

public class App {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.buildSessionFactory();
	}

	// 2种方式创建session
	@Test
	public void testSession() throws Exception {
		System.out.println(sf);
		// 方式1: sf.openSession()  每次都创建一个新的session！
		Session session1 = sf.openSession();
		Session session2 = sf.openSession();
		System.out.println(session1 == session2);  // false
		session1.close();
		session2.close();
		
		// 方式2： 线程的方式创建session
		// getCurrentSession() 先从当前线程获取session，没有获取到，就创建新的session
		// 创建完成后，再绑定到当前线程！
		Session session3 = sf.getCurrentSession();
		Session session4 = sf.getCurrentSession();
		System.out.println(session3 == session4);  // true
		session3.close();
		//session4.close();		// 不能重复关闭
	}
}











