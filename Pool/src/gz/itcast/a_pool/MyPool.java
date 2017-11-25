package gz.itcast.a_pool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * �������һ�����ӳ�
 * @author APPle
 *
 */
public class MyPool {
	private static String url = "jdbc:mysql://localhost:3306/day18";
	private static String user = "root";
	private static String password = "root";
	private static String driverClass = "com.mysql.jdbc.Driver";

	//�洢���Ӷ��������
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	
	public static LinkedList<Connection> getPool() {
		return pool;
	}

	public static void setPool(LinkedList<Connection> pool) {
		MyPool.pool = pool;
	}


	//���ӳصĳ�ʼ��������
	private int initCount = 5;
	//���ӳص����������
	private int maxCount = 10;
	//���ڼ�¼��ǰ��������
	private int currentCount = 0;
	
	static{
		//ע������
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public MyPool(){
		//��ȡ����,��ʼ�����Ӷ���
		for(int i=1;i<=initCount;i++){
			pool.addLast(createConnection());
			currentCount++;
		}
	}
	
	//�������ӵķ���
	private Connection createConnection(){
		final Connection conn;
		try {
			//ԭ������ʵ�����Ӷ���
			conn = DriverManager.getConnection(url, user, password);
			
			//1)ʹ�þ�̬������ķ�ʽȥ����Connection�Ĵ�����
			//MyConnection myConn = new MyConnection(this,conn);
			
			//2)ʹ�ö�̬������ķ�ʽȥ����Connection�Ĵ�����
			/**
			 *  ʹ�õ�jdk��api��  Proxy��
			 *  		���ڴ�����̬���������
			 *  		static Object newProxyInstance(
			 *  						ClassLoader loader,
			 *   						Class<?>[] interfaces, 
			 *   						InvocationHandler h
			 *   						)  
			 * 			����һ�����������
			 * 			�������� ������ʵ�ֵĽӿ��б�
			 * 			�������� �ӿ� InvocationHandler�� ������ĵ��ô������Ľӿڡ���������������֮�󣬶����еķ�����δ���������
			 * 					Object invoke(
			 * 						Object proxy,  ���������      
			 * 						Method method,  �����������õķ����� 
			 * 						Object[] args  ���ô�������󷽷�ʱ����Ĳ����б�
			 * 					)   
			 * 							 
			 * 		
			 * 
			 */
			Connection myConn = (Connection)Proxy.newProxyInstance(
							MyPool.class.getClassLoader(), 
							new Class[]{Connection.class},
							new InvocationHandler(){
	
								@Override
								public Object invoke(Object proxy, Method method,
										Object[] args) throws Throwable {
									//1)��д��Ҫ��д�ķ�����close����
									//��ȡ��ǰ���õķ����ķ�������
									String methodName = method.getName();
									if("close".equals(methodName)){
										MyPool.getPool().addLast(conn);
										return null;
									}else{
										//2)���û�ԭ���ķ�������ȡ����ֵ
										Object value = method.invoke(conn, args);
										//���ؽ��
										return value;
									}
								}
						    }
						);
			
			return myConn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}
	
	/**
	 * �����ṩ��java����һ����ȡ���ӵķ���
	 */
	public Connection getConnection(){
		//1��������������С�ڵ��ڳ�ʼ������������ʱ�򣬲Ŵӳ���ȡ��
		if(pool.size()>0){
			System.out.println("1)======");
			//��������ȡ��һ�����Ӷ��󷵻ظ�java����
			return pool.removeFirst();
		}
		
		//2)����������������ʼ���������ݵ�ʱ�򣬳������л�ȡ�����Ӷ���.����һ�������������������ʱ�򣬲��ܻ�ȡ
		if(currentCount<maxCount){
			System.out.println("2)=====");
			currentCount++;
			return createConnection();
		}
		
		//3)�����������������ʱ�������ٻ�ȡ�����ˡ�
		throw new RuntimeException("�Ѿ����������������");
	}
	
	
	/**
	 * �����ṩ�ͷ����Ӷ���ķ���
	 */
	public void releaseConnection(Connection conn){
		//�Ż����ӳ�������
		pool.addLast(conn);
	}	
}
