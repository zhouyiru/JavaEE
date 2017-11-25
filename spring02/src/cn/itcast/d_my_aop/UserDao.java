package cn.itcast.d_my_aop;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

/*
 *  1. 面向过程的分离
 *  2. 对象化分离
 */
@Repository			// 把对象加入ioc容器
public class UserDao {
	
	@Resource
	private TransactionAop aop;
	
	public void save() {
		aop.beginTransaction() ;
		System.out.println("保存...");
		aop.commit();
	}
}



