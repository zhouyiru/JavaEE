package cn.itcast.b_second_cache;

import org.hibernate.Query;
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
		Dept dept = null;
		/*
		 * Session1:
		 */
		Session session1 = sf.openSession();
		session1.beginTransaction();
		// 先查询
		dept = (Dept) session1.get(Dept.class, 4);
		System.out.println(dept.getEmployees());
		
		session1.getTransaction().commit(); 
		session1.close();
		
		System.out.println("===============================");
		/*
		 * Session2:		
		 */
		Session session2 = sf.openSession();
		session2.beginTransaction();
		// 又查询
		dept = (Dept) session2.get(Dept.class, 4);  // 没有发送sql，说明从二级缓存获取数据成功！
		System.out.println(dept.getEmployees());   
		
		session2.getTransaction().commit();  
		session2.close();
	}
	
	// hql 查询缓存
	@Test
	public void test_Query_cache() {
		Dept dept = null;
		/*
		 * Session1:
		 */
		Session session1 = sf.openSession();
		session1.beginTransaction();
		// hql 查询
		Query q = session1.createQuery("from Dept").setCacheable(true);// 放入二级缓存或者从二级缓存中获取
		q.list();
		session1.getTransaction().commit(); 
		session1.close();
		
		System.out.println("===============================");
		/*
		 * Session2:		
		 */
		Session session2 = sf.openSession();
		session2.beginTransaction();
		// hql 查询
		q = session2.createQuery("from Dept").setCacheable(true); // 放入二级缓存或者从二级缓存中获取
		q.list();
		session2.getTransaction().commit();  
		session2.close();
	}
	
	
	/*
	 * 更新数据，会不会通知一级缓存、二级缓存
	 *   不会通知一级缓存
	 */
	@Test
	public void test_demo() {
		Dept dept = null;
		/*
		 * Session1:
		 */
		Session session1 = sf.openSession();
		session1.beginTransaction();
		
		//1  对象加入session缓存
		dept = (Dept) session1.get(Dept.class	, 3);
		
		//2  修改
		session1.createQuery("update Dept set deptName=? where id=?")
			.setParameter(0, "HR")
			.setParameter(1, 3)
			.executeUpdate();		// 执行更新
		
		dept = (Dept) session1.get(Dept.class	, 3);
		System.out.println(dept.getDeptName());    //   财务部
		
			
		
		session1.getTransaction().commit(); 
		session1.close();
	}
	
	
	/*
	 * 更新数据，会不会通知一级缓存、二级缓存
	 *   更新数据，二级缓存会监测到最新的结果！
	 *   更改数据，会通知二级缓存！
	 */
	@Test
	public void test_demo2() {
		Dept dept = null;
		/*
		 * Session1:
		 */
		Session session1 = sf.openSession();
		session1.beginTransaction();
		
		//1  对象加入session缓存
		dept = (Dept) session1.get(Dept.class	, 3);
		
		//2  修改
		session1.createQuery("update Dept set deptName=? where id=?")
			.setParameter(0, "HR")
			.setParameter(1, 3)
			.executeUpdate();		// 执行更新
		
		session1.getTransaction().commit(); 
		session1.close();
		
		System.out.println("===================");
		
		/******另外的session*******/
		session1 = sf.openSession();
		session1.beginTransaction();
		
		dept = (Dept) session1.get(Dept.class	, 3);    // HR
		System.out.println(dept.getDeptName());
		
		session1.getTransaction().commit(); 
		session1.close();
		
	}
}












