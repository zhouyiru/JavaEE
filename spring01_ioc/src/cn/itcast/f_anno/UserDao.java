package cn.itcast.f_anno;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// 把userDao对象加入IOC容器

//@Component("userdao")  // <bean id=userDao class="...">
//@Repository("userdao")  // <bean id=userDao class="...">

@Repository   // 默认名称是类名，且第一个字母小写
public class UserDao implements IUserDao {
	// 模拟：保存对象
	public void save() {
		System.out.println("UserDao.save()");
	}
}
