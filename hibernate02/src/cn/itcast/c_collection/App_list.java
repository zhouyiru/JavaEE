package cn.itcast.c_collection;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App_list {

	private static SessionFactory sf;
	static {
		sf = new Configuration()//
				.configure()//
				.addClass(Users.class)//相当于：<mapping resource=""/> 配置, 映射必须与bean在同包
				.buildSessionFactory();  
	}
	
	// 保存对象时候，会保存对象关联的数据！
	@Test
	public void testApp() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 用户
		Users user = new Users();
		user.setName("老许");
		user.getAddressList().add("b_深圳福田...");
		user.getAddressList().add("a_深圳宝安...");
		
		// 保存
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	@Test
	public void testGet() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 用户
		Users user = (Users) session.get(Users.class, 4);
		System.out.println(user.getName());
		System.out.println(user.getAddressList());
		
		session.getTransaction().commit();
		session.close();
	}


}





