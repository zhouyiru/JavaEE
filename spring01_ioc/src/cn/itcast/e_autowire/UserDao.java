package cn.itcast.e_autowire;

public class UserDao implements IUserDao {
	// 模拟：保存对象
	public void save() {
		System.out.println("UserDao.save()");
	}
}
