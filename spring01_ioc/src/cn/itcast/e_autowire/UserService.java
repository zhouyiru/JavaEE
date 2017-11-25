package cn.itcast.e_autowire;


public class UserService implements IUserService {
	private IUserDao userDao ;
	// 接收IOC容器注入值
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void save() {
		userDao.save();
	}
}
