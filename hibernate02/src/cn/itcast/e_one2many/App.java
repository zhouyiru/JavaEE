package cn.itcast.e_one2many;

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
				.addClass(Users.class)//
				.addClass(Address.class)//
				.buildSessionFactory();  
	}
	
	// 多对一关系的保存数据， 先保存一的一方的数据，再保存多的一方的数据！
	@Test
	public void testApp() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 用户
		Users users = new Users();
		users.setName("周颖");
		users.setAge(25);
		
		// 地址
		Address address_gz = new Address();
		address_gz.setName("广州天河..");
		address_gz.setShortName("gzth");
		address_gz.setCode("51000");
		
		Address address_sz = new Address();
		address_sz.setName("深圳宝安..");
		address_sz.setShortName("szba");
		address_sz.setCode("53000");
		
		// 关系  (通过一的一方维护关系)
		users.getAddress().add(address_gz);
		users.getAddress().add(address_sz);
		
		
		
		// 保存信息
		session.save(users);
		session.save(address_gz);
		session.save(address_sz);
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	@Test
	public void testGet() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 主键查询地址
		Users user = (Users) session.get(Users.class, 4);
		System.out.println(user.getName());
//		user.getAddress().size();
		Hibernate.initialize(user.getAddress());

		session.getTransaction().commit();
		session.close();
		
		System.out.println(user.getAddress());
	}


}





