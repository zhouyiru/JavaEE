package gz.itcast.h_upload_down;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �ļ�����
 * @author APPle
 *
 */
public class DownAction extends ActionSupport{
	private String serverPath;
	//�����ļ���
	private String name;
	//�г��ļ�
	public String list()throws Exception{
		File file = new File(serverPath);
		String[] list = file.list();
		//���ļ��б�ת��jspҳ����ʾ
		ActionContext ac = ActionContext.getContext();
		
		Map<String, Object> requestMap = ac.getContextMap();
		requestMap.put("list", list);
		return "list";
	}
	
	//��Ҫ�ṩ��strutsд�����ݵ�������
	public InputStream getInputStream(){
		try {
			FileInputStream fis = new FileInputStream(new File(serverPath+name));
			return fis;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//���ط���
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
