package gz.itcast.f_dbutils;

import java.sql.SQLException;

import gz.itcast.JdbcUtil;

import org.apache.commons.dbutils.QueryRunner;

public class Demo1 {

	public static void main(String[] args) {
		/*
		 * DateSource�ӿ���jdbc�Ľӿڣ�ͳһһ�����е��������ӳع��߻�ȡ���ӵķ�����
		 */
		//1������QueryRunner
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		
		//2)ִ�и���
		try {
			qr.update("insert into student(id,name,gender) values(?,?,?)", new Object[]{5,"����","��"});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
