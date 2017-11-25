package cn.itcast.a_status;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App_1_status {

	private static SessionFactory sf;
	static {
		sf = new Configuration()//
				.configure()//
				.buildSessionFactory();
	}
	
	// 保存
	@Test
	public void testSave() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 创建对象								【临时状态】
		Employee emp = new Employee();
		emp.setName("Rose");
		emp.setBirth(new Date());
		
		// 保存
		session.save(emp);					// 【持久化状态】
		emp.setName("Lucy..");				// 修改会反映到数据库中，所以这里会生成update语句
		
		session.getTransaction().commit();
		session.close();

		emp.setName("New Lucy");
		System.out.println(emp.getName());   // 此时对象处于【游离状态】
	}

	// 游离--> 持久
	@Test
	public void testStatus() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 游离状态 (手动模拟)
		Employee emp = new Employee();
		emp.setId(1);				// 【游离状态】
		
		session.update(emp);		// 持久化
		
		emp.setName("Test..");      // .. 修改反映到数据库
		
		session.getTransaction().commit();
		session.close();
		
		
	}
}







