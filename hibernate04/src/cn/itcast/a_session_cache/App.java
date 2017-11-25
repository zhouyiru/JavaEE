package cn.itcast.a_session_cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)
			.addClass(Employee.class)
			.buildSessionFactory();
	}
	// 不能的Session，能否共享一级缓存数据！
	@Test
	public void test_session_cache() {
		Session session1 = sf.openSession();
		session1.beginTransaction();
		Session session2 = sf.openSession();
		session2.beginTransaction();
		
		// 1. 先使用第一个session查询，
		Dept dept = (Dept) session1.get(Dept.class, 3);
		
		// 2. 再使用第二个session更新，
		session2.update(dept);
		
		// 3. 修改
		dept.setDeptName("New Dept");
		
		
		session1.getTransaction().commit();  // 第一个session的缓存区与数据库同步
		session1.close();
		session2.getTransaction().commit();   // 第二个session的缓存区与数据库同步
		session2.close();
	}
}












