package gz.itcast.e_metadata;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Demo2 {
	public static void main(String[] args) throws Exception {
		//t1();
		
		
		//insert();
		
		update();
	}
	/**
	 * �޸�
	 * @throws SQLException
	 */
	private static void update() throws SQLException {
		SQLUtil.update("update student set name=?,gender=? where id=?",
				new Object[]{"lily","��",3});
	}
	/**
	 * ����
	 * @throws SQLException
	 */
	private static void insert() throws SQLException {
		SQLUtil.update("insert into student(id,name,gender,scroe,birth) values(?,?,?,?,?)",
				new Object[]{3,"lucy","Ů",90.34,"2015-06-27"});
	}

	private static void t1() throws SQLException {
		/**
		 * ����Ԫ���ݣ�ParameterMetaData��
		 */
		ComboPooledDataSource ds = new ComboPooledDataSource();
		Connection conn = ds.getConnection();
		String sql = "insert into student(id,name,gender,scroe,birth) values(?,?,?,?,?)";
		
		//Ԥ����
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		//������ֵ
		/*stmt.setInt(1, 1);
		stmt.setString(2, "eric");
		stmt.setString(3, "��");
		stmt.setDouble(4, 87.65);
		stmt.setString(5, "2015-06-24");*/
		
		//֪��Ԥ�����sql�м�������
		//�õ�����Ԫ����
		ParameterMetaData pmd = stmt.getParameterMetaData();
		//�õ�sql���м�������
		int count = pmd.getParameterCount();
		
		//System.out.println(count);
		
		//���԰Ѳ���ֵ����������
		Object[] values = new Object[]{2,"jacky","Ů",90.23,"2015-06-25"};
		//�µĸ�ֵ��ʽ
		for(int i=1;i<=count;i++){
			//setObject���������κ����Ͳ���
			stmt.setObject(i, values[i-1]);
		}
		
		
			
		stmt.executeUpdate();
	}
}
