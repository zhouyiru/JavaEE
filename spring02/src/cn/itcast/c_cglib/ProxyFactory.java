package cn.itcast.c_cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * cglib代理：
 *    代理工厂，给多个目标对象生成代理对象！
 * @author AdminTH
 *
 */
public class ProxyFactory implements MethodInterceptor{

	// 接收一个目标对象
	private Object target;
	public ProxyFactory(Object target) {
		this.target = target;
	}
	
	// 返回目标对象代理后的子类对象
	public Object getProxyInstance() {
		// 对target生成子类对象
		
		// 字节码生成工具类
		Enhancer en = new Enhancer();
		// 设置父类
		en.setSuperclass(target.getClass());
		// 设置回调函数
		en.setCallback(this);
		// 创建子类对象
		return en.create();
		
	}
	
	
	// 事件处理器，执行目标方法时候触发
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		System.out.println("开启事务...");
		Object result = method.invoke(target, args);
		System.out.println("提交事务...");
		return result;
	}
	
	
}







