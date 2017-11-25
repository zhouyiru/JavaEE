package cn.itcast.d_my_aop2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	 private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml",getClass());
	
	@Test
	public void testApp() throws Exception {
		IUserDao userDao = (IUserDao) ac.getBean("userDaoProxy");
		userDao.save();
	}
}
