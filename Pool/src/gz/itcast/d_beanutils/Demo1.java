package gz.itcast.d_beanutils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

/**
 * ʹ��beanutils���߲���javabean
 * @author APPle
 *
 */
public class Demo1 {
	public static void main(String[] args) throws Exception {
		//t1();	
		
		//t2();
		
		/**
		 * 3)��һ��map�����п�����һ��javabean��
		 * ע�⣺ 
		 * 	1��ֻ����javabean���ڵ���Щ����(setXXX����)
		 *  2)��Ҫ�������������������ͣ���ôֻ���������еĵ�һ��Ԫ�ء�
		 *
		 */
		ConvertUtils.register(new DateLocaleConverter(), java.util.Date.class);
		Map map = new HashMap();
		//map.put("name", "jacky");
		map.put("name", new String[]{"jacky","eric"});//�ַ�������
		map.put("id", "4");
		map.put("gender", "true");
		map.put("scroe", "86.43");
		map.put("birth","2015-06-05");
		
		Object s2 = Class.forName("gz.itcast.d_beanutils.Student").newInstance();
		
		//��һ��map�����ݿ�����s2��
		BeanUtils.copyProperties(s2, map);
		
		System.out.println(s2);
		
	}

	private static void t2() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InvocationTargetException {
		/**
		 * 2)��һ��javabean���󿽱�����һ��javabean����
		 *
		 */
		Student s = new Student();
		s.setId(1);
		s.setName("eric");
		s.setScroe(87.23);
		s.setGender(true);
		s.setBirth(new Date());
		
		
		Object s2 = Class.forName("gz.itcast.d_beanutils.Student").newInstance();
		
		//��s���󿽱���s2������
		/**
		 * ����һ���������Ķ���
		 * �������� ԭ���Ķ��� 
		 */
		BeanUtils.copyProperties(s2, s);
		
		System.out.println(s2);
	}

	private static void t1() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InvocationTargetException {
		/**
		 * 1)����һ��javabean���������
		 */
		Student s = new Student();
		s.setId(1);
		s.setName("eric");
		s.setScroe(87.23);
		s.setGender(true);
		s.setBirth(new Date());
		
		
		//Student s2 = new Student();
		/**
		 * ͨ�����乹�����
		 */
		Object s2 = Class.forName("gz.itcast.d_beanutils.Student").newInstance();
		
		//1)��id��name����ֵ��s���󿽱���s2�Ķ�����
		/**
		 * ����һ�� �������Ķ���
		 * �������� ����������
		 * �������� ������ֵ
		 */
		//s2.setId(s.getId());
		/*BeanUtils.copyProperty(s2, "id", s.getId()); //����Ҫ����Student����
		BeanUtils.copyProperty(s2, "name", "jacky");
		BeanUtils.copyProperty(s2, "gender", true);
		BeanUtils.copyProperty(s2, "scroe", 90.23); 
		BeanUtils.copyProperty(s2, "birth", new Date()); */
		
		/**
		 * ע�⣺
		 * 	1�������ķ����ܹ��Զ�����String������ת����Ӧ�����͵�����.���� ��  "2"��String�� -�� int(String->int)  "97.23"(String) -> double (String->double)
		 *  2�����Ҫ֧�ִ�StringתΪDate����ô��Ҫ�ֶ�ע��һ������ת���� 
		 * 		
		 */
		/**
		 * ע��һ������ת����
		 * ����һ�� ��Ҫע���ת����
		 *    DateLocaleConverter: ֧�ִ�String->Date
		 * �������� ת����������
		 *     
		 */
		ConvertUtils.register(new MyDateConvert(), java.util.Date.class);
		
		BeanUtils.copyProperty(s2, "id", "2"); //����Ҫ����Student����
		BeanUtils.copyProperty(s2, "name", "jacky");
		BeanUtils.copyProperty(s2, "gender", "true");
		BeanUtils.copyProperty(s2, "scroe", "90.23"); 
		BeanUtils.copyProperty(s2, "birth","2015/06/24 16:11:30");  //String->Date��Ĭ���������֧��ֱ�Ӵ�StringתΪDate��
		
		System.out.println(s2);
	}
	
}
/**
 * �Զ�������ת����
 * @author APPle
 *
 */
class MyDateConvert implements Converter{

	/**
	 * target: ת��Ϊʲô����
	 * value: ��Ҫת����ֵ
	 * �÷������ص�ת�����ֵ
	 */
	@Override
	public Object convert(Class target, Object value) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			//�����Ҫת����Date���ͣ������ת��
			if(target==Date.class){
				String date = (String)value;
				//��string����ĳ��ת��Date
				Date curDate = sdf.parse(date);
				return curDate;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
