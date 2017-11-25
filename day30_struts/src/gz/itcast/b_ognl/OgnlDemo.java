package gz.itcast.b_ognl;

import ognl.Ognl;
import ognl.OgnlContext;

import org.junit.Test;
//Ŀ�꣺ ѧϰ�˽�Ognl���ʽ�ĺ��Ķ���OgnlContext�����ʹ��
public class OgnlDemo {

	@Test
	public void test1(){
		User user = new User();
		user.setName("eric");
		user.setAge(20);
			
		//1)����һ��OgnlContext����
		OgnlContext context = new OgnlContext();	
		//2)��user�������OgnlContext����
		context.put("user", user);
		//3)��OgnlContext����ȡ������
		User user2 = (User)context.get("user");
		System.out.println(user2.getName()+"\t"+user2.getAge());
	}
	
	//ʹ��Ognl���ʽȡ��OgnlContext�����ݣ�����ǷǸ��������ݣ���ôʹ��#��ȥȡ
	@Test
	public void test2()throws Exception{
		User user = new User();
		user.setName("eric");
		user.setAge(20);
			
		//1)����һ��OgnlContext����
		OgnlContext context = new OgnlContext();	
		//2)��user�������OgnlContext����
		context.put("user", user);//��OgnlContext�ķǸ����� ������
		
		//ʹ��Ognl���ʽ��OgnlContext����ȡ������
		Object ognlObj = Ognl.parseExpression("#user.age");//���ʽ����
		Object result = Ognl.getValue(ognlObj, context, context.getRoot()); //��ȡ���ݷ���
		System.out.println(result);
		
		
	}
	
	//ʹ��Ognl���ʽȡ��OgnlContext�����ݣ�����Ǹ��������ݣ�����Ҫʹ��#�ţ�����Ҫkey����,ֱ��д�����������Լ��ɣ�����
	@Test
	public void test3()throws Exception{
		User user = new User();
		user.setName("eric");
		user.setAge(20);
			
		//1)����һ��OgnlContext����
		OgnlContext context = new OgnlContext();	
		//2)��user�������OgnlContext����
		context.setRoot(user);////��OgnlContext�ĸ����� ������
		
		//ʹ��Ognl���ʽ��OgnlContext����ȡ������
		Object ognlObj = Ognl.parseExpression("name");//���ʽ����
		Object result = Ognl.getValue(ognlObj, context, context.getRoot()); //��ȡ���ݷ���
		System.out.println(result);
		
		
	}
	
	/**
	 * java.util.Math
	 * @throws Exception
	 */
	//Ognl���ʽ���þ�̬����
	@Test
	public void test4()throws Exception{
		//Math.round(10.3);
		
		//1)����һ��OgnlContext����
		OgnlContext context = new OgnlContext();
		//ʹ��Ognl���ʽ��OgnlContext����ȡ������
		Object ognlObj = Ognl.parseExpression("@Math@round(10.5)");//���ʽ����
		Object result = Ognl.getValue(ognlObj, context, context.getRoot()); //��ȡ���ݷ���
		System.out.println(result);
		
		
	}
	
	
	
}
