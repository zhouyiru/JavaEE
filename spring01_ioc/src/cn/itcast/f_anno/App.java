package cn.itcast.f_anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.c_di.User;

public class App {
	
	private ApplicationContext ac =
		new ClassPathXmlApplicationContext("bean.xml",App.class);

	
	// 自动装配
	@Test
	public void testApp_auto() throws Exception {
		
		UserAction userAction = (UserAction) ac.getBean("userAction");
		userAction.execute();
	}
}
