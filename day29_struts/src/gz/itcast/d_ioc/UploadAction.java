package gz.itcast.d_ioc;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ģ���ļ��ϴ�
 * @author APPle
 *
 */
public class UploadAction extends ActionSupport{
	//1����action���ṩһ������
	private String savePath;
	//2)�ṩ���Ե�setter�����������ⲿ��action�Ĳ�������ע��
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	//�ļ��ϴ��ķ���
	public String upload()throws Exception{
		//1)�Ѿ���ȡ���û����ļ�
		File file  = new File("e:/2.jpg");
		System.out.println(savePath);
		//2)���ļ����������Ӳ��
		//�������ѷ���������ĵ�ַӲ����
		FileUtils.copyFile(file, new File(savePath+file.getName()));
		
		return SUCCESS;
	}
	
}
