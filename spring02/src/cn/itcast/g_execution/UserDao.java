package cn.itcast.g_execution;


public class UserDao implements IUserDao {
	
	@Override
	public void save() {
		System.out.println("保存...");
	}
	
	public void get() {
		System.out.println("获取...");
	}
	
}



