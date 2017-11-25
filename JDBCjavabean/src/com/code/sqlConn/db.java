package com.code.sqlConn;
import java.sql.*;
public class db {
private static Connection cn=null;
private static Statement sm=null;

public static Connection getCn() {
	return cn;
}
public static Statement getSm() {
	return sm;
}

public static void CreateConnection(){
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		    //System.out.println("ok");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","admin");
			//System.out.println("ok");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
	     System.out.println("fail");
		e.printStackTrace();
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	}System.out.println("connection ok");
}
public static void CreateStatement(){
	try {
		cn=getCn();
		sm=cn.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}System.out.println("statement ok");
}

public static ResultSet Query(String SQL){
	sm=getSm();
	ResultSet rSet=null;
	System.out.println(SQL);
	try {
		rSet=sm.executeQuery(SQL);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rSet;
}
public static int Update(String SQL){
	sm=getSm();
	int num=0;
	System.out.println(SQL);
	try {
		num=sm.executeUpdate(SQL);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return num;
}
public static void close(){
	try {
		sm.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		cn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
