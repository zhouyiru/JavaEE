package gz.itcast.a_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * Ŀ�ģ� ���˶��������ʱ�����������ִ�У�������
 * @author APPle
 *
 */
public class MyInterceptor2 implements Interceptor{
	
	public MyInterceptor2(){
		System.out.println("1)������������2����");
	}

	public void destroy() {
		System.out.println("����������2������");
	}

	public void init() {
		System.out.println("2)������������2��init����");
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("4)������������2Action---ǰ��Ĵ���");
		
		//���У�������һ�������������û����һ������������ô����Ŀ¼��action
		invocation.invoke();
		
		System.out.println("6)������������2Action---����Ĵ���");
		
		return null;
	}

}
