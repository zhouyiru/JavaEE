package cn.itcast.g_execution;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private ApplicationContext ac = new ClassPathXmlApplicationContext(
			"applicationContext.xml", getClass());

	@Test
	public void testApp() throws Exception {
		// springIOC容器中获取对象，用接口接收！
		IUserDao userDao = (IUserDao) ac.getBean("userDao");
		System.out.println(userDao.getClass());
		userDao.save();
		//userDao.get();
		
		OrderDao orderDao = (OrderDao) ac.getBean("orderDao");
		orderDao.save();
		
	}
}
