<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
      王佳琦身材怎么样？<a href="test">点击揭晓答案</a>
      <a href="requestHeader">测试requestHeader</a>
      <a href="cookieValue">测试cookieValue</a>
      <hr>
      <form action="login" method="post">
      name:<input type="text" name="name"><br>
      pwd:<input type="text" name="name"><br>
      <input type="submit" value="login">
      </form>
  </body>
</html>
