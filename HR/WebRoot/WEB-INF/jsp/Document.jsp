<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'User.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


  <script>
  function areYouSure(id)
  {
  
      if(window.confirm("确定要删除本条记录吗？"))
      {
      window.location.href="DeleteDocument?id="+id;
      }
     
     
  }
  </script>
  </head>
  
  <body>
  <table>
  <tr><td>
  <form action="Document" method="post">
      标题：<input type="text" name="title">
      <input type="submit" value="搜索">
  </form>
  </td></tr>
  </table>
  
  <table>
  <tr>
  <th>id</th><th>标题</th><th>文件名</th><th>描述</th><th>上传时间</th><th>发布者</th>
  </tr>
  <c:forEach items="${requestScope.documents}"
  var="document" >
  <tr>
  <td>${document.id}</td>
  <td>${document.title}</td>
  <td>${document.fileName}</td>
  <td>${document.remark}</td>  
  <td><f:formatDate value="${document.createDate}" 
								type="date" dateStyle="long"/></td> 
  <td>${document.user.username}</td>  
  <td><input type="button" value="下载" onclick="window.location.href='DownloadDocument?id=${document.id}'"></td>
  <td><input type="button" value="删除" onclick="areYouSure(${document.id})"></td>
  </tr>
  </c:forEach>
  </table>
  <!-- 分页标签 -->
  <table>
	  <tr valign="top"><td align="center" >
	  	 <fkjava:pager
	  	        pageIndex="${requestScope.pageModel.pageIndex}" 
	  	        pageSize="${requestScope.pageModel.pageSize}" 
	  	        recordCount="${requestScope.pageModel.recordCount}" 
	  	        submitUrl="${ctx}/Document?pageIndex={0}"/>
	  </td></tr>
  </table>
  <a href="main">回首页</a>
  </body>
</html>
