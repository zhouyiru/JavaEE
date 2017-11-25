package cn.itcast.h_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

public class DeptDao_2 {
	
	// 接收容器注入的DataSource对象
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// 1. 原始jdbc代码
	public void save(Dept dept) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into t_dept(deptName) values('test')");
		pstmt.executeUpdate();
		// 关闭
		pstmt.close();
		con.close();
	}
}














