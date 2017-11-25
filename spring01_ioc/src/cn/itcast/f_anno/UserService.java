package cn.itcast.f_anno;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


//@Component("userService")  // 把当前类加入IOC容器
//@Service("userService")  // 把当前类加入IOC容器

@Service
public class UserService implements IUserService {
	
	//@Resource(name = "userDao")   // 根据”userDao“去ioc容器找对象，找到后注入到当前方法参数
	
	@Resource		// 默认会根据private IUserDao userDao 这里的名称去容器找； 如果没有找到，再根据类型找，再没有找到就报错！
	private IUserDao userDao;

	public void save() {
		userDao.save();
	}
}
