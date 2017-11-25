package gz.itcast.g_convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * 自定义日期类型转换器
 * @author APPle
 *
 */
public class MyDateConverter extends StrutsTypeConverter{
	
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");

	/**
	 * 从页面的数据到服务器的类型转换
	 * 参数一： context： 值栈上下文对象
	 * 参数二： values:  从页面传递过来的参数值
	 * 参数三： toClass: 转换到的类型。String->java.util.Date
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		System.out.println("进入了转换器");
		try {
			//1)判断values是否为空
			if(values==null || values.length==0){
				return null;
			}
			
			if(values.length>1){
				//多个值的情况
				Date[] dates = new Date[values.length];
				//2)取出数据进行转换
				for(int i=0;i<dates.length;i++){
					Date date = sdf1.parse(values[i]);
					dates[i] = date;
				}
				return dates;
			}else{
				//一个值的情况
				Date date = sdf1.parse(values[0]);
				return date;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		return null;
	}
	/**
	 * 从服务器到页面的类型转换
	 */
	@Override
	public String convertToString(Map context, Object o) {
		return null;
	}

}
