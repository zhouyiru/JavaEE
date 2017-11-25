package cn.itcast.a_status;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App_3_list_iterator {

	private static SessionFactory sf;
	static {
		sf = new Configuration()//
				.configure()//
				.buildSessionFactory();
	}
	
	//1. list查询
	@Test
	public void test_list() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// HQL查询接口
		Query q = session.createQuery("from Employee");
		
		// --------第一次查询---------
		List<Employee> list = q.list();			// 【查询数据库】
		// 遍历
		for (Employee emp : list) {
			System.out.println(emp);
		}
		
		System.out.println("=======");
		
		
		// ----------第二次查询-------
		list = q.list();						// 【查询数据库】 , 放入缓存？   没有从缓存中取！
		// 遍历
		for (Employee emp : list) {
			System.out.println(emp);
		}

		session.getTransaction().commit();
		session.close();
	}
	
	// 2. iterator查询
	// N+1, 当使用iterator查询的时候, 发送到数据库的sql语句的个数是：总记录数 + 1
	//      N= 总记录数
	//      1= 统计所有的主键
	//  会放入缓存，且会从缓存中找！
	@Test
	public void test_iterator() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//-----------------------------------
		// 查询接口
		Query q = session.createQuery("from Employee");
		Iterator<Employee> it = q.iterate();
		// 迭代
		while (it.hasNext()){
			Employee emp = it.next();
			System.out.println(emp);       // 先从缓存找，没有找到，再找数据库，最后把查询到放入缓存
		}
		
		System.out.println("==============");
		
		//-----------------------------------
		it = q.iterate();
		// 迭代
		while (it.hasNext()){
			Employee emp = it.next();
			System.out.println(emp);		// 从缓存中获取
		}

		session.getTransaction().commit();
		session.close();
	}
	
	// 3. list与iterator区别
	/*
	 * 整体思路： 
	 * 		先执行一次list, 再执行iterator！
	 * 		如果iterator查询每一条记录没有去找数据库， 说明list查询有放入缓存!
	 * 
	 */
	@Test
	public void test_list_iterator() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 查询接口
		Query q = session.createQuery("from Employee");
		
		/*
		 * 1. 先list
		 */
		List<Employee> list = q.list();			//2. 说明这里有放入缓存
		for (Employee emp : list) {
			System.out.println(emp);
		}
		
		System.out.println("===========");
		
		/*
		 * 2. 再iterator
		 */
		Iterator<Employee> it = q.iterate();
		while (it.hasNext()){
			Employee emp = it.next();
			System.out.println(emp);    		//1. 从缓存取
		}
		
		
		
		

		session.getTransaction().commit();
		session.close();
	}
}







