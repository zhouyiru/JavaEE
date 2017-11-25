package cn.itcast.b_api;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

// 测试类
public class App_2_query {
	
	private static SessionFactory sf;
	static {
		// 初始化session的工厂
		sf = new Configuration().configure().buildSessionFactory();
	}

	// 1. 主键查询
	@Test
	public void test_primary() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 1.1  get： 查询的主键不存在，返回null
//		Users user =(Users) session.get(Users.class, 50);
//		System.out.println(user);
		
		// 1.2 load : 查询的主键不存在只要使用就报错！
		Users user =(Users) session.load(Users.class, 5);
		System.out.println(user);
		
		session.getTransaction().commit(); 
		session.close();

	}
	
	
	//2. hql 查询
	@Test
	public void test_query() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 得到hql查询接口
		Query q = session.createQuery("from Users");
		// 查询数据
		List<Users> list = q.list(); 
		System.out.println(list);
		
		session.getTransaction().commit(); 
		session.close();
	}
	
	//2. criteria 查询 , 完全面向对象的查询
	@Test
	public void test_criteria() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 获取Criteria接口
		Criteria c = session.createCriteria(Users.class);
		// 设置条件
		c.add(Restrictions.eq("userName", "Jacky001"));
		
		List<Users> list = c.list();
		System.out.println(list);
		
		session.getTransaction().commit(); 
		session.close();

	}

	
}
