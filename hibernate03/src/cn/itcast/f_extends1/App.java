package cn.itcast.f_extends1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dog.class)
			.buildSessionFactory();
	}
	
	@Test
	public void test_save() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Dog dog = new Dog();
		dog.setName("花皮狗");
		dog.setPlay("接飞盘");
		
		// 保存
		session.save(dog);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void test_get() {
		Session session = sf.openSession();
		session.beginTransaction();
		
//		Dog dog = (Dog) session.get(Dog.class, 1);
//		System.out.println(dog.getName());
		
//		Animal dog = (Animal) session.get(Dog.class, 1);
//		System.out.println(dog.getName());
		
//		List list = session.createQuery("from Dog").list();
//		System.out.println(list);
		
		// 注意：在继承关系中，如果hql语句是通过父类查找，需要指定全名
		List list = session.createQuery("from cn.itcast.f_extends1.Animal").list();
		System.out.println(list);
		
		session.getTransaction().commit();
		session.close();
	}	
}












