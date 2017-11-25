package cn.itcast.d_many2one;

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
		
		// 地址
		Address address_gz = new Address();
		address_gz.setName("广州天河..");
		address_gz.setShortName("gzth");
		address_gz.setCode("51000");
		
		Address address_sz = new Address();
		address_sz.setName("深圳宝安..");
		address_sz.setShortName("szba");
		address_sz.setCode("53000");
		
		// 用户
		Users users = new Users();
		users.setName("周颖");
		users.setAge(25);
		
		// 关系
		address_gz.setUser(users);
		address_sz.setUser(users);
		
		//----
		// 保存用户、地址  (先保存地址，再保存用户，生成5条sql， 会多2条update语句)
//		session.save(address_gz);
//		session.save(address_sz);
//		session.save(users);
		
		// 更改保存顺序  （生成3条insert，  因为保存地址的时候，已经有用户id了）
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
		Address address = (Address) session.get(Address.class, 1);
		System.out.println(address.getName());
		// 获取地址关联的用户对象， （懒加载）
		System.out.println(address.getUser().getName());// 用到数据时候才查询! 

		session.getTransaction().commit();
		session.close();
	}


}





