package gz.itcast.e_metadata;

import gz.itcast.d_beanutils.Student;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Demo3 {
	public static void main(String[] args) throws Exception {
		//t1();
		
		/**
		 * ���� ����һ����ѯ��sql��䣬���ض�Ӧ��List����
		 */
		List<Student> list = SQLUtil.query("select * from student",null,Student.class);
		for (Student student : list) {
			System.out.println(student);
		}
	}

	private static void t1() throws SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		Connection conn = ds.getConnection();
		
		String sql = "select * from student";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ParameterMetaData pmd = stmt.getParameterMetaData();
		//�õ���������
		int paramCount = pmd.getParameterCount();
		//Object[] values = new Object[]{1};
		Object[] values = null;
		if(values!=null){
			//������ֵ
			for(int i=1;i<=paramCount;i++){
				stmt.setObject(i, values[i-1]);
			}
		}
		ResultSet rs = stmt.executeQuery();
		
		//���������
		/*while(rs.next()){// ��
			//�õ���ֵ
			int id = rs.getInt(1);
			String name = rs.getString(2);
			System.out.println(id+"\t"+name);
		}*/
		
		//����:�õ����м��У�ÿ���е�������ʲô
		//�õ��������Ԫ����
		ResultSetMetaData rsmd = rs.getMetaData();
		//�õ�������
		int columnCount = rsmd.getColumnCount();
		
		while(rs.next()){//��
			//����ÿ��
			for(int i=1;i<=columnCount;i++){
				Object value = rs.getObject(i);
				System.out.print(value+"\t");
			}
			System.out.println();
		}
	}
}
