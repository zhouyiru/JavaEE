package gz.itcast.b_ognl;

import ognl.Ognl;
import ognl.OgnlContext;

import org.junit.Test;
//目标： 学习了解Ognl表达式的核心对象OgnlContext对象的使用
public class OgnlDemo {

	@Test
	public void test1(){
		User user = new User();
		user.setName("eric");
		user.setAge(20);
			
		//1)创建一个OgnlContext对象
		OgnlContext context = new OgnlContext();	
		//2)把user对象存入OgnlContext对象
		context.put("user", user);
		//3)从OgnlContext对象取出数据
		User user2 = (User)context.get("user");
		System.out.println(user2.getName()+"\t"+user2.getAge());
	}
	
	//使用Ognl表达式取出OgnlContext的数据，如果是非根对象数据，那么使用#号去取
	@Test
	public void test2()throws Exception{
		User user = new User();
		user.setName("eric");
		user.setAge(20);
			
		//1)创建一个OgnlContext对象
		OgnlContext context = new OgnlContext();	
		//2)把user对象存入OgnlContext对象
		context.put("user", user);//往OgnlContext的非根对象 存数据
		
		//使用Ognl表达式从OgnlContext对象取出数据
		Object ognlObj = Ognl.parseExpression("#user.age");//表达式对象
		Object result = Ognl.getValue(ognlObj, context, context.getRoot()); //获取数据方法
		System.out.println(result);
		
		
	}
	
	//使用Ognl表达式取出OgnlContext的数据，如果是根对象数据，不需要使用#号，不需要key名称,直接写存入对象的属性即可！！！
	@Test
	public void test3()throws Exception{
		User user = new User();
		user.setName("eric");
		user.setAge(20);
			
		//1)创建一个OgnlContext对象
		OgnlContext context = new OgnlContext();	
		//2)把user对象存入OgnlContext对象
		context.setRoot(user);////往OgnlContext的根对象 存数据
		
		//使用Ognl表达式从OgnlContext对象取出数据
		Object ognlObj = Ognl.parseExpression("name");//表达式对象
		Object result = Ognl.getValue(ognlObj, context, context.getRoot()); //获取数据方法
		System.out.println(result);
		
		
	}
	
	/**
	 * java.util.Math
	 * @throws Exception
	 */
	//Ognl表达式调用静态方法
	@Test
	public void test4()throws Exception{
		//Math.round(10.3);
		
		//1)创建一个OgnlContext对象
		OgnlContext context = new OgnlContext();
		//使用Ognl表达式从OgnlContext对象取出数据
		Object ognlObj = Ognl.parseExpression("@Math@round(10.5)");//表达式对象
		Object result = Ognl.getValue(ognlObj, context, context.getRoot()); //获取数据方法
		System.out.println(result);
		
		
	}
	
	
	
}
