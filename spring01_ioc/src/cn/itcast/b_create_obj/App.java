package cn.itcast.b_create_obj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	@Test
	public void testApp() throws Exception {
		// 方式1：创建容器对象
//		ClassPathXmlApplicationContext ac = 
//			new ClassPathXmlApplicationContext("cn/itcast/b_create_obj/bean.xml");
		
		// 方式2： 会从当前类所在的包下找bean.xml  【测试方便】
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("bean2.xml",this.getClass());
		
		// 获取容器中字符串
//		String str = (String) ac.getBean("str");
//		System.out.println(str);
		
		User user = (User) ac.getBean("user");
		System.out.println(user);
	}
}
