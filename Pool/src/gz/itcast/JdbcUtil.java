package gz.itcast;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ӳذ汾��jdbcUtil
 * @author APPle
 *
 */
public class JdbcUtil {
	//һ�����ݿ�ֻ��Ҫһ�����ӳض���
	private static DataSource ds  = new ComboPooledDataSource(); 
	
	/**
	 * ��ȡ���ӳض���ķ���
	 */
	public static DataSource getDataSource(){
		return ds;
	}
	
	/**
	 * ��ȡ���Ӷ���ķ���
	 */
	public static Connection getConnectio(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
