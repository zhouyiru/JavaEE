package cn.itcast.f_aop_xml;

import org.aspectj.lang.ProceedingJoinPoint;

// 切面类
public class TransactionAop {
	
	public void beginTransaction() {
		System.out.println("[前置通知]  开启事务..");
	}
	
	public void commit() {
		System.out.println("[后置通知] 提交事务..");
	}
	
	public void afterReturing(){
		System.out.println("[返回后通知]");
	}
	
	public void afterThrowing(){
		System.out.println("[异常通知]");
	}
	
	public void arroud(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[环绕前：]");
		pjp.proceed();    			   // 执行目标方法
		System.out.println("[环绕后：]");
	}

}








