package cn.itcast.a_config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

// 测试类
public class App {

	@Test
	// 保存
	public void testSave() throws Exception {

		// 对象
		Users users = new Users();
		users.setUserName("Jack");
		users.setAge(30);

		// 1. 创建配置管理器对象
		Configuration config = new Configuration();
		// 2. 加载主配置文件， 默认加载src/hibernate.cfg.xml
		config.configure();
		// 3. 根据加载的主配置文件，创建对象
		SessionFactory sf = config.buildSessionFactory();
		// 4. 创建Session对象
		Session session = sf.openSession();
		// 5. 开启事务
		Transaction tx = session.beginTransaction();

		// --- 保存
		session.save(users);

		// 6. 提交事务/关闭session
		tx.commit();
		session.close();

	}

	@Test
	// 获取对象
	public void testGet() throws Exception {


		// 1. 创建配置管理器对象
		Configuration config = new Configuration();
		// 2. 加载主配置文件， 默认加载src/hibernate.cfg.xml
		config.configure();
		// 3. 根据加载的主配置文件，创建对象
		SessionFactory sf = config.buildSessionFactory();
		// 4. 创建Session对象
		Session session = sf.openSession();
		// 5. 开启事务
		Transaction tx = session.beginTransaction();

		// --- 获取 (根据主键查询)
		Users users = (Users) session.get(Users.class, 1);
		
		System.out.println(users);

		// 6. 提交事务/关闭session
		tx.commit();
		session.close();

	}
}
