package cn.itcast.c_collection;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App_set {

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
		
		// 地址对象
		Set<String> addressSet = new HashSet<String>();
		addressSet.add("骏景花园");
		addressSet.add("天朗明居");
		
		// 用户
		Users user = new Users();
		user.setName("老许");
		
		// 关系
		user.setAddressSet(addressSet);
		
		// 保存
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
	}

	// 只要配置好映射，在获取数据的时候，会获取到关联对象的数据 (hibernate自动填充关联数据)
	@Test
	public void testGet() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 主键查询用户
		Users user = (Users) session.get(Users.class,1);
		System.out.println(user.getName());
		System.out.println("-----------");
		System.out.println(user.getAddressSet());  // 懒加载
		session.getTransaction().commit();
		session.close();
	}

}





