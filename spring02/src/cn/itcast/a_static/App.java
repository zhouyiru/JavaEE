package cn.itcast.a_static;

public class App {

	public static void main(String[] args) {
		// 代理对象
		IUserDao proxy = new UserDaoProxy();
		// 执行代理方法
		proxy.save();
		 
	}
}
