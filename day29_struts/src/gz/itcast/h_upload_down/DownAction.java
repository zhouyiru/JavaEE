package gz.itcast.h_upload_down;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件下载
 * @author APPle
 *
 */
public class DownAction extends ActionSupport{
	private String serverPath;
	//接收文件名
	private String name;
	//列出文件
	public String list()throws Exception{
		File file = new File(serverPath);
		String[] list = file.list();
		//把文件列表转到jsp页面显示
		ActionContext ac = ActionContext.getContext();
		
		Map<String, Object> requestMap = ac.getContextMap();
		requestMap.put("list", list);
		return "list";
	}
	
	//需要提供给struts写出数据的输入流
	public InputStream getInputStream(){
		try {
			FileInputStream fis = new FileInputStream(new File(serverPath+name));
			return fis;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//下载方法
	public String down()throws Exception{
		return "down";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String getServerPath() {
		return serverPath;
	}

	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
}
