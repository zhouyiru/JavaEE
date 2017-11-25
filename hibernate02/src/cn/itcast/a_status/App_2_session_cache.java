package cn.itcast.a_status;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App_2_session_cache {

	private static SessionFactory sf;
	static {
		sf = new Configuration()//
				.configure()//
				.buildSessionFactory();
	}
	
	// 保存
	@Test
	public void testGet() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 主键查询
//		Employee emp = (Employee) session.get(Employee.class, 1);   // 持久化
//		emp.setName("Jacky");   // 执行多次
		
		Employee emp = null;
		/*
		 * 缓存:
		 * 	 1. 根据操作的主键，去缓存(Map) 找，
		 * 		 如果没有找到， 去查询DB，再放入缓存
		 * 		 如果有找到，就不查询数据库， 直接返回缓存对象
		 */
		emp = (Employee) session.get(Employee.class, 1); 
		emp = (Employee) session.get(Employee.class, 1);   // Map<OID, 对象>
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testCache1() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Employee emp1 = (Employee) session.get(Employee.class, 1); 
		emp1.setName("jack1");
		
		// 让一级缓存内容与数据库同步
		session.flush();
		
		emp1.setName("jack2");
		
		session.getTransaction().commit(); // 提交事务的时候，就相当于同步数据库，即调用的是flush();
		session.close();
	}
	
	@Test
	public void testCache2() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 主键查询
		Employee emp1 = (Employee) session.get(Employee.class, 1); 
		
		// 清空一级缓存中对象:  清除指定的对象
		//session.evict(emp1);
		
		// 清空一级缓存中对象:  清除所有的对象
		session.clear();
		
		Employee emp2 = (Employee) session.get(Employee.class, 1); 
		
		session.getTransaction().commit(); // 提交事务的时候，就相当于同步数据库，即调用的是flush();
		session.close();
		
	}
}







