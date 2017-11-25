package cn.itcast.h_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeptDao_1 {

	// 1. 原始jdbc代码
	public void save(Dept dept) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:///hib_demo","root","root");
		PreparedStatement pstmt = con.prepareStatement("insert into t_dept(deptName) values('test')");
		pstmt.executeUpdate();
		// 关闭
		pstmt.close();
		con.close();
	}
}














