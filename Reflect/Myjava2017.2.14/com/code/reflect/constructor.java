package com.code.reflect;


import java.lang.reflect.Constructor;

/*
通过Class对象获取构造方法

Constructor 该类是用于表述一个构造方法的。

 */
@SuppressWarnings("unused")
public class constructor {

	

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		Class clazz = 	Class.forName("cn.itcast.reflect.Person");
		//通过class对象找到所有的构造方法。
		
		/*
		Constructor[] constructors = clazz1.getConstructors();  //只获取了公共的构造方法。
		Constructor[] constructors  =	clazz1.getDeclaredConstructors();  //获取一个类 的所有构造方法，包括似有的。
		for(Constructor constructor : constructors){
			System.out.println(constructor);
		}
		
		//获取单个构造方法
	
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		//通过Constructor对象创建对象。
		Person  p = (Person) constructor.newInstance("狗娃",12);
		System.out.println(p);
		
		// 获取私有的构造函数
		*/
		/*Constructor constructor = clazz.getDeclaredConstructor(null);
		//设置构造方法的访问权限（暴力反射）
		constructor.setAccessible(true);
		Person p = (Person)	constructor.newInstance(null);
		System.out.println(p);*/
		
		
	}
	
}

