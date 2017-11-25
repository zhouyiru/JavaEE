package junit.test;

import org.junit.Test;


import cn.itcast.action.UserAction;

public class App {

	//不从IOC获取对象
	@Test
	public void testApp() throws Exception {
		UserAction userAction = new UserAction();
		userAction.execute();
	}
	
	// 从IOC容器获取对象
	@Test
	public void testApp2() throws Exception {
		// 容器对象(加载applicationContext.xml配置文件)
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取对象
		UserAction userAction = (UserAction) ac.getBean("userAction");
		userAction.execute();
	}
}





