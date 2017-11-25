package cn.itcast.e_aop_anno;

import org.springframework.stereotype.Repository;

@Repository			// 把对象加入ioc容器
public class UserDao implements IUserDao {
	
	public void save() {
		System.out.println("保存...");
	}
}



