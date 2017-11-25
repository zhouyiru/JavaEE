package cn.itcast.c_cglib;

public class App {

	public static void main(String[] args) {
		
		// 创建目标对象
		UserDao target = new UserDao();
		System.out.println("目标对象：" + target.getClass());  // class cn.itcast.c_cglib.UserDao
		
		// 代理对象
		UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
		System.out.println("代理对象： " + proxy.getClass());  //  class cn.itcast.c_cglib.UserDao$$EnhancerByCGLIB$$6ecf51fe
		
		// 执行代理对象的方法
		proxy.save();
	}
}
