package gz.itcast.e_metadata;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class SQLUtil {

	/**
	 * ͨ�õĸ��·���
	 */
	public static void update(String sql,Object[] values){
		try {
			ComboPooledDataSource ds = new ComboPooledDataSource();
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ParameterMetaData pmd = stmt.getParameterMetaData();
			//�õ�sql���м�������
			int count = pmd.getParameterCount();
			
			//���԰Ѳ���ֵ����������
			//�µĸ�ֵ��ʽ
			for(int i=1;i<=count;i++){
				//setObject���������κ����Ͳ���
				stmt.setObject(i, values[i-1]);
			}
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ͨ�õĲ�ѯ����
	 */
	public static <T> List<T> query(String sql,Object[] values,Class<T> clazz){
		try {
			ComboPooledDataSource ds = new ComboPooledDataSource();
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ParameterMetaData pmd = stmt.getParameterMetaData();
			//�õ���������
			int paramCount = pmd.getParameterCount();
			//�����null���򲻸�ֵ��
			if(values!=null){
				//������ֵ
				for(int i=1;i<=paramCount;i++){
					stmt.setObject(i, values[i-1]);
				}
			}
			ResultSet rs = stmt.executeQuery();

			//����:�õ����м��У�ÿ���е�������ʲô
			//�õ��������Ԫ����
			ResultSetMetaData rsmd = rs.getMetaData();
			//�õ�������
			int columnCount = rsmd.getColumnCount();
			List list = new ArrayList();
			while(rs.next()){//��
				//ÿһ�����ݾ���һ������
				//�������
				Object obj = clazz.newInstance();
				//����ÿ��
				for(int i=1;i<=columnCount;i++){
					//�õ������ֵ
					Object value = rs.getObject(i);
					//ͨ�������Ԫ���ݿ��Եõ��ֶ�����
					String columnName = rsmd.getColumnName(i);
					//���е�ÿ�е�ֵ�ͷ�װ�������ÿ��������
					//Լ��һ��ǰ�᣺ ���е�ÿ���ֶ����ƺ�javabean�������������Ʊ���һ�£�������
					//��ֵ������javabean������
					BeanUtils.copyProperty(obj, columnName, value);
				}
				list.add(obj);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
