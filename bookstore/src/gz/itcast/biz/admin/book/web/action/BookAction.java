package gz.itcast.biz.admin.book.web.action;

import gz.itcast.biz.admin.book.service.BookService;
import gz.itcast.biz.admin.book.service.BookServiceImpl;
import gz.itcast.biz.admin.types.service.TypesService;
import gz.itcast.biz.admin.types.service.TypesServiceImpl;
import gz.itcast.entity.Books;
import gz.itcast.entity.Types;
import gz.itcast.util.BaseAction;
import gz.itcast.util.WebUtil;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;
/**
 * ��̨ͼ��ģ���action
 * @author APPle
 *
 */
public class BookAction extends BaseAction implements ModelDriven<Books> {
	
	TypesService typeService = new TypesServiceImpl();
	BookService bookService = new BookServiceImpl();
	
	//�����ϴ�ͼƬ����
	private File attach;//ͼƬ
	private String attachFileName;//ͼƬ����
	private String attachContentType;//ͼƬ����
	private Books books = new Books();//����ͼ���������Ϣ
	
	//ע�뱣��ͼƬ��Ŀ¼����
	private String savePath;
	//���ǰ��ѯ����
	public String toAdd()throws Exception{
		//1)��ѯ������Ϣ
		List<Types> types = typeService.queryTypes();
		//2)��ŵ�request��
		requestMap.put("types", types);
		//3)������ͼ
		return "toAdd";
	}
	
	
	//����ͼ�鷽��
	public String saveBook()throws Exception{
		//1)�����ļ���Ӳ��
		//�õ�ָ��Ŀ¼�ڻ����ϵľ���·��
		String path = ServletActionContext.getServletContext().getRealPath(savePath);
		//�����ļ���
		String newFileName = WebUtil.uuid()+attachFileName.substring(attachFileName.lastIndexOf("."));
		FileUtils.copyFile(attach, new File(path+"/"+newFileName));

		//2)����ҵ�񷽷�
		books.setImg(newFileName);
		bookService.saveBook(books);
		
		return "saveBook";
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Books getModel() {
		return books;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


	public File getAttach() {
		return attach;
	}


	public void setAttach(File attach) {
		this.attach = attach;
	}


	public String getAttachFileName() {
		return attachFileName;
	}


	public void setAttachFileName(String attachFileName) {
		this.attachFileName = attachFileName;
	}


	public String getAttachContentType() {
		return attachContentType;
	}


	public void setAttachContentType(String attachContentType) {
		this.attachContentType = attachContentType;
	}


}
