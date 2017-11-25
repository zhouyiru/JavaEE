package gz.itcast.h_upload_down;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

/**
 * �ļ��ϴ�
 * @author APPle
 *
 */
public class UploadAction extends ActionSupport{
	/**
	 * �����ϴ�����
	 */
	//1)�����ϴ��ļ�  ���������ڱ���file��name��������
	private File attach;
	//2)�����ļ�����
	private String attachContentType;
	//3)�����ļ�����
	private String attachFileName;
	//4)��������
	private String info;
	/**
	 * һ��Ҫ��setter����.��Щsetter���������ϴ��ļ����ݽ��и�ֵ
	 */
	/**
	 * ע�������Ŀ¼��ַ
	 */
	private String savePath;

	@Override
	public String execute() throws Exception {
		System.out.println(attach);
		System.out.println(attachContentType);
		System.out.println(attachFileName);
		System.out.println(info);
		
		/**
		 * ���ļ����浽������Ӳ��
		 */
		FileUtils.copyFile(attach, new File(savePath+attachFileName));
		
		return super.execute();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public File getAttach() {
		return attach;
	}
	public void setAttach(File attach) {
		this.attach = attach;
	}
	public String getAttachContentType() {
		return attachContentType;
	}
	public void setAttachContentType(String attachContentType) {
		this.attachContentType = attachContentType;
	}
	public String getSavePath() {
		return savePath;
	}













	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}













	public String getAttachFileName() {
		return attachFileName;
	}
	public void setAttachFileName(String attachFileName) {
		this.attachFileName = attachFileName;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
