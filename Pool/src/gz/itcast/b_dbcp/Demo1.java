package gz.itcast.b_dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * ʹ��dbcp���ӳع���
 * @author APPle
 *
 */
public class Demo1 {
	private static String url = "jdbc:mysql://localhost:3306/day18";
	private static String user = "root";
	private static String password = "root";
	private static String driverClass = "com.mysql.jdbc.Driver";

	public static void main(String[] args) {
		//test1();

	
		/**
		 * ʹ�������ļ���ʽ
		 */
		//4)��ȡ����
		try {
			//1)ʹ�ù�����������dbcp���ӳض��󣨶�ȡ�����ļ���ʽ��
			Properties prop = new Properties();
			//ʹ����·����ȡ�����ļ�
			InputStream in = Demo1.class.getResourceAsStream("/jdbc.properties");
			//���������ļ�
			prop.load(in);

			BasicDataSource bds = (BasicDataSource)BasicDataSourceFactory.createDataSource(prop);
			/**
			 * ��ȡjdbc.properties�ļ�����
			 *   dbcp�����Զ�ʶ��ÿ��������Ϣ������Լ��ǰ�᣺ �����ļ���key���ƺ����÷��������Ʊ���һ�£�����
			 */
			
			//�����ӳ��л�ȡ����
			for(int i=1;i<=13;i++){
				Connection conn = bds.getConnection(); //ע�⣺ ���ﷵ�ص�Connection���󣬲���ԭ����Connection�����Ǵ�����Connection����
				System.out.println(conn);
				
				//ע�⣺ ʹ�����ӳأ���ס�ͷ�����
			/*	if(i==3){
					conn.close();// �����Ӷ���Ż����ӳ��еġ����ӳ�������ܹ�������������������Ӷ���
				}*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * û�������ļ�������
	 */
	private static void test1() {
		//1)����dbcp���ӳض���
		BasicDataSource bds = new BasicDataSource();
		
		//2)�������Ӳ���
		bds.setUrl(url);
		bds.setUsername(user);
		bds.setPassword(password);
		bds.setDriverClassName(driverClass);
		
		//3)�������ӳز���
		bds.setInitialSize(5);//��ʼ������
		bds.setMaxActive(10);//���������
		bds.setMaxWait(3000);//���������������ʱ�����ȴ�ʱ��Ϊ3��
		
		//4)��ȡ����
		try {
			//�����ӳ��л�ȡ����
			for(int i=1;i<=11;i++){
				Connection conn = bds.getConnection(); //ע�⣺ ���ﷵ�ص�Connection���󣬲���ԭ����Connection�����Ǵ�����Connection����
				System.out.println(conn);
				
				//ע�⣺ ʹ�����ӳأ���ס�ͷ�����
				if(i==3){
					conn.close();// �����Ӷ���Ż����ӳ��еġ����ӳ�������ܹ�������������������Ӷ���
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
