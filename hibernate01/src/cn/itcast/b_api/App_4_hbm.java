package cn.itcast.b_api;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

// 测试类
public class App_4_hbm {
	
	private static SessionFactory sf;
	static {
		// 初始化session的工厂
		sf = new Configuration().configure().buildSessionFactory();
	}

	@Test
	public void test_primary() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// HQL语句查询
		Query q = session.createQuery("from Users");
		
		session.getTransaction().commit(); 
		session.close();

	}

	
}
