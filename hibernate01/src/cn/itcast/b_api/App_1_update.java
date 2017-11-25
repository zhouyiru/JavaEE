package cn.itcast.b_api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

// 测试类
public class App_1_update {
	
	private static SessionFactory sf;
	static {
//		Configuration config = new Configuration();
//		config.configure();
//		sf = config.buildSessionFactory();
		
		// 初始化session的工厂
		sf = new Configuration().configure().buildSessionFactory();
	}

	/*
	 * 1. 更新的方法
	 */
	@Test
	public void testUpdate() throws Exception {

		// 对象
		Users users = new Users();
		users.setUserName("tom");
		users.setAge(30);

		// 创建session对象
		Session session = sf.openSession();
		session.beginTransaction();
		
		/*
		 * 1. 保存对象
		 */
		//session.save(users);
		
		/*
		 * 2. 主键查询
		 */
//		Users u = (Users) session.get(Users.class, 1);
//		System.out.println(u);
		
		/*
		 * 3. 删除
		 */
		// 方式1： 模拟一个对象
//		Users u = new Users();
//		u.setUserId(1);
//		session.delete(u);
		
		// 方式2， 先查询，再删除
//		Object obj = session.get(Users.class, 21);
//		if (obj != null) {
//			session.delete(obj);
//		}
		
		/*
		 * 4. 修改
		 */
//		Users u = new Users();
//		u.setUserId(30000);
//		u.setAge(30);
//		session.update(u);
		
		/*
		 * 5. 保存或更新、
		 * 	      但没有设置主键，执行保存
		 *    当有设置主键执行更新，但主键必须存在，如果主键不存在就不知道更新哪条记录，hibernate就报错！
		 */
		Users u = new Users();
		u.setUserId(5);
		u.setUserName("Jacky001");
		session.saveOrUpdate(u);
		
		
		
		session.getTransaction().commit();   // 获取绑定到当前session上的事务，并提交
		session.close();

	}
	
	@Test
	public void bak() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(new Users());
		
		session.getTransaction().commit(); 
		session.close();

	}

	
}
