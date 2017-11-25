package cn.itcast.b_dynamic;

public class App {

	public static void main(String[] args) {
		
		// 创建目标对象
		IUserDao target = new UserDao();
		System.out.println("目标对象：" + target.getClass());  // class cn.itcast.b_dynamic.UserDao
		
		// 代理对象
		IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
		System.out.println("代理对象： " + proxy.getClass());  //  class $Proxy0
		
		// 执行代理对象的方法
		proxy.find();
	}
}
