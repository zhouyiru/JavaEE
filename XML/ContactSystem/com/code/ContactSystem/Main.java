package com.code.ContactSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       ContactOperator operator = new ContactOperator();
       while(true){
    	    System.out.println("=======联系人管理系统======");
			System.out.println("[1]增加联系人");
			System.out.println("[2]修改联系人");
			System.out.println("[3]删除联系人");
			System.out.println("[4]查询所有联系人");
			System.out.println("[Q]退出程序");
			System.out.println("======================");
			String command = br.readLine();
			if("1".equals(command)){
				Contact contact = new Contact();
				System.out.println("请输入姓名:");
				String name = br.readLine();
				System.out.println("请输入性别:");
				String gender = br.readLine();
				System.out.println("请输入电话:");
				String phone = br.readLine();
				System.out.println("请输入邮箱:");
				String email = br.readLine();
				System.out.println("请输入地址:");
				String address = br.readLine();
				
				//封装Contact对象
				contact.setName(name);
				contact.setGender(gender);
				contact.setEmail(email);
				contact.setPhone(phone);
				contact.setAddress(address);
				
				//增加联系人
				operator.addContact(contact);
				
				System.out.println("添加成功！");
			}else if("2".equals(command)){
				Contact contact = new Contact();
				
				System.out.println("请输入修改的编号:");
				String id = br.readLine();
				System.out.println("请输入修改后的姓名:");
				String name = br.readLine();
				System.out.println("请输入修改后的性别:");
				String gender = br.readLine();
				System.out.println("请输入修改后的电话:");
				String phone = br.readLine();
				System.out.println("请输入修改后的邮箱:");
				String email = br.readLine();
				System.out.println("请输入修改后的地址:");
				String address = br.readLine();
				
				//封装Contact对象
				contact.setId(id);
				contact.setName(name);
				contact.setGender(gender);
				contact.setEmail(email);
				contact.setPhone(phone);
				contact.setAddress(address);
				
				//修改联系人
				operator.updateContact(contact);
				
				System.out.println("修改成功！");
			}else if("3".equals(command)){
				
				//删除联系人
				System.out.println("请输入删除的编号:");
				String id = br.readLine();
				
				operator.deleteContact(id);
				
				System.out.println("删除成功！");
			}else if("4".equals(command)){
				//查询所有联系人
				List<Contact> list = operator.findAll();
				
				for (Contact contact : list) {
					System.out.println(contact);
				}
			}else if("Q".equals(command)){
				//退出程序
				break;
			}
		}

	}

}

