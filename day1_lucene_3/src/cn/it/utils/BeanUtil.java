package cn.it.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;

public class BeanUtil {

	/*
	 * Class clazz = obj.getClass();//根据某对象获取该对象的Class对象
	 * clazz.getDeclaredFields();
	 * (java.lang.reflect.Field)f.setAccessible(true);
	 * (java.lang.reflect.Field)f.getName(); reflectMethod
	 * =clazz.getMethod(methodName, null)//获取Method对象，有可能异常 Object returnValue =
	 * reflectMethod.invoke(obj, null);// 获取obj对象该方法的返回结果 document.add(new
	 * Field(fieldName, returnValue.toString(), Store.YES, Index.ANALYZED));
	 */
	/**
	 * @Title: beanToDocument
	 * @auth:chufeng
	 * @Description: 把javabean普通对象转化Document对象
	 * @param @param object
	 * @param @return
	 * @return Document 返回类型
	*/ 
	public static Document beanToDocument(Object object) {
		Document document = new Document();
		Class clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			// 属性名
			String fieldName = field.getName();
			// 对应方法名
			String methodName = "get" + fieldName.substring(0, 1).toUpperCase()
					+ fieldName.substring(1);
			Method method = getMyMethod(clazz, methodName);
			//如果不存丰相关的方法，则跳过，处理下一个属性
			if(method==null){
				continue;
			}
			Object invoke = null;
			try {
				invoke = method.invoke(object, null);
			} catch (Exception e) {
				e.printStackTrace();				
			}
			if(invoke==null){
				continue;
			}
			document.add(new org.apache.lucene.document.Field(fieldName, invoke.toString(), Store.YES, Index.ANALYZED));
		}

		return document;

	}

	private static Method getMyMethod(Class clazz, String methodName) {
		Method method = null;
		try {
			method = clazz.getMethod(methodName, null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();			
		}
		return method;
	}
	
/*	Object obj = clazz.newInstance();//返回class的object对象
	java.lang.reflect.Field[] reflectFields = clazz.getDeclaredFields();
	f.setAccessible(true);
				String fieldName = f.getName();
				String fieldValue = document.get(fieldName);
	org.apache.commons.beanutils.BeanUtils.setProperty(obj, fieldName,fieldValue);//借助工具，不为空转换到普通java对象
*/
	/**
	 * @Title: DocumentToBean
	 * @auth:chufeng
	 * @Description: Document对象转为普通javabean对象
	 * @param @param clazz
	 * @param @param document
	 * @param @return
	 * @return Object 返回类型
	*/ 
	public static Object DocumentToBean(Class clazz,Document document){
		Object object = null;
		try {
			object = clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				String fieldName = field.getName();
				String fieldValue = document.get(fieldName);
				BeanUtils.setProperty(object, fieldName, fieldValue);				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return object;
	}
	
	
}
