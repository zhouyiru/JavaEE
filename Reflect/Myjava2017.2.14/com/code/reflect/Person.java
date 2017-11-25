package com.code.reflect;

public class Person {

	String name;
	
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	

	public Person() {
	}
	
	public void eat(int num,String[] arr){
		System.out.println(name+"吃"+num+"斤米饭");
	}
	
	public static void sleep(int hours){
		System.out.println("睡"+hours+"小时");
	}
	
	@SuppressWarnings("unused")
	private void study(){
		System.out.println(name+"熬夜学习...");
	}
	
	@Override
	public String toString() {
		return "姓名："+ this.name+" 年龄："+this.age;
	}
	
}
