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
    	    System.out.println("=======��ϵ�˹���ϵͳ======");
			System.out.println("[1]������ϵ��");
			System.out.println("[2]�޸���ϵ��");
			System.out.println("[3]ɾ����ϵ��");
			System.out.println("[4]��ѯ������ϵ��");
			System.out.println("[Q]�˳�����");
			System.out.println("======================");
			String command = br.readLine();
			if("1".equals(command)){
				Contact contact = new Contact();
				System.out.println("����������:");
				String name = br.readLine();
				System.out.println("�������Ա�:");
				String gender = br.readLine();
				System.out.println("������绰:");
				String phone = br.readLine();
				System.out.println("����������:");
				String email = br.readLine();
				System.out.println("�������ַ:");
				String address = br.readLine();
				
				//��װContact����
				contact.setName(name);
				contact.setGender(gender);
				contact.setEmail(email);
				contact.setPhone(phone);
				contact.setAddress(address);
				
				//������ϵ��
				operator.addContact(contact);
				
				System.out.println("��ӳɹ���");
			}else if("2".equals(command)){
				Contact contact = new Contact();
				
				System.out.println("�������޸ĵı��:");
				String id = br.readLine();
				System.out.println("�������޸ĺ������:");
				String name = br.readLine();
				System.out.println("�������޸ĺ���Ա�:");
				String gender = br.readLine();
				System.out.println("�������޸ĺ�ĵ绰:");
				String phone = br.readLine();
				System.out.println("�������޸ĺ������:");
				String email = br.readLine();
				System.out.println("�������޸ĺ�ĵ�ַ:");
				String address = br.readLine();
				
				//��װContact����
				contact.setId(id);
				contact.setName(name);
				contact.setGender(gender);
				contact.setEmail(email);
				contact.setPhone(phone);
				contact.setAddress(address);
				
				//�޸���ϵ��
				operator.updateContact(contact);
				
				System.out.println("�޸ĳɹ���");
			}else if("3".equals(command)){
				
				//ɾ����ϵ��
				System.out.println("������ɾ���ı��:");
				String id = br.readLine();
				
				operator.deleteContact(id);
				
				System.out.println("ɾ���ɹ���");
			}else if("4".equals(command)){
				//��ѯ������ϵ��
				List<Contact> list = operator.findAll();
				
				for (Contact contact : list) {
					System.out.println(contact);
				}
			}else if("Q".equals(command)){
				//�˳�����
				break;
			}
		}

	}

}

