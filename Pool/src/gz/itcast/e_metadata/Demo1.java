package gz.itcast.e_metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ݿ�Ԫ����
 * @author APPle
 *
 */
public class Demo1 {

	public static void main(String[] args) throws Exception {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		
		Connection conn = ds.getConnection();
		
		//System.out.println(conn);
		
		/**
		 * ʹ�����ݿ�Ԫ���ݣ�DatabaseMetaData��
		 */
		DatabaseMetaData dbmd = conn.getMetaData();
		
		//ָ���ĸ����ݿ�
		System.out.println(dbmd.getDatabaseProductName());
		
		//���ݿ�汾
		System.out.println(dbmd.getDatabaseMajorVersion());
		System.out.println(dbmd.getDatabaseMinorVersion());
		
		
		//ʹ����������İ汾
		System.out.println(dbmd.getDriverMajorVersion());
		System.out.println(dbmd.getDriverMinorVersion());
	}
}
