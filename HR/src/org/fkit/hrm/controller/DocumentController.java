package org.fkit.hrm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.fkit.hrm.domain.Dept;
import org.fkit.hrm.domain.Document;
import org.fkit.hrm.domain.User;
import org.fkit.hrm.service.HrmService;
import org.fkit.hrm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DocumentController {

	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
	//�ϴ��ĵ�
	@RequestMapping(value="/doUploadDocument")
	String uploaDocument(Model model,HttpSession session,
			@ModelAttribute Document document) 
			throws IllegalStateException, IOException
	{
		System.out.println("upload!");
		System.out.println(document);
		
	
		//�ϴ��ļ�·��
		String path=session.getServletContext().getRealPath("/upload/");
		//�ϴ��ļ���
		String fileName=document.getFile().getOriginalFilename();
		//���ϴ����ļ�������һ��Ŀ���ļ���
		document.getFile().transferTo(new File(path+File.separator+fileName));
		
		//�������ݿ�
		//����fileName
		document.setFileName(fileName);
		//������ص�User����
		User user=(User)(session.getAttribute("user"));
		document.setUser(user);
        //�������ݿ�
		hrmService.addDocument(document);
		//����
		
		System.out.println("OK");
		return "redirect:Document";
	}
	
	
	//��ʾ����ҳ��
	@RequestMapping(value="/Document")
	public String ShowDocument(
			   Integer pageIndex,
			   @ModelAttribute Document document,
			   Model model)
	   {
		   System.out.println("document:"+document);
		   PageModel pageModel=new PageModel();
		   if(pageIndex!=null)
		   {
			   pageModel.setPageIndex(pageIndex);
		   }
		  
		   List<Document> documents=hrmService.findDocument(document, pageModel);
		   System.out.println(document);
		   model.addAttribute("documents", documents);
		   model.addAttribute("pageModel",pageModel);
		  
		   return "Document";
		   }
	
	   //ɾ������
	   @RequestMapping(value="/DeleteDocument")
	   public String deleteDept(@RequestParam("id") int id)
	   {
		   System.out.println(id);
		   hrmService.deleteDocument(id);
		   return "redirect:Document";
	   }
	   
	   //���ع���
	    @RequestMapping(value="DownloadDocument")
		 public ResponseEntity<byte[]>  downLoad(
				 Integer id,
				 HttpSession session) throws Exception{
			// ����id��ѯ�ĵ�
			Document target =hrmService.findDocumentById(id);
			String fileName = target.getFileName();
			// �ϴ��ļ�·��
			String path = session.getServletContext().getRealPath(
	                "/upload/");
			// ���Ҫ�����ļ���File����
			File file = new File(path+File.separator+ fileName);
			// ����springframework��HttpHeaders����
			HttpHeaders headers = new HttpHeaders();  
	        // ������ʾ���ļ������������������������  
	        String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
	        // ֪ͨ�������attachment�����ط�ʽ����ͼƬ
	        headers.setContentDispositionFormData("attachment", downloadFielName); 
	        // application/octet-stream �� �����������ݣ�������ļ����أ���
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        // 201 HttpStatus.CREATED
	        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
	                headers, HttpStatus.CREATED); 
		 }
	   
}
