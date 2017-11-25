package cn.itcast.h_jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml",App.class);
	@Test
	public void testApp() throws Exception {
		IDeptDao deptDao = (IDeptDao) ac.getBean("deptDao");
//		deptDao.save(new Dept());
//		deptDao.delete(9);
		
//		Dept dept = new Dept();
//		dept.setId(3);
//		dept.setName("人事部");
//		deptDao.update(dept);
		
		// 查询方法
		Dept dept = deptDao.findById(1);
		System.out.println(dept);
		System.out.println(dept.getName());
		
//		System.out.println(deptDao.getAll());
	}
}
