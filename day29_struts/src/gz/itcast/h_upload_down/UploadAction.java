package gz.itcast.h_upload_down;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件上传
 * @author APPle
 *
 */
public class UploadAction extends ActionSupport{
	/**
	 * 接收上传内容
	 */
	//1)接收上传文件  名字来自于表达的file的name属性名称
	private File attach;
	//2)接收文件类型
	private String attachContentType;
	//3)接收文件名称
	private String attachFileName;
	//4)接收描述
	private String info;
	/**
	 * 一定要给setter方法.这些setter方法就是上传文件内容进行赋值
	 */
	/**
	 * 注入服务器目录地址
	 */
	private String savePath;

	@Override
	public String execute() throws Exception {
		System.out.println(attach);
		System.out.println(attachContentType);
		System.out.println(attachFileName);
		System.out.println(info);
		
		/**
		 * 把文件保存到服务器硬盘
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
