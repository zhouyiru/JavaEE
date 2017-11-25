package cn.itcast.d_di2;

public class UserDao implements IUserDao {
	// 模拟：保存对象
	public void save() {
		System.out.println("UserDao.save()");
	}
}
