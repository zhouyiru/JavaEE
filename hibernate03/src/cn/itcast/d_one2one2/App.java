package cn.itcast.d_one2one2;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(User.class)
			.addClass(IdCard.class)
			.buildSessionFactory();
	}
	
	@Test
	public void test_save() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 对象
		User user = new User();
		user.setName("Jack");
		user.setSex('男');
		
		IdCard idCard = new IdCard();
		idCard.setCardNo("5412...");
		idCard.setPlace("广州");
		idCard.setDate(new Date());
		
		// 关系
		user.setIdCard(idCard);
		
		// 保存
		session.save(idCard);
		session.save(user);
		
		
		session.getTransaction().commit();
		session.close();
	}
}












