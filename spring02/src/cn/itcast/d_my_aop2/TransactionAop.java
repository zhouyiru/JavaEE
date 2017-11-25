package cn.itcast.d_my_aop2;

import org.springframework.stereotype.Component;

// 重复代码
@Component("aop")
public class TransactionAop {

	public void beginTransaction() {
		System.out.println("开启事务..");
	}
	
	public void commit() {
		System.out.println("提交事务..");
	}

}
