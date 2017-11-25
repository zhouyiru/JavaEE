package cn.itcast.c_collection;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App_map {

	private static SessionFactory sf;
	static {
		sf = new Configuration()//
				.configure()//
				.addClass(Users.class)//相当于：<mapping resource=""/> 配置, 映射必须与bean在同包
				.buildSessionFactory();  
	}
	
	@Test
	public void testApp() {
		Session session = sf.openSession();
		session.beginTransaction();
		// 用户
		Users user = new Users();
		user.setName("老许");
		user.getAddressMap().put("gzjj", "广州骏景花园");
		user.getAddressMap().put("scba", "深圳宝安");
		// 保存
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testGet() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Users user = (Users) session.get(Users.class, 5);
		System.out.println(user.getName());
		System.out.println(user.getAddressMap());
		
		session.getTransaction().commit();
		session.close();
	}

}





