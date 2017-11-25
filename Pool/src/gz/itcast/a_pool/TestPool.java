package gz.itcast.a_pool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * �������п��������ӳع���
 * @author APPle
 *
 */
public class TestPool {

	public static void main(String[] args) {
		//1)�������ӳض���
		MyPool myPool = new MyPool(); //��ʼ������
		//ģ���û�������ȡ����
		for(int i=1;i<=11;i++){
			Connection conn = myPool.getConnection(); //�����С�ڵ��ڳ�ʼ��������ʱ�򣬲���Ҫ����������ݿ�
			System.out.println(conn);
			
			if(i==3){
				//ģ���û��ͷ�����,�����ӷŻ����ӳ���(ע�⣺ʹ�������Ӷ���һ��Ҫ�ǵð����ӷŻ����ӳ��У��Թ������û�ʹ��)
				//myPool.releaseConnection(conn);
				
				//����û�����ʹ��Connection��close�������ͷ����ӣ�����ʲô���⣿
				
				/**
				 *  ����취�����û�����close()����Ҳ�ܹ��ɹ������Ӷ���Ż����ӳ���
				 *  	1)��̬�����ࡣ��дConnection��close����
				 *  	2)��̬�����ࡣ��дConnection��close����
				 */
				try {
					conn.close(); //��ʵ�����ǰ����ӷ������ӳء���������Ĺر����ӡ�
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		}
	}
}
