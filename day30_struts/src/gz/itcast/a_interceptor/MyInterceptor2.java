package gz.itcast.a_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 目的： 有了多个拦截器时候，拦截器如何执行？？？？
 * @author APPle
 *
 */
public class MyInterceptor2 implements Interceptor{
	
	public MyInterceptor2(){
		System.out.println("1)创建了拦截器2对象");
	}

	public void destroy() {
		System.out.println("拦截器对象2销毁了");
	}

	public void init() {
		System.out.println("2)调用了拦截器2的init方法");
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("4)拦截了拦截器2Action---前面的代码");
		
		//放行，调用下一个拦截器，如果没有下一个拦截器，那么调用目录的action
		invocation.invoke();
		
		System.out.println("6)拦截了拦截器2Action---后面的代码");
		
		return null;
	}

}
