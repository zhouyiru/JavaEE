<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
    main<br>
    user:${sessionScope.user.username }
    <br>
         用户管理<br>
         <a href="addUser">添加用户</a><br>
         <a href="User">查询用户</a><br>
         部门管理<br>
         <a href="addDept">添加部门</a><br>
         <a href="Dept">查询部门</a><br>     
         职位管理<br>
         <a href="addJob">添加职位</a><br>
         <a href="Job">查询职位</a><br>   
         员工管理<br>
         <a href="addEmployee">添加员工</a><br>
         <a href="Employee">查询员工</a><br>     
          通告管理<br>
         <a href="addNotice">添加通告</a><br>
         <a href="Notice">查询通告</a><br>    
          文档管理<br>
         <a href="addDocument">上传文档</a><br>
         <a href="Document">下载文档</a><br>     
  </body>
</html>
