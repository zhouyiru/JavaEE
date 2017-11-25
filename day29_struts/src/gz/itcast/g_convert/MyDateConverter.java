package gz.itcast.g_convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * �Զ�����������ת����
 * @author APPle
 *
 */
public class MyDateConverter extends StrutsTypeConverter{
	
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");

	/**
	 * ��ҳ������ݵ�������������ת��
	 * ����һ�� context�� ֵջ�����Ķ���
	 * �������� values:  ��ҳ�洫�ݹ����Ĳ���ֵ
	 * �������� toClass: ת���������͡�String->java.util.Date
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		System.out.println("������ת����");
		try {
			//1)�ж�values�Ƿ�Ϊ��
			if(values==null || values.length==0){
				return null;
			}
			
			if(values.length>1){
				//���ֵ�����
				Date[] dates = new Date[values.length];
				//2)ȡ�����ݽ���ת��
				for(int i=0;i<dates.length;i++){
					Date date = sdf1.parse(values[i]);
					dates[i] = date;
				}
				return dates;
			}else{
				//һ��ֵ�����
				Date date = sdf1.parse(values[0]);
				return date;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		return null;
	}
	/**
	 * �ӷ�������ҳ�������ת��
	 */
	@Override
	public String convertToString(Map context, Object o) {
		return null;
	}

}
