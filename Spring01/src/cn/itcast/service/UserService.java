package cn.itcast.service;

import cn.itcast.dao.UserDao;

public class UserService {
	// 创建dao对象 : 单例，启动创建
	private UserDao userDao ;//= new UserDao();
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void save() {
		userDao.save();
	}
}
