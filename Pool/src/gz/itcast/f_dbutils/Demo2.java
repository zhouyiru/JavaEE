package gz.itcast.f_dbutils;

import gz.itcast.JdbcUtil;
import gz.itcast.d_beanutils.Student;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * ʹ��dbUtilsִ�в�ѯ����
 * @author APPle
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		
		/**
		 * ResultSetHandler�ӿ�: ���ڰѽ������װ�ɲ�ͬ���͵Ķ���
		 * 	ArrayHandler��: �ѽ�����ĵ�һ�н����װ�ɶ������� 
		 * 	ArrayListHandler�ࣺ �ѽ������ÿһ�н����װ�ɶ������飬��ÿ�������������List������
		 *  BeanHandler�ࣺ �ѽ�����ĵ�һ�У���װ��javabean����(����)
		 *  BeanListHandler�ࣺ �ѽ������ÿ�з�װ��javabean����ÿ��javabean����List�����У����ã�
		 *  ScalarHandler�ࣺ��ѯ�ۺϺ���(����:count(*))  (����)
		 */
		//t1(qr);
		
		
		//t2(qr);
		
		//t3(qr);

		//t4(qr);
		
		try {
			long count = (Long)qr.query("select count(*) from student", new ScalarHandler(), new Object[]{});
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void t4(QueryRunner qr) {
		try {
			List<Student> stu= (List<Student>)qr.query("select * from student", new BeanListHandler(Student.class), new Object[]{});
			for (Student student : stu) {
				System.out.println(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void t3(QueryRunner qr) {
		try {
			Student stu= (Student)qr.query("select * from student where id=?", new BeanHandler(Student.class), new Object[]{1});
			System.out.println(stu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void t2(QueryRunner qr) {
		try {
			List<Object[]> values = (List<Object[]>)qr.query("select * from student", new ArrayListHandler(), new Object[]{});
			for (Object[] arr : values) {//��
				for (Object object : arr) {
					System.out.print(object+"\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void t1(QueryRunner qr) {
		try {
			Object[] values = (Object[])qr.query("select * from student", new ArrayHandler(), new Object[]{});
			for (Object object : values) {
				System.out.println(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
