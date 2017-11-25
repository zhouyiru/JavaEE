package com.code.reflect;

/*
反射这么技术在做一些比较通用的工具类的开发的时候，就非常有用了。

 反射： 当一个class文件被加载到内存中的时候，那么jvm就会马上对该class文件的成员进行解剖，然后将class文件的成员数据封装到一个Class对象中
 ，我们如果可以获取到Class对象，那么我们就可以通过该Class对象来操作该类的所有成员。
 
注意：在反射技术中一个类的任何成员都使用了一个类来描述。
 
Class对象的获取方式： 
 
 推荐使用： 第一种。通过Class.forName获取Class对象.
 
 */
public class class_ {
	
	Person p ; 
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		//方式1：通过Class.forName获取Class对象.
		
		Class clazz1 = 	Class.forName("cn.itcast.reflect.Person");
//		System.out.println("clazz1:"+clazz1.getSimpleName());
		
		//方式2：可以通过类名获取Class对象。
		Class clazz2 = Person.class;
		System.out.println("是同一个对象吗？"+(clazz1==clazz2));
		
		//方式3： 可以通过对象获取Class对象
	/*	Class clazz3 = new Person().getClass();
		System.out.println("是同一个对象吗："+ (clazz2 == clazz3));
		*/
	}

}

