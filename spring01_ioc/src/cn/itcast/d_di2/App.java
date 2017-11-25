package cn.itcast.d_di2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.c_di.User;

public class App {
	
	private ApplicationContext ac =
		new ClassPathXmlApplicationContext("bean.xml",App.class);

	@Test
	public void testApp() throws Exception {
		// 从容器中获取Action实例
		UserAction userAction = (UserAction) ac.getBean("userAction");
		// 执行方法
		userAction.execute();
		
		System.out.println("----------------");
		
		userAction = (UserAction) ac.getBean("userAction");
		userAction.execute();
	}
	
	// 测试p名称空间
	@Test
	public void testApp_p() throws Exception {
//		User user = (User) ac.getBean("user");
//		System.out.println(user);
		
		UserAction userAction = (UserAction) ac.getBean("userAction");
		userAction.execute();
	}
}
