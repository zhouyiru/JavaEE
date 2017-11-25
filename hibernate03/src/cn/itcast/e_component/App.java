package cn.itcast.e_component;

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
			.addClass(Car.class)
			.buildSessionFactory();
	}
	
	@Test
	public void test_save() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 车轮
		Wheel wheel = new Wheel();
		wheel.setCount(4);
		wheel.setSize(37);
		
		// 汽车
		Car car = new Car();
		car.setType("BMW");
		
		// 关系
		car.setWheel(wheel);
		
		session.save(car);
		
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void test_get() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Car car = (Car) session.get(Car.class,1);
		System.out.println(car.getType());
		System.out.println(car.getWheel().getCount());
				
		
		session.getTransaction().commit();
		session.close();
	}
}












