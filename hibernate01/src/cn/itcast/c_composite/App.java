package cn.itcast.c_composite;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {
	private static SessionFactory sf;
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}

	@Test
	public void testSave() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 联合主键对象
		CompositeKeys keys = new CompositeKeys();
		keys.setName("Jack");
		keys.setAddress("棠东...");
		
		// 对象
		Employee emp = new Employee();
		emp.setKeys(keys);
		emp.setDept("研发部");
		emp.setBirth(new Date());
		
		// 保存
		session.save(emp);
		
		
		session.getTransaction().commit();
		session.close();

	}
	
	@Test
	public void testGet() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 联合主键对象
		CompositeKeys keys = new CompositeKeys();
		keys.setName("Jack");
		keys.setAddress("棠东...");
		
		Employee employee = (Employee) session.get(Employee.class, keys);
		System.out.println(employee.getKeys().getName());
		System.out.println(employee.getKeys().getAddress());
		System.out.println(employee.getDept());
		System.out.println(employee.getBirth());
		
		session.getTransaction().commit();
		session.close();

	}
}
	

