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
	
	//上传文档
	@RequestMapping(value="/doUploadDocument")
	String uploaDocument(Model model,HttpSession session,
			@ModelAttribute Document document) 
			throws IllegalStateException, IOException
	{
		System.out.println("upload!");
		System.out.println(document);
		
	
		//上传文件路径
		String path=session.getServletContext().getRealPath("/upload/");
		//上传文件名
		String fileName=document.getFile().getOriginalFilename();
		//将上传的文件保存在一个目标文件中
		document.getFile().transferTo(new File(path+File.separator+fileName));
		
		//插入数据库
		//设置fileName
		document.setFileName(fileName);
		//设置相关的User对象
		User user=(User)(session.getAttribute("user"));
		document.setUser(user);
        //插入数据库
		hrmService.addDocument(document);
		//返回
		
		System.out.println("OK");
		return "redirect:Document";
	}
	
	
	//显示下载页面
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
	
	   //删除部门
	   @RequestMapping(value="/DeleteDocument")
	   public String deleteDept(@RequestParam("id") int id)
	   {
		   System.out.println(id);
		   hrmService.deleteDocument(id);
		   return "redirect:Document";
	   }
	   
	   //下载功能
	    @RequestMapping(value="DownloadDocument")
		 public ResponseEntity<byte[]>  downLoad(
				 Integer id,
				 HttpSession session) throws Exception{
			// 根据id查询文档
			Document target =hrmService.findDocumentById(id);
			String fileName = target.getFileName();
			// 上传文件路径
			String path = session.getServletContext().getRealPath(
	                "/upload/");
			// 获得要下载文件的File对象
			File file = new File(path+File.separator+ fileName);
			// 创建springframework的HttpHeaders对象
			HttpHeaders headers = new HttpHeaders();  
	        // 下载显示的文件名，解决中文名称乱码问题  
	        String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
	        // 通知浏览器以attachment（下载方式）打开图片
	        headers.setContentDispositionFormData("attachment", downloadFielName); 
	        // application/octet-stream ： 二进制流数据（最常见的文件下载）。
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        // 201 HttpStatus.CREATED
	        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
	                headers, HttpStatus.CREATED); 
		 }
	   
}
