package gz.itcast.a_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 目的： 查看拦截器的生命周期
 * @author APPle
 *
 */
public class MyInterceptor1 implements Interceptor{
	
	public MyInterceptor1(){
		System.out.println("1)创建了拦截器1对象");
	}

	public void destroy() {
		System.out.println("拦截器对象1销毁了");
	}

	public void init() {
		System.out.println("2)调用了拦截器1的init方法");
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("4)拦截了拦截器1Action---前面的代码");
		
		//放行，调用下一个拦截器，如果没有下一个拦截器，那么调用目录的action
		invocation.invoke();
		
		System.out.println("6)拦截了拦截器1Action---后面的代码");
		
		return null;
	}

}
