package com.code.reflect;

import java.lang.reflect.Field;

/*
 通过Class对象获取一个类的成员变量------- Field

 */
public class field {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		//获取该类的所有成员变量
		/*Field[]	 fields = clazz.getDeclaredFields();
		for(Field field : fields){
			System.out.println(field);
		}
		
*/	
		Person p = new Person("狗剩",12);
		Field nameField = clazz.getDeclaredField("name");
		nameField.set(p, "铁蛋");  // 第一个参数： 对象， 第二参数：成员变量的值。
		System.out.println(p);
	}
}
