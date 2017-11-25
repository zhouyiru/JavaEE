package cn.itcast.a_config;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	
	@Test
	public void testApp() throws Exception {
		// 创建容器对象
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/a_config/bean.xml");
		System.out.println("----------");
		// 获取/创建对象
		User user = (User) ac.getBean("user");
		User user2 = (User) ac.getBean("user");
		
		// 销毁容器实例
		ac.destroy();
	}
}
