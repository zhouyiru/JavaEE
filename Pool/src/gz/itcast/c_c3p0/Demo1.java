package gz.itcast.c_c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ʹ��c3p0���ӳ�
 * @author APPle
 *
 */
public class Demo1 {
	private static String url = "jdbc:mysql://localhost:3306/day18";
	private static String user = "root";
	private static String password = "root";
	private static String driverClass = "com.mysql.jdbc.Driver";


	public static void main(String[] args) throws Exception {
		//test1();
		
		
		/**
		 * ʹ��xml�����ļ���ȡc3p0�ķ���
		 * 	ע�⣺
		 * 		1����Ҫ��һ������Ϊc3p0-config.xml�ļ�����srcĿ¼�£�c3p0���Զ���ȡ����ļ���
		 * 		2)xml�����ļ����������ƺ��ֶ����÷���������һ�£�������c3p0����Զ���ȡ
		 */
		
		//1)�������ӳض���
		
		/**
		 *   1)new ComboPooledDataSource(): ʹ��û�в����Ĺ��췽������ȡ����default-config��������Ϣ
		 *   2)new ComboPooledDataSource(name������ֵ)�� ʹ���вεĹ��췽������ȡ����name-config������Ϣ
		 */
		//ComboPooledDataSource cds = new ComboPooledDataSource();
		ComboPooledDataSource cds = new ComboPooledDataSource("oracle");
		
		//2)��ȡ����
		for(int i=1;i<=13;i++){
			Connection conn = cds.getConnection();
			System.out.println(conn);
			
			//�رյ�3��
			if(i==3){
				conn.close();//�����ǰ����Ӷ���Ż����ӳ���
			}
		}
	}

	/**
	 * û�������ļ��ķ�ʽ
	 * @throws PropertyVetoException
	 * @throws SQLException
	 */
	private static void test1() throws PropertyVetoException, SQLException {
		//1)�������ӳض���
		ComboPooledDataSource cds = new ComboPooledDataSource();
		
		//2)�������Ӳ���
		cds.setJdbcUrl(url);
		cds.setUser(user);
		cds.setPassword(password);
		cds.setDriverClass(driverClass);
		
		//3)�������ӳ���صĲ���
		cds.setInitialPoolSize(5);//��ʼ��������
		cds.setMaxPoolSize(10);//���������
		cds.setCheckoutTimeout(3000);//���ȴ�ʱ��
		cds.setMinPoolSize(3); //��С������
		
		//4)��ȡ����
		for(int i=1;i<=11;i++){
			Connection conn = cds.getConnection();
			System.out.println(conn);
			
			//�رյ�3��
			if(i==3){
				conn.close();//�����ǰ����Ӷ���Ż����ӳ���
			}
		}
	}
}
