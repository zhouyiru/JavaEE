package cn.itcast.b_lazy;

import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sf;
	static {
		sf = new Configuration()//
				.configure()//
				.buildSessionFactory();
	}
	
	@Test
	public void testApp() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 主键查询
		// get: 及时加载, 只要get就立刻查询数据库
		// 	           如果查询的主键不存在，返回null
//		Employee emp = (Employee) session.get(Employee.class, 100);
//		System.out.println(emp);
		
		// load: 懒加载， 只有在用到数据的时候，才向数据库发送sql语句！
		//       如果查询的主键不存在，只要使用就报错！
		Employee emp = (Employee) session.load(Employee.class, 1);
//		System.out.println(emp);

		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testLoad() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 懒加载
		Employee emp = (Employee) session.load(Employee.class, 1);  
		/*
		 * 解决懒加载异常：
		 * 	   Session关闭后，不能使用懒加载数据！
		 * 	   (1) 在session关闭之前，先使用一次数据； 那么session关闭后再使用对象数据，就不是懒加载数据了
		 * 	   (2) 强迫代理对象初始化
		 * */
		//emp.getName();  			// select ... 
		Hibernate.initialize(emp);
		
		session.getTransaction().commit();
		session.close();
		
		
		System.out.println(emp.getName());     // 不是懒加载数据, 因为数据已经查询出来啦！
	}
}







