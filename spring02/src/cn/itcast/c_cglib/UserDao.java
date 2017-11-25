package cn.itcast.c_cglib;

// 目标对象
public class UserDao{
	
	public static void save() {
		System.out.println("模拟： 保存用户！");
	}

	public void find() {
		System.out.println("查询");
	}
}
