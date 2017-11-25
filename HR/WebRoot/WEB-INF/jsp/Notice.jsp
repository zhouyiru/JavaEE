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
    
    <title>公告</title>
    
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
      window.location.href="DeleteNotice?id="+id;
      }
     
     
  }
  </script>
  </head>
  
  <body>
  <table>
  <tr><td>
  <form action="Notice" method="post">
       公告名称：<input type="text" name="title"> 公告内容：<input type="text" name="content">
      <input type="submit" value="搜索">
  </form>
  </td></tr>
  </table>
  
  <table>
  <tr>
  <th>序号</th><th>公告标题</th><th>公告内容</th><th>发布时间</th><th>公告人</th>
  </tr>
  <c:forEach items="${requestScope.notices}"
  var="notice" >
  <tr>
  <td>${notice.id}</td>
  <td>${notice.title}</td>
  <td>${notice.content}</td>
  <td><f:formatDate value="${notice.createDate}" 
								type="date" dateStyle="long"/></td> 
  <td>${notice.user.username}</td>   
  <td><input type="button" value="修改" onclick="window.location.href='ModifyNotice?id=${notice.id}'"></td>
  <td><input type="button" value="删除" onclick="areYouSure(${notice.id})"></td>
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
	  	        submitUrl="${ctx}/Notice?pageIndex={0}"/>
	  </td></tr>
  </table>
  <a href="main">回首页</a>
  </body>
</html>

