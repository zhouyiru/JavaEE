package cn.itcast.c_di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	@Test
	public void testApp() throws Exception {
		// 方式2： 会从当前类所在的包下找bean.xml  【测试方便】
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("bean.xml",this.getClass());
		
		User user = (User) ac.getBean("user");
		System.out.println(user);
	}
}
