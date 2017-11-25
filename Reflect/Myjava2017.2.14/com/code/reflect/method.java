package com.code.reflect;

import java.lang.reflect.Method;

/*
 通过Class对象获取成员函数。 ------》 Method类
 
 */
@SuppressWarnings("unused")
public class method {


	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		
		//获取所有的方法
/*		Method[] methods =  clazz.getMethods();  // 获取所有公共 的方法，包括继承下来的方法。
		Method[] methods = clazz.getDeclaredMethods(); //获取所有的方法，包括私有的，但是不包括继承下来的方法。 
		for(Method m : methods){
			System.out.println(m);
		}
*/	
		Person p =  new Person("狗娃",12);
		//获取单个方法
		/*Method m = clazz.getMethod("eat", int.class,String[].class) ; //第一个参数是方法名， 第二参数是形参列表的数据类型。
		//执行一个方法
		Person p =  new Person("狗娃",12);
		m.invoke(p, 3,new String[]{"aa","bb"}); //第一个参数：方法的调用者对象， 第二参数： 方法执行所需要的参数。
		
		
		Method m = clazz.getMethod("sleep", int.class);
		m.invoke(null, 23);
		
		//私有的方法
		*/
		
		/*Method m  = clazz.getDeclaredMethod("study", null);
		//设置方法的访问权限是可以访问
		m.setAccessible(true);
		m.invoke(p, null);*/
	}

}

