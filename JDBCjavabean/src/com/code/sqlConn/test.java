package com.code.sqlConn;

import java.sql.*;

public class test {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		db.CreateConnection();
		db.CreateStatement();
		String SQLString="select * from emp";
		ResultSet rs=db.Query(SQLString);
		try {
			while(rs.next()){
				System.out.println(rs.getInt("empno")+" "+rs.getString("ename")+" "+rs.getInt("sal"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   /*String SQLString="insert into dept values(11,'aa','sa')";
		   int num=db.Update(SQLString);
		   System.out.println(num);*/
	}

   
}
